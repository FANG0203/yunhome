package com.mrfang.yunhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author: Fang
 * @ Date: 2022/11/16 17:22
 * @ Project: RuoYi
 */
@Controller
public class WelcomeController {

    @RequestMapping("{a}_")
    public String welcome(@PathVariable String a){
        return a;
    }

    @RequestMapping("{a}/{b}_")
    public String welcome1(@PathVariable String a,@PathVariable String b){
        return "/"+a+"/"+b;
    }
}
