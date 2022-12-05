package com.mrfang.yunhome.controller;

import com.mrfang.yunhome.domain.Comment;
import com.mrfang.yunhome.domain.Tenant;
import com.mrfang.yunhome.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.LocalDateTime;

/**
 * @ Author: Fang
 * @ Date: 2022/11/24 9:11
 * @ Project: RuoYi
 */
@Controller
@RequestMapping("/yunhome/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @RequestMapping("add")
    public String Add(Comment comment, @SessionAttribute("tenant")Tenant tenant){

        if ("".equals(tenant)){
            return "redirect:register_";
        }
        comment.setTenantId(tenant.getId());
        comment.setCommentTime(LocalDateTime.now());
        commentService.insertComment(comment);
        return "redirect:/yunhome/home/detailsPage?id="+comment.getHomeId();

    }

}
