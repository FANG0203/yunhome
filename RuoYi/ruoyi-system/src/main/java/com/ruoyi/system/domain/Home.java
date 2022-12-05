package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房源管理对象 t_home
 *
 * @author FANG
 * @date 2022-11-17
 */
public class Home extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** id */
    @Excel(name = "id")
    private Long id;

    /** 房源标题 */
    @Excel(name = "房源标题")
    private String title;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String zone;

    /** 详情地址 */
    @Excel(name = "详情地址")
    private String address;

    /** 租金 */
    @Excel(name = "租金")
    private Long money;

    /** 面积 */
    @Excel(name = "面积")
    private String area;

    /** 房型 */
    @Excel(name = "房型")
    private Long homeType;

    /** 出租模式 */
    @Excel(name = "出租模式")
    private Long hireMode;

    /** 房源图片 */
    @Excel(name = "房源图片")
    private String imgs;

    /** 房屋说明 */
    @Excel(name = "房屋说明")
    private String homeExplain;

    /** 配套设施 */
    @Excel(name = "配套设施")
    private String facilities;

    /** 交通情况 */
    @Excel(name = "交通情况")
    private String trafficConditions;

    /** 地图坐标 */
    @Excel(name = "地图坐标")
    private String pointer;

    /** 房源状态 */
    @Excel(name = "房源状态")
    private Long homeStatus;

    /** 上线状态 */
    @Excel(name = "上线状态")
    private Long onlineStatus;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private Long payMode;

    /** 房屋所有者id */
    @Excel(name = "房屋所有者id")
    private Long userId;

    /** 合同id */
    @Excel(name = "id")
    private Long contractId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    public void setZone(String zone)
    {
        this.zone = zone;
    }

    public String getZone()
    {
        return zone;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setMoney(Long money)
    {
        this.money = money;
    }

    public Long getMoney()
    {
        return money;
    }
    public void setArea(String area)
    {
        this.area = area;
    }

    public String getArea()
    {
        return area;
    }
    public void setHomeType(Long homeType)
    {
        this.homeType = homeType;
    }

    public Long getHomeType()
    {
        return homeType;
    }
    public void setHireMode(Long hireMode)
    {
        this.hireMode = hireMode;
    }

    public Long getHireMode()
    {
        return hireMode;
    }
    public void setImgs(String imgs)
    {
        this.imgs = imgs;
    }

    public String getImgs()
    {
        return imgs;
    }
    public void setHomeExplain(String homeExplain)
    {
        this.homeExplain = homeExplain;
    }

    public String getHomeExplain()
    {
        return homeExplain;
    }
    public void setFacilities(String facilities)
    {
        this.facilities = facilities;
    }

    public String getFacilities()
    {
        return facilities;
    }
    public void setTrafficConditions(String trafficConditions)
    {
        this.trafficConditions = trafficConditions;
    }

    public String getTrafficConditions()
    {
        return trafficConditions;
    }
    public void setPointer(String pointer)
    {
        this.pointer = pointer;
    }

    public String getPointer()
    {
        return pointer;
    }
    public void setHomeStatus(Long homeStatus)
    {
        this.homeStatus = homeStatus;
    }

    public Long getHomeStatus()
    {
        return homeStatus;
    }
    public void setOnlineStatus(Long onlineStatus)
    {
        this.onlineStatus = onlineStatus;
    }

    public Long getOnlineStatus()
    {
        return onlineStatus;
    }
    public void setPayMode(Long payMode)
    {
        this.payMode = payMode;
    }

    public Long getPayMode()
    {
        return payMode;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("city", getCity())
            .append("zone", getZone())
            .append("address", getAddress())
            .append("money", getMoney())
            .append("area", getArea())
            .append("homeType", getHomeType())
            .append("hireMode", getHireMode())
            .append("imgs", getImgs())
            .append("homeExplain", getHomeExplain())
            .append("facilities", getFacilities())
            .append("trafficConditions", getTrafficConditions())
            .append("pointer", getPointer())
            .append("homeStatus", getHomeStatus())
            .append("onlineStatus", getOnlineStatus())
            .append("payMode", getPayMode())
            .append("userId", getUserId())
            .append("contractId", getContractId())
            .toString();
    }
}
