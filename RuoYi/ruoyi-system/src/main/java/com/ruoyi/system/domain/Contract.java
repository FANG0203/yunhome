package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 租房合同对象 t_contract
 * 
 * @author FANG
 * @date 2022-11-17
 */
public class Contract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Integer id;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractName;

    /** 合同内容 */
    @Excel(name = "合同内容")
    private String contractContext;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setContractName(String contractName) 
    {
        this.contractName = contractName;
    }

    public String getContractName() 
    {
        return contractName;
    }
    public void setContractContext(String contractContext) 
    {
        this.contractContext = contractContext;
    }

    public String getContractContext() 
    {
        return contractContext;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("contractName", getContractName())
            .append("contractContext", getContractContext())
            .toString();
    }
}
