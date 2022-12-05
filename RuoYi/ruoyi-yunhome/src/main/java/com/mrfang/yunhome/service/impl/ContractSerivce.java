package com.mrfang.yunhome.service.impl;


import com.mrfang.yunhome.domain.Contract;
import com.mrfang.yunhome.mapper.ContractMapper;
import com.mrfang.yunhome.service.IContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContractSerivce implements IContractService {

    @Resource
    private ContractMapper contractMapper;

    @Override
    public Contract getByHomeId(int homeId) {
        return contractMapper.getByHomeId(homeId);
    }
}
