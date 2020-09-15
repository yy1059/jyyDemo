package com.demo.modules.common.controller;

import com.demo.modules.common.pojo.User;
import com.demo.modules.common.utils.SessionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

    @GetMapping
    public User getCurrentController(){
        User currentUser = SessionUtil.getCurrentUser();
        return currentUser;
    }
}
