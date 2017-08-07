package com.aegonthtf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RedisDemoApplication {
	
	//@Autowired
	//private User user;
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@RequestMapping("/setvalue")
	public String setvalue(@RequestParam(value = "key", defaultValue = "world") String name) {

	    //user.test();
	    ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
	    
	    
	    valueOp.set("name", name);
       // String ret = valueOp.get("hello");
	    
		return " name has been set to "+name+" in redis cluster";
	}	
	
	@RequestMapping("/getvalue")
	public String getvalue(@RequestParam(value = "key", defaultValue = "name") String name) {

	    //user.test();
	    ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
	    
	    //valueOp.set("name", name);
        String ret = valueOp.get("name");
	    
		return "key:"+name+"      value:"+ret;
	}
	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}
}
