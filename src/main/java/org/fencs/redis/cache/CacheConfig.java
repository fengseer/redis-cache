package org.fencs.redis.cache;


import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * .
 *
 * @author: haifeng
 * @date: 2019-04-25 14:34
 */
@Configuration
public class CacheConfig extends CachingConfigurerSupport {

    private static Logger log = LoggerFactory.getLogger(CacheConfig.class);

    private final RedisConnectionFactory redisConnectionFactory;

    CacheConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    /**
     * 配置 RedisCacheManager，使用 cache 注解管理 redis 缓存
     */
    @Bean
    @Override
    public CacheManager cacheManager() {
        // 初始化一个RedisCacheWriter
        RedisCacheWriter cacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        // 设置默认过期时间：30 分钟
        RedisCacheConfiguration defaultCacheConfig =
                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(30))
                        .serializeKeysWith(TedisCacheManager.STRING_PAIR).serializeValuesWith(TedisCacheManager.FASTJSON_PAIR);

        return new TedisCacheManager(cacheWriter, defaultCacheConfig);
    }
}