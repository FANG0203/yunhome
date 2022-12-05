package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SignContract;

/**
 * 签约列表Service接口
 * 
 * @author FANG
 * @date 2022-11-17
 */
public interface ISignContractService 
{
    /**
     * 查询签约列表
     * 
     * @param id 签约列表主键
     * @return 签约列表
     */
    public SignContract selectSignContractById(Long id);

    /**
     * 查询签约列表列表
     * 
     * @param signContract 签约列表
     * @return 签约列表集合
     */
    public List<SignContract> selectSignContractList(SignContract signContract);

    /**
     * 新增签约列表
     * 
     * @param signContract 签约列表
     * @return 结果
     */
    public int insertSignContract(SignContract signContract);

    /**
     * 修改签约列表
     * 
     * @param signContract 签约列表
     * @return 结果
     */
    public int updateSignContract(SignContract signContract);

    /**
     * 批量删除签约列表
     * 
     * @param ids 需要删除的签约列表主键集合
     * @return 结果
     */
    public int deleteSignContractByIds(String ids);

    /**
     * 删除签约列表信息
     * 
     * @param id 签约列表主键
     * @return 结果
     */
    public int deleteSignContractById(Long id);
}
