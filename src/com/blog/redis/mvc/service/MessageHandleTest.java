package com.blog.redis.mvc.service;

import com.blog.model.Message;
import com.blog.redis.RedisTest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by LiHang on 2017/8/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:bean.xml" ,"classpath:spring-mvc.xml" })
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
//@TransactionConfiguration(defaultRollback = true)
//记得要在XML文件中声明事务哦~~~我是采用注解的方式
@Transactional
public class MessageHandleTest {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ApplicationContext ac;
    @Autowired
    private RedisTemplate redisTemplate;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // webAppContextSetup 注意上面的static import
        // webAppContextSetup 构造的WEB容器可以添加fileter 但是不能添加listenCLASS
        // WebApplicationContext context =
        // ContextLoader.getCurrentWebApplicationContext();
        // 如果控制器包含如上方法 则会报空指针
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    static Log log = LogFactory.getLog(RedisTest.class);


    @Test
    public void add() throws Exception {
        MessageHandle  messageHandle =(MessageHandle)ac.getBean("messageHandle");
        Message message = new Message();
        message.setName("哈哈哈");
        message.setIp("192.168.1.1");
        message.setEmail("11329075357@qq.com");
        message.setContent("192.168.1.1");
        messageHandle.add(message);
    }

    @Test
    public void list() throws Exception {
        MessageHandle  messageHandle =(MessageHandle)ac.getBean("messageHandle");
        messageHandle.list(1,10);
    }



}