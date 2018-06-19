package com.dieson.green.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class TokenCache {

    //声明日志
    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    public static final String TOKEN_PREFIX = "token_";

    /**
     * 本地缓存    1000是缓存的初始化容量
     * maximumSize(10000)  超过这个值, 会采用lru算法(最少使用算法)
     * expireAfterAccess(12,TimeUnit.HOURS)  缓存有效期12个小时
     */
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现,当调用get取值的时候,如果key没有对应的值,就调用这个方法进行加载
                //当我们的key没有命中的时候,就会调用这个匿名实现
                @Override
                public String load(String s) throws Exception {
                    // return null;   key是null的话 会报空指针
                    return "null";
                }
            });

    public static void setKey(String key, String value) {

        localCache.put(key, value);
    }

    public static String getKey(String key) {
        String value = null;
        try {
            value = localCache.get(key);
            if ("null".equals(value)) {
                return null;
            }
            return value;
        } catch (Exception e) {
            logger.error("localCahce get error", e);
        }
        return null;
    }
}
