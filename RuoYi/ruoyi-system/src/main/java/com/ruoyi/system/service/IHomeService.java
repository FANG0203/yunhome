package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Home;

/**
 * 房源管理Service接口
 * 
 * @author FANG
 * @date 2022-11-17
 */
public interface IHomeService 
{
    /**
     * 查询房源管理
     * 
     * @param id 房源管理主键
     * @return 房源管理
     */
    public Home selectHomeById(Long id);

    /**
     * 查询房源管理列表
     * 
     * @param home 房源管理
     * @return 房源管理集合
     */
    public List<Home> selectHomeList(Home home);

    /**
     * 新增房源管理
     * 
     * @param home 房源管理
     * @return 结果
     */
    public int insertHome(Home home);

    /**
     * 修改房源管理
     * 
     * @param home 房源管理
     * @return 结果
     */
    public int updateHome(Home home);

    /**
     * 批量删除房源管理
     * 
     * @param ids 需要删除的房源管理主键集合
     * @return 结果
     */
    public int deleteHomeByIds(String ids);

    /**
     * 删除房源管理信息
     * 
     * @param id 房源管理主键
     * @return 结果
     */
    public int deleteHomeById(Long id);
}
