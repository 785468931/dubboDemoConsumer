package com.li.dubbo.provider;

import java.util.List;

public interface DemoService<T> {

	String sayHello(String name);

	public List<T> getUsers(int age);

}