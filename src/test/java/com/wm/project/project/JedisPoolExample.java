package com.wm.project.project;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Scanner;

public class JedisPoolExample {
    private static JedisPool jedisPool = null;

    public static void main(String[] args) {
        // 初始化JedisPoolConfig
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10); // 最大连接数
        jedisPoolConfig.setMaxIdle(5); // 最大空闲连接数
        jedisPoolConfig.setTestOnBorrow(true); // 借用连接时是否测试可用性

        // 初始化JedisPool
        jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);

        // 获取连接
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(1);

            String key = "test";
            // 执行命令
            int i = new Scanner(System.in).nextInt();
            //设计是否过期标志
            String lastModifiedStr = jedis.get(key + "_last_modified");
            //可以修改
            if(lastModifiedStr != null){
                System.out.println("6秒内不能修改");
            }else{
                jedis.set(key,i+"");
                jedis.set(key + "_last_modified","不允许修改");
                jedis.expire(key + "_last_modified", 30);
            }
        } finally {
            // 释放连接
            if (jedis != null) {
                jedis.close();
            }
        }

        // 关闭连接池
        jedisPool.close();
    }
}

