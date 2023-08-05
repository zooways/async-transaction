package cn.zoowayss.async.tran.controller;

import cn.zoowayss.async.tran.service.impl.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: <a href="https://github.com/zooways">zooways</a>
 * @Date: 2023/7/28 14:03
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Resource
    private UserService userService;

    @GetMapping
    public String test() {
        userService.runAsync();
        return "ok";
    }
}
