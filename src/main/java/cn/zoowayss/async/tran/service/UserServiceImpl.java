package cn.zoowayss.async.tran.service;

import cn.zoowayss.async.tran.annotation.SonTransaction;
import cn.zoowayss.async.tran.entity.User;
import cn.zoowayss.async.tran.mapper.UserMapper;
import cn.zoowayss.async.tran.service.impl.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private ExecutorService executorService;

    @Resource
    DataSourceTransactionManager dataSourceTransactionManager;
    @Resource
    TransactionDefinition transactionDefinition;

    @Override
    public void runAsync() {
        CountDownLatch taskNum = new CountDownLatch(2);
        AtomicInteger count = new AtomicInteger(0);

        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {

            executorService.execute(() -> {
                try {
                    save(User.builder().name("zoowayss").build());
                    count.incrementAndGet();
                } finally {
                    taskNum.countDown();
                }
            });
            executorService.execute(() -> {
                try {
                    save(User.builder().name("zoowayss").build());
                    count.incrementAndGet();
                } finally {
                    taskNum.countDown();
                }
            });
            taskNum.await();
            if (count.get() == 2) {
                dataSourceTransactionManager.commit(transaction);
            } else {
                dataSourceTransactionManager.rollback(transaction);
            }

        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transaction);
        }
    }


    @Transactional(rollbackFor = Exception.class)
    @Async("asyncExecutor")
    @SonTransaction
    @Override
    public void sonMethod1(String args, Thread thread) {
        save(User.builder().name("zoowayss").build());
    }
    @Transactional(rollbackFor = Exception.class)
    @Async("asyncExecutor")
    @SonTransaction
    @Override
    public void sonMethod2(String args, Thread thread) {
        save(User.builder().name("zoowayss").build());
    }
    @Transactional(rollbackFor = Exception.class)
    @Async("asyncExecutor")
    @SonTransaction
    @Override
    public void sonMethod3(String args, Thread thread) {
        save(User.builder().name("zoowayss1").build());
    }
}
