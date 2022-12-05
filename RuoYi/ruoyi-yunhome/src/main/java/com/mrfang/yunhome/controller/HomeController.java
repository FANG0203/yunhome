package com.mrfang.yunhome.controller;

import com.mrfang.yunhome.domain.*;
import com.mrfang.yunhome.service.ICommentService;
import com.mrfang.yunhome.service.IContractService;
import com.mrfang.yunhome.service.IHomeService;
import com.mrfang.yunhome.service.ISignContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/11/22 14:02
 * @ Project: RuoYi
 */
@Controller
@RequestMapping("/yunhome/home")
public class HomeController {

    @Autowired(required = false)
    private IHomeService homeService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private ISignContractService signContractService;

    //分页查询
    @GetMapping("list")
    public String list(HomeExt homeExt, @RequestParam(defaultValue = "1") long page,
                       @RequestParam(defaultValue = "12") long size, Model model) {
        Page<Home> page1 = homeService.list(homeExt, page, size);
        model.addAttribute("page1", page1);
        model.addAttribute("homeExt", homeExt);
        return "home_list";
    }

    @GetMapping("detailsPage")
    public String detailsPage(long id, Model model){
        //查询房源信息
        Home home = homeService.getById(id);
        //查询评论列表信息
        Comment comment = new Comment();
        comment.setHomeId(id);
        commentService.selectCommentList(comment);
        List<Comment> list = commentService.selectCommentList(comment);

        model.addAttribute("home", home);
        model.addAttribute("list", list);
        return "home_details";
    }

    /**
     * 签约页面
     * @return
     */
    @GetMapping("signingPage")
    public String signingPage(int homeId, Model model){
        Contract contract = contractService.getByHomeId(homeId);
        model.addAttribute("contract", contract);
        return "signing";
    }

    /**
     * 签约
     * @param signContract
     * @param model
     * @return
     */
    @ResponseBody
    @PostMapping("signing")
    public String signing(SignContract signContract, @SessionAttribute("tenant") Tenant tenant, Model model){
        signContract.setTenantId(tenant.getId());
        signContract.setStatus(1);
        signContractService.add(signContract);
        return "ok";
    }

    /**
     * 签约记录
     * @return
     */
    @GetMapping("signingRecordPage")
    public String signingPageMsg(int homeId, Model model){
        Contract contract = contractService.getByHomeId(homeId);
        model.addAttribute("contract", contract);
        return "personal-center/signing_record";
    }




}
