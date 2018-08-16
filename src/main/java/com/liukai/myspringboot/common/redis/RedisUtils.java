package com.liukai.myspringboot.common.redis;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author liukai
 */
@Configuration
public class RedisUtils {

  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  public RedisUtils(StringRedisTemplate stringRedisTemplate) {
    this.stringRedisTemplate = stringRedisTemplate;
  }

  /**
   * 获取redis锁
   *
   * @param locakName
   * @param acquireTimeout
   * @return
   */
  public String acquireLock(String locakName, long acquireTimeout) {
    String id = RandomStringUtils.random(128);
    long endTime = System.currentTimeMillis() + 5000;
    while (System.currentTimeMillis() < endTime) {
      if (StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(locakName))) {
        stringRedisTemplate.opsForValue().set(locakName, id, 5000, TimeUnit.MILLISECONDS);
        return id;
      }
    }
    return null;
  }

}
