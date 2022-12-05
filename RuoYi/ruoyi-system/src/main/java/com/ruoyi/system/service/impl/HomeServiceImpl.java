package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HomeMapper;
import com.ruoyi.system.domain.Home;
import com.ruoyi.system.service.IHomeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 房源管理Service业务层处理
 * 
 * @author FANG
 * @date 2022-11-17
 */
@Service
public class HomeServiceImpl implements IHomeService 
{
    @Autowired
    private HomeMapper homeMapper;

    /**
     * 查询房源管理
     * 
     * @param id 房源管理主键
     * @return 房源管理
     */
    @Override
    public Home selectHomeById(Long id)
    {
        return homeMapper.selectHomeById(id);
    }

    /**
     * 查询房源管理列表
     * 
     * @param home 房源管理
     * @return 房源管理
     */
    @Override
    public List<Home> selectHomeList(Home home)
    {
        return homeMapper.selectHomeList(home);
    }

    /**
     * 新增房源管理
     * 
     * @param home 房源管理
     * @return 结果
     */
    @Override
    public int insertHome(Home home)
    {
        return homeMapper.insertHome(home);
    }

    /**
     * 修改房源管理
     * 
     * @param home 房源管理
     * @return 结果
     */
    @Override
    public int updateHome(Home home)
    {
        return homeMapper.updateHome(home);
    }

    /**
     * 批量删除房源管理
     * 
     * @param ids 需要删除的房源管理主键
     * @return 结果
     */
    @Override
    public int deleteHomeByIds(String ids)
    {
        return homeMapper.deleteHomeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除房源管理信息
     * 
     * @param id 房源管理主键
     * @return 结果
     */
    @Override
    public int deleteHomeById(Long id)
    {
        return homeMapper.deleteHomeById(id);
    }
}
