package com.example.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CachingHandler implements InvocationHandler {
	private static final Map<String, Map<Integer, Object>> cache = new ConcurrentHashMap<>();
	private final Object target;

	public CachingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var methodName = method.getName();
		var methodCache = cache.get(methodName);
		if (Objects.isNull(methodCache)) {
			methodCache = new ConcurrentHashMap<>();
			cache.put(methodName, methodCache);
		}
		int hashCode = Objects.hash(args);
		var cachedValue = methodCache.get(hashCode);
		if (Objects.isNull(cachedValue)) {
			cachedValue = method.invoke(target, args);
			methodCache.put(hashCode, cachedValue);
		}
		return cachedValue;
	}

}
