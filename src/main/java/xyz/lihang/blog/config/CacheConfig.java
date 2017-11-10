package xyz.lihang.blog.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.util.ClassUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.logging.Logger;
import static org.springframework.cache.interceptor.DefaultKeyGenerator.NO_PARAM_KEY;
import static org.springframework.cache.interceptor.DefaultKeyGenerator.NULL_PARAM_KEY;

@SpringBootConfiguration
public class CacheConfig {

    private Logger logger = Logger.getLogger(CacheConfig.class.getName());

    //缓存管理器
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间 s为单位
        //缓存为20分钟过期
        cacheManager.setDefaultExpiration(1*60*20);
        return cacheManager;
    }


    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
        //设置redis 键值生成策略
        StringRedisTemplate template = new StringRedisTemplate(factory);
        //设置序列化工具
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }


    @Bean(name = "cacheKeyGenerator")
    public KeyGenerator CacheKeyGenerator(){
        //缓存Key生成策略
        return (Object target, Method method, Object... params) ->  {
             StringBuilder key = new StringBuilder();
                key.append(target.getClass().getSimpleName()).append(".").append(method.getName()).append(":");
                if (params.length == 0) {
                    return key.append(NO_PARAM_KEY).toString();
                }
                for (Object param : params) {
                    if (param == null) {
                        logger.info("input null param for Spring cache, use default key={"+NULL_PARAM_KEY+"}" );
                        key.append(NULL_PARAM_KEY);
                    } else if (ClassUtils.isPrimitiveArray(param.getClass())) {
                        int length = Array.getLength(param);
                        for (int i = 0; i < length; i++) {
                            key.append(Array.get(param, i));
                            key.append(',');
                        }
                    } else if (ClassUtils.isPrimitiveOrWrapper(param.getClass()) || param instanceof String) {
                        key.append(param);
                    } else {
                        logger.info("Using an object as a cache key may lead to unexpected results. " +
                                "Either use @Cacheable(key=..) or implement CacheKey. Method is " + target.getClass() + "#" + method.getName());
                        key.append(param.hashCode());
                    }
                    key.append('-');
                }
                return key.toString();
        };

//
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder key = new StringBuilder();
//                key.append(target.getClass().getSimpleName()).append(".").append(method.getName()).append(":");
//                if (params.length == 0) {
//                    return key.append(NO_PARAM_KEY).toString();
//                }
//                for (Object param : params) {
//                    if (param == null) {
//                        logger.info("input null param for Spring cache, use default key={"+NULL_PARAM_KEY+"}" );
//                        key.append(NULL_PARAM_KEY);
//                    } else if (ClassUtils.isPrimitiveArray(param.getClass())) {
//                        int length = Array.getLength(param);
//                        for (int i = 0; i < length; i++) {
//                            key.append(Array.get(param, i));
//                            key.append(',');
//                        }
//                    } else if (ClassUtils.isPrimitiveOrWrapper(param.getClass()) || param instanceof String) {
//                        key.append(param);
//                    } else {
//                        logger.info("Using an object as a cache key may lead to unexpected results. " +
//                                "Either use @Cacheable(key=..) or implement CacheKey. Method is " + target.getClass() + "#" + method.getName());
//                        key.append(param.hashCode());
//                    }
//                    key.append('-');
//                }
//                return key.toString();
//            }
//        };
    }

}
