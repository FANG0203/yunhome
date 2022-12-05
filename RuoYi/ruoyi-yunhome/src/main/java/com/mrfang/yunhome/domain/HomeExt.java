package com.mrfang.yunhome.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 房源查询条件实体类
 * @ Author: Fang
 * @ Date: 2022/11/23 9:42
 * @ Project: RuoYi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeExt {

    private String city;
    private String minMoney;
    private String maxMoney;
    private String minArea;
    private String maxArea;
    private String homeType;
    private String hireMode;
}
