package com.li.dubbo.consumer;


import java.util.List;

import com.li.dubbo.provider.DemoService;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		context.start();

		DemoService<?> demoService = (DemoService<?>) context.getBean("demoService");
		String hello = demoService.sayHello("tom");
		System.out.println(hello);

		List<?> list = demoService.getUsers(10);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		System.in.read();
	}

}