package com.zy.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.*;

public class JedisTest {

    @Test
    public void testJedisPool(){
        JedisPool jedisPoolInstance = JedisPoolUtils.getJedisPoolInstance();
        Jedis resource = jedisPoolInstance.getResource();
        System.out.println("connection is OK==========>: "+resource.ping());
        JedisPoolUtils.release(resource);
    }

    @Test
    public void testConnect(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.1.142",6379);
        //查看服务是否运行，打出pong表示OK
        System.out.println("connection is OK==========>: "+jedis.ping());

    }

    @Test
    public void testString(){
        Jedis jedis = new Jedis("192.168.1.142",6379);
        Set<String> keys = jedis.keys("*");
        for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            System.out.println(key);
        }
        System.out.println("jedis.exists====>"+jedis.exists("k2"));
        System.out.println(jedis.ttl("k1"));
        //String
        //jedis.append("k1","myreids");
        System.out.println(jedis.get("k1"));
        jedis.set("k4","k4_redis");
        System.out.println("----------------------------------------");
        jedis.mset("str1","v1","str2","v2","str3","v3");
        System.out.println(jedis.mget("str1","str2","str3"));
    }

    @Test
    public void testList(){
        Jedis jedis = new Jedis("192.168.1.142",6379);
        //jedis.lpush("list1","v1","v2","v3","v4","v5");
        List<String> list = jedis.lrange("list1",0,-1);
        for (String element : list) {
            System.out.println(element);
        }
    }

    @Test
    public void testSet(){
        Jedis jedis = new Jedis("192.168.1.142",6379);
        jedis.sadd("orders","jd001");
        jedis.sadd("orders","jd002");
        jedis.sadd("orders","jd003");

        Set<String> set1 = jedis.smembers("orders");
        for (Iterator iterator = set1.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
        jedis.srem("orders","jd002");
        System.out.println("--------------------");
        System.out.println(jedis.smembers("orders").size());

    }

    @Test
    public void testHash(){
        Jedis jedis = new Jedis("192.168.1.142",6379);
        jedis.hset("hash1","userName","lisi");
        System.out.println(jedis.hget("hash1","userName"));

        Map<String,String> map = new HashMap<String,String>();
        map.put("telphone","13811814763");
        map.put("address","atguigu");
        map.put("email","abc@163.com");
        jedis.hmset("hash2",map);

        List<String> result = jedis.hmget("hash2", "telphone","email");
        for (String element : result) {
            System.out.println(element);
        }
    }

    @Test
    public void testZSet(){
        //zset
        Jedis jedis = new Jedis("192.168.1.142",6379);
        jedis.zadd("zset01",60,"v1");
        jedis.zadd("zset01",80,"v3");
        jedis.zadd("zset01",70,"v2");
        jedis.zadd("zset01",90,"v4");

        Set<String> s1 = jedis.zrange("zset01",0,-1);
        for (Iterator iterator = s1.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
    }

    @Test
    public void testTransaction(){
        Jedis jedis = new Jedis("192.168.1.142",6379);

        //监控key，如果该动了事务就被放弃
     /*3
     jedis.watch("serialNum");
     jedis.set("serialNum","s#####################");
     jedis.unwatch();*/

        Transaction transaction = jedis.multi();//被当作一个命令进行执行
        transaction.set("serialNum","s002");
        Response<String> response = transaction.get("serialNum");
        response = transaction.get("serialNum");
        transaction.lpush("list3","a");
        transaction.lpush("list3","b");
        transaction.lpush("list3","c");

        transaction.exec();
        //2 transaction.discard();
        System.out.println("serialNum***********"+response.get());

    }
}