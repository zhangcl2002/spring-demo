package com.aegonthtf;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;


@Service
public class User {
	   @Autowired
	    private RedisConnectionFactory connectionFactory;

	    public void test() {
	        RedisClusterConnection connection = connectionFactory.getClusterConnection();

	        connection.set("a1".getBytes(), "111".getBytes());
	        connection.set("a2".getBytes(), "222".getBytes());

	        Set<byte[]> ret = connection.keys("a1".getBytes());

	        System.out.println("aaaaaaaaa");
	        for(byte[] each:ret) {
	            System.out.printf("\r\n"  + new String(each));
	        }
	    }
}