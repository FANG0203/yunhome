package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 签约列表对象 t_sign_contract
 * 
 * @author FANG
 * @date 2022-11-17
 */
public class SignContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 房东id */
    @Excel(name = "房东id")
    private Long userId;

    /** 租户id */
    @Excel(name = "租户id")
    private Long tenantId;

    /** 房屋id */
    @Excel(name = "房屋id")
    private Long homeId;

    /** 合同Id */
    @Excel(name = "合同Id")
    private Long contractId;

    /** 签约开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签约开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 签约结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签约结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 签约状态 */
    @Excel(name = "签约状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }
    public void setHomeId(Long homeId) 
    {
        this.homeId = homeId;
    }

    public Long getHomeId() 
    {
        return homeId;
    }
    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("tenantId", getTenantId())
            .append("homeId", getHomeId())
            .append("contractId", getContractId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("status", getStatus())
            .toString();
    }
}
