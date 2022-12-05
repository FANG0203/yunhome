package com.mrfang.yunhome.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 房源管理对象 t_home
 * 
 * @author FANG
 * @date 2022-11-17
 */
@Data
public class Home extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 房源标题
     */
    private String title;

    /**
     * 城市
     */
    private String city;

    /**
     * 区
     */
    private String zone;

    /**
     * 详情地址
     */
    private String address;

    /**
     * 租金
     */
    private Long money;

    /**
     * 面积
     */
    private String area;

    /**
     * 房型
     */
    private Long homeType;

    /**
     * 出租模式
     */
    private Long hireMode;

    /**
     * 房源图片
     */
    private String imgs;

    /**
     * 房屋说明
     */
    private String homeExplain;

    /**
     * 配套设施
     */
    private String facilities;

    /**
     * 交通情况
     */
    private String trafficConditions;

    /**
     * 地图坐标
     */
    private String pointer;

    /**
     * 房源状态
     */
    private Long homeStatus;

    /**
     * 上线状态
     */
    private Long onlineStatus;

    /**
     * 支付方式
     */
    private Long payMode;

    /**
     * 房屋所有者id
     */
    private Long userId;

    /*
    * 房屋类型
    * */
    private String homeTypeName;

    /*
    * 出租模式
    * */
    private String hireModeName;

    /*
    *
    * */
    private String avatar;

    private String userName;


}