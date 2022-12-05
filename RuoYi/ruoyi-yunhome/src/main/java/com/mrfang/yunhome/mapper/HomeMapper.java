package com.mrfang.yunhome.mapper;

import com.mrfang.yunhome.domain.Home;
import com.mrfang.yunhome.domain.HomeExt;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/11/22 14:44
 * @ Project: RuoYi
 */
public interface HomeMapper {
    /**
     * 分页查询
     * @param homeExt
     * @param page
     * @param size
     * @return
     */
    List<Home> list(@Param("home") HomeExt homeExt, @Param("page") long page, @Param("size") long size);

    /**
     * 查询总条数
     * @param homeExt
     * @return
     */
    long count(@Param("home")HomeExt homeExt);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Home getById(long id);

    /**
     * 修改状态
     * @param id
     * @param homeStatus
     */
    @Update("update t_home set home_status = #{homeStatus} where id = #{id}")
    void updateStatus(@Param("id") long id, @Param("homeStatus") int homeStatus);
}
