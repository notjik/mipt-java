package edu.phystech.hw5.service;

import java.lang.reflect.Proxy;

/**
 * @author kzlv4natoly
 */
public class CacheUtils {
    public static <T> T getCacheProxy(Class<T> clazz, T object) {
        // Здесь приведен пример того, как можно создавать динамический прокси
        T proxy = (T) Proxy.newProxyInstance(
                CacheUtils.class.getClassLoader(),
                new Class[]{clazz},
                new CacheableInvocationHandler(object));
        return proxy;
    }
}
