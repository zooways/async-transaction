package cn.zoowayss.async.tran.controller;

import cn.zoowayss.async.tran.annotation.MainTransaction;
import cn.zoowayss.async.tran.service.impl.UserService;
import org.springframework.transaction.annotation.Transactional;
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
    @MainTransaction(3)//调用的方法中sonMethod1/sonMethod2/sonMethod3使用@Async开启了线程, 所以参数为: 3
    @Transactional(rollbackFor = Exception.class)
    public String test() {
        userService.sonMethod1("1",Thread.currentThread());
        userService.sonMethod2("2",Thread.currentThread());
        userService.sonMethod3("3",Thread.currentThread());
        return "ok";
    }
}
