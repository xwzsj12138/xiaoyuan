package com.wm.project.project;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JedisPoolDemo {

    private static JedisPool jedisPool;

//    public static void main(String[] args) {
//        // 初始化JedisPool
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(100);
//        config.setMaxIdle(20);
//        config.setTestOnBorrow(true);
//        jedisPool = new JedisPool(config, "localhost", 6379);
//
//        // 修改key的value，并对相同的key值每分钟只能修改一次
//        String key = "test";
//        String value = "initial value";
//        Jedis jedis = null;
//
//        try {
//            jedis = jedisPool.getResource();
//            jedis.select(1);
//            // 判断key是否存在
//            if (jedis.exists(key)) {
//                // 获取上一次修改的时间戳
//                String lastModifiedStr = jedis.get(key + "_last_modified");
//                Long lastModified = lastModifiedStr == null ? 0L : Long.parseLong(lastModifiedStr);
//                System.out.println(lastModified+"上次修改时间");
//                Long now = System.currentTimeMillis() / 1000;
//                System.out.println(now-lastModified+"时间差");
//                // 如果时间间隔小于60秒，说明不允许修改
//                if (now - lastModified < 60) {
//                    System.out.println("不允许修改");
//                    return;
//                }
//            } else {
//                jedis.set(key + "_last_modified", "0");
//                jedis.expire(key + "_last_modified", 60);
//            }
//
//            // 如果时间间隔大于等于60秒，就可以修改
//            jedis.set(key, value);
//            jedis.set(key + "_last_modified", String.valueOf(System.currentTimeMillis() / 1000));
//            jedis.expire(key + "_last_modified", 60);
//
//            System.out.println("可以修改" + key + " has been updated to " + value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//            if (jedisPool != null) {
//                jedisPool.close();
//            }
//        }
//    }
//public static void main(String[] args) {
//    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); // 假设这里是给定的列表
//
//    int randomInt = new Random().ints(0, Integer.MAX_VALUE)
//            .filter(n -> !list.contains(n))
//            .findFirst()
//            .orElseThrow(() -> new RuntimeException("无法生成不在列表中的整数"));
//
//    System.out.println("随机生成的整数为：" + randomInt);
////}
//    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); // 假设这里是给定的列表
//
//        int randomInt;
//        do {
//            randomInt = new Random().nextInt(999); // 假设生成的随机整数在0-99之间
//        } while (list.contains(randomInt));
//
//        System.out.println("随机生成的整数为：" + randomInt);
//    }
}

