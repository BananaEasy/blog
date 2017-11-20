package xyz.lihang.blog.test;

import xyz.lihang.blog.mapper.model.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

/**
 * Created by LiHang on 2017/8/11.
 */
public class RedisTest {

    static Logger log = LoggerFactory.getLogger(((RedisTest.class)));

    static ApplicationContext ac;
    static RedisTemplate redisTemplate;
    static RedisSerializer stringSerializer;

    static {
         ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
         redisTemplate = (RedisTemplate) ac.getBean("jedisTemplate");
         //stringSerializer = redisTemplate.getStringSerializer();

    }


    public static void main(String[] args) {


        // -----------------String类型数据操作 start--------------------
//        ValueOperations<String, String> stringOperations = redisTemplate
//                .opsForValue();
//        // String类型数据存储，不设置过期时间，永久性保存
//        stringOperations.set("string1", "fiala");
//        // String类型数据存储，设置过期时间为80秒，采用TimeUnit控制时间单位
//        stringOperations.set("string2", "fiala", 80, TimeUnit.SECONDS);
//        // 判断key值是否存在，存在则不存储，不存在则存储
//        stringOperations.setIfAbsent("string1", "my fiala");
//        stringOperations.setIfAbsent("string3", "my fiala");
//        String value1 = stringOperations.get("string1");
//        String value2 = stringOperations.get("string3");
//        System.out.println(value1);
//        System.out.println(value2);
//        // -----------------String类型数据操作 end--------------------
//
//        // -----------------其他值类型数据操作 start--------------------
//        Demo demo = new Demo();
//        demo.setId("1");
//        demo.setName("fiala");
//        List<Demo> demos = new ArrayList<Demo>();
//        demos.add(demo);
//        ValueOperations<String, Object> valueOperations = redisTemplate
//                .opsForValue();
//        // 设置value为对象类型，且不设置过期时间，默认永久
//        valueOperations.set("value1", demo);
//        // 设置value为对象类型，设置过期时间为80秒，时间单位由TimeUnit控制
//        valueOperations.set("value2", demos, 80, TimeUnit.SECONDS);
//        Demo demo1 = (Demo) valueOperations.get("value1");
//        demos = ( List<Demo>) valueOperations.get("value2");
//        System.out.println(demo1.toString());
//        System.out.println("demos:" + demos);
//        // -----------------其他值类型数据操作 end--------------------
//
//        // -----------------List数据类型操作 start------------------
//        ListOperations<String, Object> listOperations = redisTemplate
//                .opsForList();
//        for (int i = 0; i < 5; i++) {
//            Demo listDemo = new Demo();
//            listDemo.setId("\"" + i + "\"");
//            listDemo.setName("fiala" + i);
//            listOperations.leftPush("list1", listDemo);
//            listOperations.rightPush("list2", listDemo);
//        }
//        listOperations.
//        // 可给数据排序
//        Demo demo2 = (Demo) listOperations.leftPop("list1");
//        Demo demo3 = (Demo) listOperations.rightPop("list2");
//        System.out.println("demo2：" + demo2.toString());
//        System.out.println("demo3：" + demo3.toString());
//        // -----------------List数据类型操作 end------------------
//
//        // -----------------set数据类型操作 start------------------
//        SetOperations <String, Object> setOperations = redisTemplate.opsForSet();
//        for (int i = 0; i < 5; i++) {
//            Demo setDemo = new Demo();
//            setDemo.setId("\"" + i + "\"");
//            setDemo.setName("fiala" + i);
//            setOperations.add("set1", setDemo);
//        }
//        Demo demo4 = (Demo) setOperations.pop("set1");
//        System.out.println(demo4.toString());
//        // -----------------set数据类型操作 end------------------
//
//        // -----------------zset数据类型操作 start------------------
//        ZSetOperations<String, Object> zSetOperations = redisTemplate
//                .opsForZSet();
//        zSetOperations.add("zset", "fiala", 0);
//        zSetOperations.add("zset", "my fiala", 1);
//        System.out.println(zSetOperations.rangeByScore("zset", 0, 1));
//        // -----------------zset数据类型操作 end------------------
//
//        // -----------------hash数据类型操作 start------------------
//        HashOperations<String, Object, Object> hashOperations = redisTemplate
//                .opsForHash();
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("map1", "fiala1");
//        map.put("map2", "fiala2");
//        hashOperations.putAll("hash", map);
//        System.out.println(hashOperations.entries("hash"));
        // -----------------hash数据类型操作 start------------------


        RedisAtomicLong atomicLong1 = new RedisAtomicLong("somekey1", redisTemplate.getConnectionFactory());
        System.out.println(atomicLong1.incrementAndGet());


    }

    public static void main2(String[] args) {

        RedisTemplate<String,LoginUser> redisTemplate  = RedisTest.redisTemplate;
        LoginUser loginUser = new LoginUser("qqqqq","aaaaaa");


        Boolean execute = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = stringSerializer;
                byte[] key = serializer.serialize(loginUser.getName());
                byte[] name = serializer.serialize(loginUser.toString());
                return connection.setNX(key, name);
            }
        });
        System.out.println("execute:" + execute);

        LoginUser result = redisTemplate.execute(new RedisCallback<LoginUser>() {
            public LoginUser doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = stringSerializer;
                byte[] key = serializer.serialize(loginUser.getName());
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                String json = serializer.deserialize(value);



                return null;
            }
        });
        System.out.println(result);

    }

}
