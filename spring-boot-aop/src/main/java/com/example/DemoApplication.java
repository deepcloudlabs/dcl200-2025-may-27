package com.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.Calculator;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner{
	private final Calculator calculator;
	
	public DemoApplication(Calculator calculator) {
		this.calculator = calculator;
		// Instrumentation-based AOP, CGLIB: Instrumentation Library
		// com.example.service.impl.StandardCalculator$$SpringCGLIB$$0
		System.out.println(calculator.getClass().getName());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("3+5=%f".formatted(calculator.add(3, 5)));
		System.out.println("3+5=%f".formatted(calculator.add(3, 5)));
		System.out.println("3+5=%f".formatted(calculator.add(3, 5)));
		System.out.println("3+5=%f".formatted(calculator.add(3, 5)));
		System.out.println("3-5=%f".formatted(calculator.sub(3, 5)));
		System.out.println("3*5=%f".formatted(calculator.mul(3, 5)));
		System.out.println("3/5=%f".formatted(calculator.div(3, 5)));
	}

}
