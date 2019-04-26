package org.fencs.controller;

import org.fencs.bean.User;
import org.fencs.redis.cache.CacheExpire;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author: haifeng
 * @date: 2019-04-25 14:34
 */

@RestController
public class CacheController {


    @RequestMapping("/cache")
    @Cacheable("cache")
    @CacheExpire(10)
    public User cacheTest() {
        return new User("test", 2, "北京", System.currentTimeMillis() / 1000);
    }
}
