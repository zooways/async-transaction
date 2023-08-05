package cn.zoowayss.async.tran.service.impl;

import cn.zoowayss.async.tran.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User>{


    void runAsync();

    void sonMethod1(String args, Thread thread);

    void sonMethod2(String args, Thread thread);

    void sonMethod3(String args, Thread thread);
}
