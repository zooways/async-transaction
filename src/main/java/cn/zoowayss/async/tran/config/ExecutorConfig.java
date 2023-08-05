package cn.zoowayss.async.tran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: <a href="https://github.com/zooways">zooways</a>
 * @Date: 2023/7/28 14:03
 */
@Configuration
public class ExecutorConfig {

    @Bean("asyncExecutor")
    public ExecutorService asyncExecutor() {
        return Executors.newFixedThreadPool(10);
    }
}
