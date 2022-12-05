package com.mrfang.yunhome.domain;

import lombok.Data;

/**
 * @ Author: Fang
 * @ Date: 2022/11/29 21:08
 * @ Project: RuoYi
 */
@Data
public class HomeCommentExt {

    private long homeId;
    private String imgs;
    private String title;
    private String commentTime;
    private String comment;

}
