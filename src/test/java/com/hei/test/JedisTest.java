package com.hei.test;

import com.heima.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        //jedis=new Jedis("8.134.129.167",6379);

        jedis= JedisConnectionFactory.getJedis();

        jedis.auth("542245");

        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name","huge");
        System.out.println("Result = "+result);

        String name = jedis.get("name");
        System.out.println("name = "+name);
    }

    @Test
    void testHash() {
        jedis.hset("user:1","name","Jack");
        jedis.hset("user:1","age","21");

        System.out.println(jedis.hget("user:1","name"));
        System.out.println(jedis.hget("user:1","age"));

        Map<String,String> map = jedis.hgetAll("user:1");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    @AfterEach
    void tearDown() {
        if(jedis!=null){
            jedis.close();
        }
    }
}
