package com.mrfang.yunhome.mapper;

import java.util.List;

import com.mrfang.yunhome.domain.HomeCommentExt;
import com.mrfang.yunhome.domain.HomeSignExt;
import com.mrfang.yunhome.domain.Tenant;
import org.apache.ibatis.annotations.Param;

/**
 * 租户表Mapper接口
 * 
 * @author FANG
 * @date 2022-11-18
 */
public interface TenantMapper 
{
    /**
     * 查询租户表
     * 
     * @param id 租户表主键
     * @return 租户表
     */
    public Tenant selectTenantById(Long id);

    /**
     * 查询租户表列表
     * 
     * @param tenant 租户表
     * @return 租户表集合
     */
    public List<Tenant> selectTenantList(Tenant tenant);

    /**
     * 新增租户表
     * 
     * @param tenant 租户表
     * @return 结果
     */
    public int insertTenant(Tenant tenant);

    /**
     * 修改租户表
     * 
     * @param tenant 租户表
     * @return 结果
     */
    public int updateTenant(Tenant tenant);

    /**
     * 删除租户表
     * 
     * @param id 租户表主键
     * @return 结果
     */
    public int deleteTenantById(Long id);

    /**
     * 批量删除租户表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTenantByIds(String[] ids);

    /**
     * 根据租户id查询签约记录
     * @param tenantId
     * @return
     */
    public List<HomeSignExt> getSignRecord(@Param("page") long page, @Param("pageSize")long pageSize, @Param("tenantId")long tenantId);

    /**
     * 签约总条数
     * @return
     */
    public long getSignRecordCount(long tenantId);

    /**
     * 根据租户id查询评论
     * @param page
     * @param pageSize
     * @param tenantId
     * @return
     */
    public List<HomeCommentExt> getMyComment(@Param("page") long page, @Param("pageSize")long pageSize, @Param("tenantId")long tenantId);

    /**
     * 评论总条数
     * @return
     */
    public long getMyCommentCount(long tenantId);
}
