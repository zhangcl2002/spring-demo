package com.aegonthtf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class AppConfig {
    /**
     * Type safe representation of application.properties
     */
    @Autowired
    ClusterConfigurationProperties clusterProperties;

    public @Bean
    RedisConnectionFactory connectionFactory() {

        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterProperties.getNodes()));
    }
    
    @Bean
    public StringRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    	StringRedisTemplate rt = new StringRedisTemplate();

        rt.setConnectionFactory(redisConnectionFactory);
        
        return rt;
    }    
}