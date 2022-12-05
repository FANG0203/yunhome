package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ruoyi.system.domain.Comment;
import com.ruoyi.system.domain.Contract;
import com.ruoyi.system.domain.SignContract;
import com.ruoyi.system.service.ICommentService;
import com.ruoyi.system.service.IContractService;
import com.ruoyi.system.service.ISignContractService;
import com.ruoyi.system.utils.FindSame;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Home;
import com.ruoyi.system.service.IHomeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房源管理Controller
 *
 * @author FANG
 * @date 2022-11-17
 */
@Controller
@RequestMapping("/system/home")
public class HomeController extends BaseController {
    private String prefix = "system/home";

    @Autowired
    private IHomeService homeService;
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IContractService contractService;


    @RequiresPermissions("system:home:view")
    @GetMapping()
    public String home() {
        return prefix + "/home";
    }

    /**
     * 查询房源管理列表
     */
    @RequiresPermissions("system:home:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Home home) {
        startPage();

        if (this.getUserId()!=1){
            home.setUserId(this.getUserId());
        }

        List<Home> list = homeService.selectHomeList(home);
        return getDataTable(list);
    }

    /**
     * 导出房源管理列表
     */
    @RequiresPermissions("system:home:export")
    @Log(title = "房源管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Home home) {
        List<Home> list = homeService.selectHomeList(home);
        ExcelUtil<Home> util = new ExcelUtil<Home>(Home.class);
        return util.exportExcel(list, "房源管理数据");
    }

    /**
     * 新增房源管理
     */
    @GetMapping("/add")
    public String add(Model model) {
        List<Contract> list = contractService.selectContractList(new Contract());
        model.addAttribute("list",list);
        return prefix + "/add";
    }

    /**
     * 新增保存房源管理
     */
    @RequiresPermissions("system:home:add")
    @Log(title = "房源管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Home home) {
        home.setUserId(this.getUserId());
        ////获取合同id
        //SignContract signContract = new SignContract();
        //signContract.setHomeId(home.getId());
        //List<SignContract> signContractList = signContractService.selectSignContractList(signContract);
        //signContract.setId(signContractList.get(0).getId());
        //signContract.setContractId(contractId);
        ////修改合同
        //signContractService.updateSignContract(signContract);
        return toAjax(homeService.insertHome(home));
    }

    /**
     * 修改房源管理
     */
    @RequiresPermissions("system:home:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap,Model model) {
        Home home = homeService.selectHomeById(id);
        mmap.put("home", home);
        List<Contract> list = contractService.selectContractList(new Contract());
        model.addAttribute("list",list);
        return prefix + "/edit";
    }

    /**
     * 修改保存房源管理
     */
    @RequiresPermissions("system:home:edit")
    @Log(title = "房源管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Home home) {
        return toAjax(homeService.updateHome(home));
    }

    /**
     * 删除房源管理
     */
    @RequiresPermissions("system:home:remove")
    @Log(title = "房源管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        /*
         * 创建数组arr1
         * 存储前端传来请求删除的ids
         * 长度为ids的中id的个数
         * */
        int[] arr1 = new int[ids.split(",").length];

        //查询出房源为上线的房源列表
        Home home = new Home();
        home.setOnlineStatus(2L);
        List<Home> homeList = homeService.selectHomeList(home);

        /*
         * 创建数组arr2
         * 存储已上线房源的ids
         * 长度为上线房源列表的长度
         * */
        int[] arr2 = new int[homeList.size()];

        //创建存储上线房源id的onlineStatusList
        List<Long> onlineStatusList = new ArrayList<>();

        /*
         * 遍历前端传输的ids，存储至arr1
         * 使用Integer.valueOf()转化类型
         * */
        for (int i = 0; i < ids.split(",").length; i++) {
            arr1[i] = Integer.valueOf(ids.split(",")[i]);
        }

        /*
         * 遍历房源列表中的对象
         * 将每个房源对象的id加入onlineStatusList列表
         * */
        for (Home onlineStatusUp : homeList) {
            onlineStatusList.add(onlineStatusUp.getId());
        }

        /*
         * 将onlineStatusList列表中的id添加至arr2
         * */
        for (int i = 0; i < homeList.size(); i++) {
            arr2[i] = onlineStatusList.get(i).intValue();
        }

        //调用查重方法
        FindSame findSame = new FindSame();
        List<Integer> list = findSame.findCommon(arr1, arr2);

        /*
         * 判断存储重复的list是否为空
         * 为空就执行删除
         * 不为空就返回禁止提示
         * */
        if (list.size() == 0) {
            return toAjax(homeService.deleteHomeByIds(ids));
        } else {
            return error("Id为" + list + "的房源已上线，禁止删除！！！");
        }

    }


    /*
     * 上线房源管理
     * */
    @RequiresPermissions("system:home:up")
    @Log(title = "房源上线", businessType = BusinessType.DELETE)
    @PostMapping("/up")
    @ResponseBody
    public AjaxResult up(Long id) {
        Home home = new Home();
        home.setId(id);
        home.setOnlineStatus(2L);
        return toAjax(homeService.updateHome(home));
    }

    /*
     * 下线房源管理
     * */
    @RequiresPermissions("system:home:down")
    @Log(title = "房源上线", businessType = BusinessType.DELETE)
    @PostMapping("/down")
    @ResponseBody
    public AjaxResult down(Long id) {
        Home home = new Home();
        home.setId(id);
        home.setOnlineStatus(1L);
        return toAjax(homeService.updateHome(home));
    }

    /*
     * 跳转评论页面
     * */
    @GetMapping("/showComment")
    public String showComment(Long id, Model model) {
        model.addAttribute("homeId", id);
        return prefix + "/showComment";
    }

    /**
     * 查询评论列表
     */
    @RequiresPermissions("system:home:commentList")
    @PostMapping("/commentList")
    @ResponseBody
    public TableDataInfo commentList(Comment comment) {
        startPage();
        List<Comment> list = commentService.selectCommentList(comment);
        return getDataTable(list);
    }
}
