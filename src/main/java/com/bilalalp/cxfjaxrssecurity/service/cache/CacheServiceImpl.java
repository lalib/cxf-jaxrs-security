package com.bilalalp.cxfjaxrssecurity.service.cache;

import com.bilalalp.cxfjaxrssecurity.config.CachingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl<T> implements CacheService<T> {

    @Autowired
    private CacheManager cacheManager;

    @Override
    public T get(final String key) {
        final Cache.ValueWrapper valueWrapper = cacheManager.getCache(CachingConfig.CACHE_NAME).get(key);
        return valueWrapper != null ? (T) valueWrapper.get() : null;
    }

    @Override
    public void put(final String key, final T value) {
        cacheManager.getCache(CachingConfig.CACHE_NAME).put(key, value);
    }
}