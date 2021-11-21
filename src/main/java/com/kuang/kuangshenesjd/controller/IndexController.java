package com.kuang.kuangshenesjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @description:
 * @author: Felix_XHF
 * @create:2021-11-21 18:54
 */
@Controller
public class IndexController {
    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
