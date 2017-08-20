package com.blog.redis.mvc.dao;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Created by LiHang on 2017/8/11.
 *
 * Redis 操作基类
 *
 */
public abstract class RedisBaseDao<T> {

    @Resource
    protected RedisTemplate<String,T> redisTemplate;


    public void setRedisTemplate(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /*===  String  ===*/



    /*===  List  ===*/



    /*===  Set ===*/



    /*===  map  ===*/
}
