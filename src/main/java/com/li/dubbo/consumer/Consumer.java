package com.li.dubbo.consumer;


import com.li.dubbo.provider.DemoService;
import com.li.dubbo.provider.vo.User;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Consumer {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		context.start();

		DemoService<User> demoService = (DemoService<User>) context.getBean("demoService");
		String hello = demoService.sayHello("tom");
		System.out.println(hello);

		List<User> list = demoService.getUsers(10);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getAge());
			}
		}
		System.in.read();
	}

}