package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SignContract;
import com.ruoyi.system.service.ISignContractService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 签约列表Controller
 * 
 * @author FANG
 * @date 2022-11-17
 */
@Controller
@RequestMapping("/system/signContract")
public class SignContractController extends BaseController
{
    private String prefix = "system/signContract";

    @Autowired
    private ISignContractService signContractService;

    @RequiresPermissions("system:signContract:view")
    @GetMapping()
    public String signContract()
    {
        return prefix + "/signContract";
    }

    /**
     * 查询签约列表列表
     */
    @RequiresPermissions("system:signContract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SignContract signContract)
    {
        startPage();
        if (this.getUserId()!=1){
            signContract.setUserId(this.getUserId());
        }
        List<SignContract> list = signContractService.selectSignContractList(signContract);
        return getDataTable(list);
    }

    /**
     * 导出签约列表列表
     */
    @RequiresPermissions("system:signContract:export")
    @Log(title = "签约列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SignContract signContract)
    {
        List<SignContract> list = signContractService.selectSignContractList(signContract);
        ExcelUtil<SignContract> util = new ExcelUtil<SignContract>(SignContract.class);
        return util.exportExcel(list, "签约列表数据");
    }

    /**
     * 新增签约列表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存签约列表
     */
    @RequiresPermissions("system:signContract:add")
    @Log(title = "签约列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SignContract signContract,Long id)
    {
        return toAjax(signContractService.insertSignContract(signContract));
    }

    /**
     * 修改签约列表
     */
    @RequiresPermissions("system:signContract:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SignContract signContract = signContractService.selectSignContractById(id);
        mmap.put("signContract", signContract);
        return prefix + "/edit";
    }

    /**
     * 修改保存签约列表
     */
    @RequiresPermissions("system:signContract:edit")
    @Log(title = "签约列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SignContract signContract)
    {
        return toAjax(signContractService.updateSignContract(signContract));
    }

    /**
     * c签约列表
     */
    @RequiresPermissions("system:signContract:remove")
    @Log(title = "签约列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(signContractService.deleteSignContractByIds(ids));
    }
}
