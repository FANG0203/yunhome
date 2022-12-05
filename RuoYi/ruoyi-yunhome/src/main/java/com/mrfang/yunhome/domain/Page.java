package com.mrfang.yunhome.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/11/22 14:06
 * @ Project: RuoYi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

    private Long page;
    private Long size;
    private Long count;
    private Long pageSize;
    private List<T> list;

}
