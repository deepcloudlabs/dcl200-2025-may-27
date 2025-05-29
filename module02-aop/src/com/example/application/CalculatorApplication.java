package com.example.application;

import java.lang.reflect.Proxy;

import com.example.aspects.AuditingHandler;
import com.example.aspects.CachingHandler;
import com.example.service.Calculator;
import com.example.service.business.StandardCalculator;

public class CalculatorApplication {

	public static void main(String[] args) {
		var standardCalculator = new StandardCalculator();
		Class<? extends StandardCalculator> clazz = standardCalculator.getClass();
		var calculator = (Calculator) Proxy.newProxyInstance(
				clazz.getClassLoader(), 
				clazz.getInterfaces(), 
				new AuditingHandler(standardCalculator));
		calculator = (Calculator) Proxy.newProxyInstance(
				calculator.getClass().getClassLoader(), 
				calculator.getClass().getInterfaces(), 
				new CachingHandler(calculator));
		String calculatorClazzName = calculator.getClass().getName();
		System.out.println("[%s] 3 + 5 = %f".formatted(calculatorClazzName,calculator.add(3, 5)));
		System.out.println("[%s] 3 + 5 = %f".formatted(calculatorClazzName,calculator.add(3, 5)));
		System.out.println("[%s] 3 + 5 = %f".formatted(calculatorClazzName,calculator.add(3, 5)));
		System.out.println("[%s] 3 + 5 = %f".formatted(calculatorClazzName,calculator.add(3, 5)));
		System.out.println("[%s] 3 + 5 = %f".formatted(calculatorClazzName,calculator.add(3, 5)));
		System.out.println("[%s] 3 + 5 = %f".formatted(calculatorClazzName,calculator.add(3, 5)));
		System.out.println("[%s] 3 - 5 = %f".formatted(calculatorClazzName,calculator.sub(3, 5)));
		System.out.println("[%s] 3 * 5 = %f".formatted(calculatorClazzName,calculator.mul(3, 5)));
		System.out.println("[%s] 3 / 5 = %f".formatted(calculatorClazzName,calculator.div(3, 5)));

	}

}
