package com.mrfang.yunhome.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 评论对象 t_comment
 * 
 * @author FANG
 * @date 2022-11-17
 */

@Data
public class Comment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 房源id */
    private Long homeId;

    /** 租户id */
    private Long tenantId;

    /** 评论内容 */
    private String comment;

    /** 评论时间 */
    private LocalDateTime commentTime;

    private String nickName;
    private String userName;
    private String img;



}
