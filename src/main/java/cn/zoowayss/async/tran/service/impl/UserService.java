package cn.zoowayss.async.tran.service.impl;

import cn.zoowayss.async.tran.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserService extends IService<User>{


    void runAsync();
}
