package com.mrfang.yunhome.service;

import java.util.List;

import com.mrfang.yunhome.domain.HomeCommentExt;
import com.mrfang.yunhome.domain.HomeSignExt;
import com.mrfang.yunhome.domain.Page;
import com.mrfang.yunhome.domain.Tenant;

/**
 * 租户表Service接口
 * 
 * @author FANG
 * @date 2022-11-18
 */
public interface ITenantService 
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
     * 批量删除租户表
     * 
     * @param ids 需要删除的租户表主键集合
     * @return 结果
     */
    public int deleteTenantByIds(String ids);

    /**
     * 删除租户表信息
     * 
     * @param id 租户表主键
     * @return 结果
     */
    public int deleteTenantById(Long id);

    /**
     * 根据租户id查询签约记录
     * @param tenantId
     * @return
     */
    public Page<HomeSignExt> getSignRecord(long page, long pageSize, long tenantId);

    /**
     * 根据租户id查询评论
     * @param page
     * @param pageSize
     * @param tenantId
     * @return
     */
    public Page<HomeCommentExt> getMyComment(long page, long pageSize, long tenantId);
}
