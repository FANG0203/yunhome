package com.mrfang.yunhome.domain;

import lombok.Data;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 租户表对象 t_tenant
 * 
 * @author FANG
 * @date 2022-11-21
 */

@Data
public class Tenant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 姓名 */
    @Excel(name = "姓名")
    private String fullName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idNumber;

    /** 手机号 */
    @Excel(name = "手机号")
    private String tel;

    /** 头像 */
    @Excel(name = "头像")
    private String img;

    /** 个人说明 */
    @Excel(name = "个人说明")
    private String tenantExplain;

}
