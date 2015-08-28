package com.tarvel.redis.dao.impl;

import com.tarvel.redis.dao.MyRedisDao;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Redis key-value存取接口
 * Created by Yuan on 2015/8/4 0004.
 */
@Repository("myRedisDao")
public class MyRedisDaoImpl implements MyRedisDao{

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

}
