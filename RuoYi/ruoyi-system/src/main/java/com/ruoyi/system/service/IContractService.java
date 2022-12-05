package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Contract;

/**
 * 租房合同Service接口
 * 
 * @author FANG
 * @date 2022-11-17
 */
public interface IContractService 
{
    /**
     * 查询租房合同
     * 
     * @param id 租房合同主键
     * @return 租房合同
     */
    public Contract selectContractById(Integer id);

    /**
     * 查询租房合同列表
     * 
     * @param contract 租房合同
     * @return 租房合同集合
     */
    public List<Contract> selectContractList(Contract contract);

    /**
     * 新增租房合同
     * 
     * @param contract 租房合同
     * @return 结果
     */
    public int insertContract(Contract contract);

    /**
     * 修改租房合同
     * 
     * @param contract 租房合同
     * @return 结果
     */
    public int updateContract(Contract contract);

    /**
     * 批量删除租房合同
     * 
     * @param ids 需要删除的租房合同主键集合
     * @return 结果
     */
    public int deleteContractByIds(String ids);

    /**
     * 删除租房合同信息
     * 
     * @param id 租房合同主键
     * @return 结果
     */
    public int deleteContractById(Integer id);
}
