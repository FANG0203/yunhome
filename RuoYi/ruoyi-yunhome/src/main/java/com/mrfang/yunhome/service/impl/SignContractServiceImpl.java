package com.mrfang.yunhome.service.impl;


import com.mrfang.yunhome.domain.SignContract;
import com.mrfang.yunhome.mapper.HomeMapper;
import com.mrfang.yunhome.mapper.SignContractMapper;
import com.mrfang.yunhome.service.ISignContractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SignContractServiceImpl implements ISignContractService {

    @Resource
    private SignContractMapper signContractMapper;

    @Resource
    private HomeMapper homeMapper;

    @Transactional
    @Override
    public void add(SignContract signContract) {
        //添加一条签约记录
        signContractMapper.insert(signContract);
        //修改房源状态为已出租
        homeMapper.updateStatus(signContract.getHomeId(), 2);
    }

    @Override
    public List<SignContract> list(Long status) {
        return signContractMapper.list(status);
    }

    @Override
    public void updateStatus(long id, Long status) {
        signContractMapper.updateStatus(id, status);
    }
}
