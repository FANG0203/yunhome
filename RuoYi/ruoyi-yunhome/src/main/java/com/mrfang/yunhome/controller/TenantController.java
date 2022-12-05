package com.mrfang.yunhome.controller;

import java.io.IOException;
import java.util.List;

import com.mrfang.yunhome.domain.HomeCommentExt;
import com.mrfang.yunhome.domain.HomeSignExt;
import com.mrfang.yunhome.domain.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.mrfang.yunhome.domain.Tenant;
import com.mrfang.yunhome.service.ITenantService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 租户表Controller
 *
 * @author FANG
 * @date 2022-11-18
 */
@Controller
@RequestMapping("/yunhome/tenant")
public class TenantController extends BaseController {
    private String prefix = "yunhome/tenant";

    @Autowired
    private ITenantService tenantService;

    @Resource
    private PasswordEncoder bCryptPasswordEncoder;



    //登录
    @PostMapping("login")
    public String login(Tenant tenant, RedirectAttributes redirectAttributes, HttpSession session, String checkCode, @SessionAttribute("checkCode") String checkCode1) {
        ////判断验证码是否一致
        //if (!checkCode.equalsIgnoreCase(checkCode1)) {
        //    redirectAttributes.addFlashAttribute("msg", "验证码错误");
        //    return "redirect:/login_";
        //}
        //判断用户名是否为空
        if ("".equals(tenant.getUsername().trim())) {
            redirectAttributes.addFlashAttribute("msg", "用户名或密码错误1");
            return "redirect:/login_";
        }
        //根据用户名和密码查询
        List<Tenant> list = tenantService.selectTenantList(tenant);
        if (list.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/login_";
        }
        session.setAttribute("tenant", list.get(0));
        return "redirect:/index_";
    }

    @RequestMapping("index")
    public String index(){
        return "redirect:/index_";
    }
    //退出
    //@GetMapping("logout")
    //public String logout(HttpSession session){
    //    session.removeAttribute("tenant");
    //    return "redirect:/login_";
    //}
    //注册
    @PostMapping("register")
    public String register(Tenant tenant, String checkCode, @SessionAttribute("checkCode") String checkCode1, RedirectAttributes redirectAttributes) {
        //判断验证码是否一致
        if (!checkCode.equalsIgnoreCase(checkCode1)) {
            redirectAttributes.addFlashAttribute("msg", "验证码错误");
            return "redirect:/register_";
        }

        //判断用户名是否存在
        Tenant tenant1 = new Tenant();
        tenant1.setUsername(tenant.getUsername());
        List<Tenant> list = tenantService.selectTenantList(tenant1);
        if (!list.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "用户名已存在，不允许重复注册");
            return "redirect:/register_";
        }

        //注册
        tenant.setPassword(bCryptPasswordEncoder.encode(tenant.getPassword()));
        tenant.setImg("381082e8-3ead-4b7a-917c-502c386cf414.jpg");
        tenantService.insertTenant(tenant);

        return "redirect:/login_";
    }

    //获取验证码
    @GetMapping("getCheckCode")
    public void getCheckCode(HttpSession session, HttpServletResponse response) throws IOException {
        String checkCode = com.mrfang.yunhome.utils.CheckCodeUtils.getCheckCode(response.getOutputStream());
        //将本次生成的验证码字符串放到session作用域
        session.setAttribute("checkCode", checkCode);
    }

    @GetMapping("update")
    public String update(Tenant tenant, HttpSession session){
        tenantService.updateTenant(tenant);
        Tenant tenant1 = tenantService.selectTenantById(tenant.getId());
        session.setAttribute("tenant", tenant1);
        return "/personal-center/person_info";
    }


    @ResponseBody
    @PostMapping("checkPwd")
    public String checkPwd(String pwd, @SessionAttribute("tenant") Tenant tenant){
        if(bCryptPasswordEncoder.matches(pwd, tenant.getPassword())){
            return "ok";
        }else{
            return "err";
        }
    }

    @ResponseBody
    @PostMapping("updatePwd")
    public String updatePwd(String oldPwd, String newPwd1, String newPwd2, HttpSession session, @SessionAttribute("tenant") Tenant tenant){
        if(bCryptPasswordEncoder.matches(oldPwd, tenant.getPassword())){
            if(!newPwd1.equals(newPwd2)){
                return "两次密码不一致";
            }else{
                tenant.setPassword(bCryptPasswordEncoder.encode(newPwd1));
                tenantService.updateTenant(tenant);
                return "ok";
            }
        }else{
            return "旧密码错误";
        }
    }
    //@RequestMapping("updatePwd")
    //public String updatePwd(String oldPwd,String newPwd,String againPwd,@SessionAttribute("tenant") Tenant tenant,HttpSession session){
    //
    //    if ("".equals(newPwd.trim())&&"".equals(againPwd.trim())&&"".equals(oldPwd.trim())){
    //        session.setAttribute("msg","密码不能为空");
    //        return "/personal-center/update_password";
    //    }
    //    if (!newPwd.equals(againPwd)){
    //        session.setAttribute("msg","俩次密码不一致");
    //        return "/personal-center/update_password";
    //    }
    //    if (!tenantService.selectTenantById(tenant.getId()).getPassword().equals(oldPwd)){
    //        session.setAttribute("msg","旧密码错误");
    //        return "/personal-center/update_password";
    //    }
    //    session.setAttribute("msg","");
    //    Tenant tenant1 = new Tenant();
    //    tenant1.setId(tenant.getId());
    //    tenant1.setPassword(newPwd);
    //    tenantService.updateTenant(tenant1);
    //    return "/personal-center/update_password";
    //}

    /*
    * 实名认证接口
    * */
    @ResponseBody
    @PostMapping("authentication")
    public String authentication(Tenant tenant, @SessionAttribute("tenant") Tenant tenant1){
        tenant.setId(tenant1.getId());
        tenantService.updateTenant(tenant);
        return "ok";
    }


    /**
     * 签约记录
     * @return
     */
    @GetMapping("signingRecord")
    public String signingRecord(@RequestParam(defaultValue = "1") long page, @RequestParam(defaultValue = "4")long pageSize,
                                @SessionAttribute("tenant") Tenant tenant, Model model){
        Page<HomeSignExt> page1 = tenantService.getSignRecord(page, pageSize, tenant.getId());
        model.addAttribute("page1", page1);
        System.out.println(page1.getList());
        return "/personal-center/signing_record";
    }

    @GetMapping("myComment")
    public String myComment(@RequestParam(defaultValue = "1") long page, @RequestParam(defaultValue = "4")long pageSize,
                            @SessionAttribute("tenant") Tenant tenant, Model model){
        Page<HomeCommentExt> page1 = tenantService.getMyComment(page, pageSize, tenant.getId());
        model.addAttribute("page1", page1);
        return "/personal-center/my_comments";
    }





    @RequiresPermissions("yunhome:tenant:view")
    @RequestMapping("/register")
    public String register(Tenant tenant) {
        System.out.println(tenant);
        return "/register";
    }

    @RequiresPermissions("yunhome:tenant:view")
    @GetMapping()
    public String tenant() {
        return prefix + "/tenant";
    }

    /**
     * 查询租户表列表
     */
    @RequiresPermissions("yunhome:tenant:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Tenant tenant) {
        startPage();
        List<Tenant> list = tenantService.selectTenantList(tenant);
        return getDataTable(list);
    }

    /**
     * 导出租户表列表
     */
    @RequiresPermissions("yunhome:tenant:export")
    @Log(title = "租户表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Tenant tenant) {
        List<Tenant> list = tenantService.selectTenantList(tenant);
        ExcelUtil<Tenant> util = new ExcelUtil<Tenant>(Tenant.class);
        return util.exportExcel(list, "租户表数据");
    }

    /**
     * 新增租户表
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存租户表
     */
    @RequiresPermissions("yunhome:tenant:add")
    @Log(title = "租户表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Tenant tenant) {
        return toAjax(tenantService.insertTenant(tenant));
    }

    /**
     * 修改租户表
     */
    @RequiresPermissions("yunhome:tenant:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Tenant tenant = tenantService.selectTenantById(id);
        mmap.put("tenant", tenant);
        return prefix + "/edit";
    }

    /**
     * 修改保存租户表
     */
    @RequiresPermissions("yunhome:tenant:edit")
    @Log(title = "租户表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Tenant tenant) {
        return toAjax(tenantService.updateTenant(tenant));
    }

    /**
     * 删除租户表
     */
    @RequiresPermissions("yunhome:tenant:remove")
    @Log(title = "租户表", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tenantService.deleteTenantByIds(ids));
    }
}
