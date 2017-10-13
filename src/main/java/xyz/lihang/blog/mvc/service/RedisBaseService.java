package xyz.lihang.blog.mvc.service;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * Created by LiHang on 2017/8/20.
 */
public abstract class RedisBaseService<T> {

    protected Class clazz ;
    protected String className ;

    protected RedisTemplate<String,T> redisTemplate;

    protected ListOperations<String, T> listOperations ;

    @Resource
    public void setRedisTemplate(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
        ids =  new RedisAtomicLong(KEY_NAME(), redisTemplate.getConnectionFactory());
        listOperations = redisTemplate.opsForList();
    }

    public RedisBaseService() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        Type types[] = pt.getActualTypeArguments();
        clazz = (Class<T>) types[0];
        className = clazz.getSimpleName();
    }

    protected RedisAtomicLong ids ;

    /**
     * 获取Id自增字段
     * @return
     */
    protected Long getKey(){
        return  ids.incrementAndGet();
    }


    protected final String KEY_NAME (){
        return className + "_Key";
    }

}
