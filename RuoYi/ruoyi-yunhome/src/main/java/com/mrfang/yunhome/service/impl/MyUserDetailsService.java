package com.mrfang.yunhome.service.impl;

import com.mrfang.yunhome.domain.Tenant;
import com.mrfang.yunhome.mapper.TenantMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/11/28 19:21
 * @ Project: RuoYi
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private TenantMapper tenantMapper;
    @Resource
    private HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据登录的用户名去数据库查询User对象
        Tenant tenant = new Tenant();
        tenant.setUsername(username);
        List<Tenant> list1 = tenantMapper.selectTenantList(tenant);
        if(list1.isEmpty()){
            throw new UsernameNotFoundException("用户名不存在");
        }
        tenant = list1.get(0);
        session.setAttribute("tenant", tenant);

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(tenant.getUsername())
                .password(tenant.getPassword())
                .authorities("tenant")   //角色
                .build();
    }
}

