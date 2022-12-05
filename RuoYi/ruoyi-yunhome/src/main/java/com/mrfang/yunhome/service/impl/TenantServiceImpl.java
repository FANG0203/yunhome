package com.mrfang.yunhome.service.impl;

import java.util.List;

import com.mrfang.yunhome.domain.HomeCommentExt;
import com.mrfang.yunhome.domain.HomeSignExt;
import com.mrfang.yunhome.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mrfang.yunhome.mapper.TenantMapper;
import com.mrfang.yunhome.domain.Tenant;
import com.mrfang.yunhome.service.ITenantService;
import com.ruoyi.common.core.text.Convert;

/**
 * 租户表Service业务层处理
 * 
 * @author FANG
 * @date 2022-11-18
 */
@Service
public class TenantServiceImpl implements ITenantService 
{
    @Autowired(required = false)
    private TenantMapper tenantMapper;

    /**
     * 查询租户表
     * 
     * @param id 租户表主键
     * @return 租户表
     */
    @Override
    public Tenant selectTenantById(Long id)
    {
        return tenantMapper.selectTenantById(id);
    }

    /**
     * 查询租户表列表
     * 
     * @param tenant 租户表
     * @return 租户表
     */
    @Override
    public List<Tenant> selectTenantList(Tenant tenant)
    {
        return tenantMapper.selectTenantList(tenant);
    }

    /**
     * 新增租户表
     * 
     * @param tenant 租户表
     * @return 结果
     */
    @Override
    public int insertTenant(Tenant tenant)
    {
        return tenantMapper.insertTenant(tenant);
    }

    /**
     * 修改租户表
     * 
     * @param tenant 租户表
     * @return 结果
     */
    @Override
    public int updateTenant(Tenant tenant)
    {
        return tenantMapper.updateTenant(tenant);
    }

    /**
     * 批量删除租户表
     * 
     * @param ids 需要删除的租户表主键
     * @return 结果
     */
    @Override
    public int deleteTenantByIds(String ids)
    {
        return tenantMapper.deleteTenantByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除租户表信息
     * 
     * @param id 租户表主键
     * @return 结果
     */
    @Override
    public int deleteTenantById(Long id)
    {
        return tenantMapper.deleteTenantById(id);
    }

    @Override
    public Page<HomeSignExt> getSignRecord(long page, long pageSize, long tenantId) {
        List<HomeSignExt> list = tenantMapper.getSignRecord((page-1)*pageSize, pageSize, tenantId);
        long count = tenantMapper.getSignRecordCount(tenantId);
        return new Page<HomeSignExt>(page, pageSize, count, (long) Math.ceil(count*1.0/pageSize), list);
    }

    @Override
    public Page<HomeCommentExt> getMyComment(long page, long pageSize, long tenantId) {
        List<HomeCommentExt> list = tenantMapper.getMyComment((page-1)*pageSize, pageSize, tenantId);
        long count = tenantMapper.getMyCommentCount(tenantId);
        return new Page<HomeCommentExt>(page, pageSize, count, (long) Math.ceil(count*1.0/pageSize), list);
    }
}
