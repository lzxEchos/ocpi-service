//package com.halo.ocpi.util;
//
//import lombok.extern.slf4j.Slf4j;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.redisson.api.RBucket;
//import org.redisson.api.RSet;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
//public class RedisUtil implements ApplicationContextAware {
//
//    private static RedissonClient redissonClient;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        redissonClient = applicationContext.getBean(RedissonClient.class);
//        log.info("RedissonClient injected into RedisUtil");
//    }
//
//    // --------------------- 字符串操作 ---------------------
//    public static void set(String key, String value) {
//        try {
//            RBucket<String> bucket = redissonClient.getBucket(key);
//            bucket.set(value);
//        } catch (Exception e) {
//            log.error("Error setting key: {}", key, e);
//            throw e;
//        }
//    }
//
//    public static String get(String key) {
//        try {
//            RBucket<String> bucket = redissonClient.getBucket(key);
//            return bucket.get();
//        } catch (Exception e) {
//            log.error("Error getting key: {}", key, e);
//            throw e;
//        }
//    }
//
//    public static void del(String key) {
//        try {
//            redissonClient.getBucket(key).delete();
//        } catch (Exception e) {
//            log.error("Error deleting key: {}", key, e);
//            throw e;
//        }
//    }
//
//    public static boolean exists(String key) {
//        try {
//            return redissonClient.getBucket(key).isExists();
//        } catch (Exception e) {
//            log.error("Error checking existence of key: {}", key, e);
//            throw e;
//        }
//    }
//
//    public static void setEx(String key, String value, long time, TimeUnit unit) {
//        try {
//            RBucket<String> bucket = redissonClient.getBucket(key);
//            bucket.set(value, time, unit);
//        } catch (Exception e) {
//            log.error("Error setting key with expiration: {}", key, e);
//            throw e;
//        }
//    }
//
//    // --------------------- 分布式锁 ---------------------
//    public static boolean lock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) {
//        try {
//            RLock lock = redissonClient.getLock(lockKey);
//            return lock.tryLock(waitTime, leaseTime, unit);
//        } catch (InterruptedException e) {
//            log.error("Interrupted while trying to acquire lock: {}", lockKey, e);
//            Thread.currentThread().interrupt();
//            return false;
//        } catch (Exception e) {
//            log.error("Error acquiring lock: {}", lockKey, e);
//            return false;
//        }
//    }
//
//    public static void unlock(String lockKey) {
//        try {
//            RLock lock = redissonClient.getLock(lockKey);
//            if (lock.isHeldByCurrentThread()) {
//                lock.unlock();
//            } else {
//                log.warn("Current thread does not hold lock: {}", lockKey);
//            }
//        } catch (Exception e) {
//            log.error("Error releasing lock: {}", lockKey, e);
//        }
//    }
//
//    // --------------------- 集合操作 ---------------------
//    public static void sadd(String key, String member) {
//        try {
//            RSet<String> set = redissonClient.getSet(key);
//            set.add(member);
//        } catch (Exception e) {
//            log.error("Error adding member to set: {}", key, e);
//            throw e;
//        }
//    }
//
//    public static boolean sismember(String key, String member) {
//        try {
//            RSet<String> set = redissonClient.getSet(key);
//            return set.contains(member);
//        } catch (Exception e) {
//            log.error("Error checking member in set: {}", key, e);
//            throw e;
//        }
//    }
//
//    public static Set<String> smembers(String key) {
//        try {
//            RSet<String> set = redissonClient.getSet(key);
//            return set.readAll();
//        } catch (Exception e) {
//            log.error("Error getting all members from set: {}", key, e);
//            throw e;
//        }
//    }
//
//    public static int scard(String key) {
//        try {
//            RSet<String> set = redissonClient.getSet(key);
//            return set.size();
//        } catch (Exception e) {
//            log.error("Error getting size of set: {}", key, e);
//            throw e;
//        }
//    }
//}