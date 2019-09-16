package com.example.springbootapi.config;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/20
 * Time  : 9:17 AM
 */
@Configuration
@ConfigurationProperties("spring.redis")
@Data
public class JedisConfig extends CachingConfigurerSupport {
    private Logger logger = LoggerFactory.getLogger(JedisConfig.class);


//    @Value("${spring.redis.timeout}")
    private int timeout;

//    @Value("${spring.redis.host}")
    private String host;

//    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null);
        logger.info("jedis 注入成功");
        return  jedisPool;
    }
}
