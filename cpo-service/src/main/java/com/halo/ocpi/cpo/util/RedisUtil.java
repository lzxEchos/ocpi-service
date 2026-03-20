package com.halo.ocpi.cpo.util;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.api.RBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    private static RedissonClient redissonClient;

    @Autowired
    public void setRedissonClient(RedissonClient client) {
        RedisUtil.redissonClient = client;
    }

    public static void set(String key, Object value) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value);
    }

    public static Object get(String key) {
        return redissonClient.getBucket(key).get();
    }

    public static void delete(String key) {
        redissonClient.getBucket(key).delete();
    }

    public static boolean exists(String key) {
        return redissonClient.getBucket(key).isExists();
    }

    public static void set(String key, Object value, long timeout, TimeUnit unit) {
        redissonClient.getBucket(key).set(value, timeout, unit);
    }

    public static void setHash(String key, String hashKey, Object value) {
        redissonClient.getMap(key).put(hashKey, value);
    }

    public static Object getHash(String key, String hashKey) {
        return redissonClient.getMap(key).get(hashKey);
    }

    public static RLock getLock(String lockKey, long leaseTime, TimeUnit unit) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(leaseTime, unit);
        return lock;
    }

    public static boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void unlock(RLock lock) {
        if (lock != null && lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}