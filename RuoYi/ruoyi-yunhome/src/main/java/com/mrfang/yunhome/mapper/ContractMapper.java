package com.mrfang.yunhome.mapper;

import com.mrfang.yunhome.domain.Contract;
import org.apache.ibatis.annotations.Select;

public interface ContractMapper {

    @Select("SELECT c.* from t_contract c left join t_home h on c.id = h.contract_id where h.id = #{homeId}")
    Contract getByHomeId(int homeId);
}
