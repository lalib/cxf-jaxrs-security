package com.bilalalp.cxfjaxrssecurity.service.cache;

public interface CacheService<T> {

    T get(String key);

    void put(String key, T value);
}
