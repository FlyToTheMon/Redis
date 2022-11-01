package com.github.jedis;


import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author Bin Wang
 * @date 2022/11/01 08:55
 **/
public class JedisDemo1 {
    public static void main(String[] args) {
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.70.100",6379);
        //测试
        String value=jedis.ping();
        System.out.println(value);
    }

    //操作key
    @Test
    public void demo1(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.70.100",6379);

        //添加
        jedis.set("name","lucy");

        //获取
        String name = jedis.get("name");
        System.out.println(name);

        //设置多个key-value
        jedis.mset("k1","v1","k2","v2");
        List<String> mget = jedis.mget("k1","k2");
        System.out.println(mget);

        Set<String>keys = jedis.keys("*");
        for(String key: keys){
            System.out.println(key);
        }
    }
    //操作list
    @Test
    public void demo2(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.70.100",6379);

        jedis.lpush("key1","lucy","mary","jack");
        List<String> values = jedis.lrange("key1",0,-1);
        System.out.println(values);

    }
    //操作set
    @Test
    public void demo3(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.70.100",6379);

        jedis.sadd("names","lucy");
        jedis.sadd("names","mary");

        Set<String>names = jedis.smembers("names");
        System.out.println(names);

    }
    //操作hash
    @Test
    public void demo4(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.70.100",6379);

        jedis.hset("users","age","20");

        System.out.println(jedis.hget("users","age"));

    }
    //操作zset
    @Test
    public void demo5(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.70.100",6379);

        jedis.zadd("china",100d,"shanghai");


        System.out.println(jedis.zrange("china",0,-1));

    }
}