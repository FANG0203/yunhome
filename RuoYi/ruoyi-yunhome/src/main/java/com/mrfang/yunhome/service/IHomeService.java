package com.mrfang.yunhome.service;

import com.mrfang.yunhome.domain.Home;
import com.mrfang.yunhome.domain.HomeExt;
import com.mrfang.yunhome.domain.Page;

/**
 * @ Author: Fang
 * @ Date: 2022/11/22 14:45
 * @ Project: RuoYi
 */
public interface IHomeService {

    Page<Home> list(HomeExt homeExt, long page, long size);

    Home getById(long id);


}
