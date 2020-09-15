package com.demo.modules.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 统一视图控制器
 */
@Controller
@RequestMapping("/")
public class ViewController {

    @RequestMapping("view/{folder}/{page}.htm")
    public String view( @PathVariable("folder") String folder, @PathVariable("page") String page) {
        return "sys/"  + folder + "/" + page;
    }


}

