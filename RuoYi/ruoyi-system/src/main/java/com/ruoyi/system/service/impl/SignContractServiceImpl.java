package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SignContractMapper;
import com.ruoyi.system.domain.SignContract;
import com.ruoyi.system.service.ISignContractService;
import com.ruoyi.common.core.text.Convert;

/**
 * 签约列表Service业务层处理
 * 
 * @author FANG
 * @date 2022-11-17
 */
@Service
public class SignContractServiceImpl implements ISignContractService 
{
    @Autowired
    private SignContractMapper signContractMapper;

    /**
     * 查询签约列表
     * 
     * @param id 签约列表主键
     * @return 签约列表
     */
    @Override
    public SignContract selectSignContractById(Long id)
    {
        return signContractMapper.selectSignContractById(id);
    }

    /**
     * 查询签约列表列表
     * 
     * @param signContract 签约列表
     * @return 签约列表
     */
    @Override
    public List<SignContract> selectSignContractList(SignContract signContract)
    {
        return signContractMapper.selectSignContractList(signContract);
    }

    /**
     * 新增签约列表
     * 
     * @param signContract 签约列表
     * @return 结果
     */
    @Override
    public int insertSignContract(SignContract signContract)
    {
        return signContractMapper.insertSignContract(signContract);
    }

    /**
     * 修改签约列表
     * 
     * @param signContract 签约列表
     * @return 结果
     */
    @Override
    public int updateSignContract(SignContract signContract)
    {
        return signContractMapper.updateSignContract(signContract);
    }

    /**
     * 批量删除签约列表
     * 
     * @param ids 需要删除的签约列表主键
     * @return 结果
     */
    @Override
    public int deleteSignContractByIds(String ids)
    {
        return signContractMapper.deleteSignContractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除签约列表信息
     * 
     * @param id 签约列表主键
     * @return 结果
     */
    @Override
    public int deleteSignContractById(Long id)
    {
        return signContractMapper.deleteSignContractById(id);
    }
}
