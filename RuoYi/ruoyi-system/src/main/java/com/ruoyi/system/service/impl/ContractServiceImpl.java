package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ContractMapper;
import com.ruoyi.system.domain.Contract;
import com.ruoyi.system.service.IContractService;
import com.ruoyi.common.core.text.Convert;

/**
 * 租房合同Service业务层处理
 * 
 * @author FANG
 * @date 2022-11-17
 */
@Service
public class ContractServiceImpl implements IContractService 
{
    @Autowired
    private ContractMapper contractMapper;

    /**
     * 查询租房合同
     * 
     * @param id 租房合同主键
     * @return 租房合同
     */
    @Override
    public Contract selectContractById(Integer id)
    {
        return contractMapper.selectContractById(id);
    }

    /**
     * 查询租房合同列表
     * 
     * @param contract 租房合同
     * @return 租房合同
     */
    @Override
    public List<Contract> selectContractList(Contract contract)
    {
        return contractMapper.selectContractList(contract);
    }

    /**
     * 新增租房合同
     * 
     * @param contract 租房合同
     * @return 结果
     */
    @Override
    public int insertContract(Contract contract)
    {
        return contractMapper.insertContract(contract);
    }

    /**
     * 修改租房合同
     * 
     * @param contract 租房合同
     * @return 结果
     */
    @Override
    public int updateContract(Contract contract)
    {
        return contractMapper.updateContract(contract);
    }

    /**
     * 批量删除租房合同
     * 
     * @param ids 需要删除的租房合同主键
     * @return 结果
     */
    @Override
    public int deleteContractByIds(String ids)
    {
        return contractMapper.deleteContractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除租房合同信息
     * 
     * @param id 租房合同主键
     * @return 结果
     */
    @Override
    public int deleteContractById(Integer id)
    {
        return contractMapper.deleteContractById(id);
    }
}
