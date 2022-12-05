package com.mrfang.yunhome.service.impl;

import com.mrfang.yunhome.domain.Home;
import com.mrfang.yunhome.domain.HomeExt;
import com.mrfang.yunhome.domain.Page;
import com.mrfang.yunhome.mapper.HomeMapper;
import com.mrfang.yunhome.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/11/22 14:46
 * @ Project: RuoYi
 */
@Service
public class HomeServiceImpl implements IHomeService {
    @Autowired(required = false)
    private HomeMapper homeMapper;


    @Override
    public Page<Home> list(HomeExt homeExt, long page, long size) {
        //得到分页数据
        List<Home> list = homeMapper.list(homeExt, (page - 1) * size, size);
        //得到总条数
        long count = homeMapper.count(homeExt);
        //计算总页数
        long pageSize = (long) Math.ceil(count * 1.0 / size);
        return new Page<Home>(page, size, count, pageSize, list);
    }

    @Override
    public Home getById(long id) {
        return homeMapper.getById(id);
    }


}
