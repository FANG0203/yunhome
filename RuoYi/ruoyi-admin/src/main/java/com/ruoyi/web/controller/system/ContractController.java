package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.javassist.expr.NewArray;
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
import com.ruoyi.system.domain.Contract;
import com.ruoyi.system.service.IContractService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 租房合同Controller
 * 
 * @author FANG
 * @date 2022-11-17
 */
@Controller
@RequestMapping("/system/contract")
public class ContractController extends BaseController
{
    private String prefix = "system/contract";

    @Autowired
    private IContractService contractService;

    @RequiresPermissions("system:contract:view")
    @GetMapping()
    public String contract()
    {
        return prefix + "/contract";
    }

    /**
     * 查询租房合同列表
     */
    @RequiresPermissions("system:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Contract contract)
    {
        startPage();
        List<Contract> list = contractService.selectContractList(contract);
        return getDataTable(list);
    }

    /**
     * 导出租房合同列表
     */
    @RequiresPermissions("system:contract:export")
    @Log(title = "租房合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Contract contract)
    {
        List<Contract> list = contractService.selectContractList(contract);
        ExcelUtil<Contract> util = new ExcelUtil<Contract>(Contract.class);
        return util.exportExcel(list, "租房合同数据");
    }

    /**
     * 新增租房合同
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存租房合同
     */
    @RequiresPermissions("system:contract:add")
    @Log(title = "租房合同", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Contract contract)
    {
        return toAjax(contractService.insertContract(contract));
    }

    /**
     * 修改租房合同
     */
    @RequiresPermissions("system:contract:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        Contract contract = contractService.selectContractById(id);
        mmap.put("contract", contract);
        return prefix + "/edit";
    }

    /**
     * 修改保存租房合同
     */
    @RequiresPermissions("system:contract:edit")
    @Log(title = "租房合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Contract contract)
    {
        return toAjax(contractService.updateContract(contract));
    }

    /**
     * 删除租房合同
     */
    @RequiresPermissions("system:contract:remove")
    @Log(title = "租房合同", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(contractService.deleteContractByIds(ids));
    }
}
