package com.example.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class AuditingHandler implements InvocationHandler {
	private final Object target;

	public AuditingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var methodName = method.getName();
		System.out.println("%s runs at %s".formatted(methodName, LocalDateTime.now()));
		var result = method.invoke(target, args);
		System.out.println("%s returns %s".formatted(methodName, result));
		return result;
	}

}
