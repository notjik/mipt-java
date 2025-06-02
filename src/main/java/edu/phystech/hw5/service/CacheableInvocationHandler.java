package edu.phystech.hw5.service;

import edu.phystech.hw5.annotation.Cacheable;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author kzlv4natoly & notjik
 */
public class CacheableInvocationHandler implements InvocationHandler {
    // Здесь необходимо (было) реализовать логику по обработке @cacheable и вызову конкретного метода объекта

    private final Object target;
    private final Map<CacheKey, Object> cache = new HashMap<>();

    public CacheableInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
        if (method.isAnnotationPresent(Cacheable.class)) {
            CacheKey key = new CacheKey(method, arguments);
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            Object result = method.invoke(target, arguments);
            cache.put(key, result);
            return result;
        } else {
            return method.invoke(target, arguments);
        }
    }

    private static class CacheKey {
        private final Method method;
        private final Object[] arguments;

        public CacheKey(Method method, Object[] arguments) {
            this.method = method;
            this.arguments = arguments != null ? arguments.clone() : new Object[0];
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            CacheKey cacheKey = (CacheKey) obj;
            return Objects.equals(method, cacheKey.method) &&
                    Objects.deepEquals(arguments, cacheKey.arguments);
        }

        @Override
        public int hashCode() {
            return Objects.hash(method, Objects.hash(arguments));
        }
    }
}
