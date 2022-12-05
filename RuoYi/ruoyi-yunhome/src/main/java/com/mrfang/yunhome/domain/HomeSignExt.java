package com.mrfang.yunhome.domain;

import lombok.Data;

/**
 * @ Author: Fang
 * @ Date: 2022/11/29 21:07
 * @ Project: RuoYi
 */
@Data
public class HomeSignExt extends Home {

    private String startTime;
    private String endTime;
    private String signContractStatus;
    private String hireModeStr;
    private String homeTypeStr;

}