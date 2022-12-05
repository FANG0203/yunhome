package com.mrfang.yunhome.service;


import com.mrfang.yunhome.domain.SignContract;

import java.util.List;

public interface ISignContractService {

    /**
     * 添加
     * @param signContract
     */
    void add(SignContract signContract);

    /**
     * 根据状态查询签约记录
     * @param status
     * @return
     */
    List<SignContract> list(Long status);

    /**
     * 根据id修改状态
     * @param id
     * @param status
     */
    void updateStatus(long id, Long status);
}
