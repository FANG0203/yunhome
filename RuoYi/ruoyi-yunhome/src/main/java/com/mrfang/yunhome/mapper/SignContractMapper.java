package com.mrfang.yunhome.mapper;

import com.mrfang.yunhome.domain.SignContract;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SignContractMapper {

    /**
     * 插入
     * @param signContract
     */
    @Insert("insert into t_sign_contract(user_id, tenant_id, home_id, contract_id, start_time, end_time, status) " +
            "values(#{userId}, #{tenantId}, #{homeId}, #{contractId}, #{startTime}, #{endTime}, #{status})")
    void insert(SignContract signContract);

    /**
     * 根据状态查询签约记录
     * @param status
     * @return
     */
    @Select("select * from t_sign_contract where status = #{status}")
    List<SignContract> list(Long  status);

    /**
     * 根据id修改状态
     * @param id
     * @param status
     */
    @Update("update t_sign_contract set status = #{status} where id = #{id}")
    void updateStatus(@Param("id") long id, @Param("status") Long status);
}
