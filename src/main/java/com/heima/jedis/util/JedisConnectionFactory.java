package com.heima.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {

    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        poolConfig.setMaxTotal(8);

        poolConfig.setMaxIdle(8);

        poolConfig.setMinIdle(0);

        poolConfig.setMaxWaitMillis(1000);

        jedisPool = new JedisPool(poolConfig, "8.134.129.167", 6379, 2000, "542245");
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

}

