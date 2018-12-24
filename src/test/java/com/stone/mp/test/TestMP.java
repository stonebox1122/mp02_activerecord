package com.stone.mp.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stone.mp.beans.Emp;
import com.stone.mp.mapper.EmpMapper;

public class TestMP {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	private EmpMapper empMapper = ioc.getBean("empMapper", EmpMapper.class);


	//AR 插入操作
	@Test
	public void testARInsert() {
		Emp emp = new Emp();
		emp.setLastName("eee");
		emp.setEmail("eee@stone.com");
		emp.setGender(1);
		emp.setAge(36);
		boolean result = emp.insert();
		System.out.println(result);
	}
	
	//AR 修改操作
	@Test
	public void testARUpdate() {
		Emp emp = new Emp();
		emp.setId(15);
		emp.setLastName("bbb");
		emp.setEmail("eee@stone.com");
		emp.setGender(1);
		emp.setAge(39);
		boolean result = emp.updateById();
		System.out.println(result);
	}

	//AR 查询操作
	@Test
	public void testARSelectById() {
		Emp emp = new Emp();
		//Emp result = emp.selectById(15);
		emp.setId(15);
		Emp result = emp.selectById();
		System.out.println(result);
	}

	//AR 查询操作
	@Test
	public void testARSelectAll() {
		Emp emp = new Emp();
		List<Emp> result = emp.selectAll();
		System.out.println(result);
	}
	
	//AR 查询操作
	@Test
	public void testARSelectList() {
		Emp emp = new Emp();
		List<Emp> emps = emp.selectList(new EntityWrapper<Emp>().like("last_name", "tom"));
		System.out.println(emps);
	}	

	//AR 查询操作
	@Test
	public void testARSelectCount() {
		Emp emp = new Emp();
		int resutl = emp.selectCount(new EntityWrapper<Emp>().eq("gender", 0));
		System.out.println(resutl);
	}	

	//AR 删除操作
	@Test
	public void testARDeleteById() {
		Emp emp = new Emp();
		//boolean result = emp.deleteById(2);
		emp.setId(2);
		boolean result = emp.deleteById();
		System.out.println(result);
	}	

	//AR 删除操作
	@Test
	public void testARDelete() {
		Emp emp = new Emp();
		boolean result = emp.delete(new EntityWrapper<Emp>().like("last_name", "bb"));
		System.out.println(result);
	}	

	//AR 分页操作
	@Test
	public void testARPage() {
		Emp emp = new Emp();
		Page<Emp> page = emp.selectPage(new Page<Emp>(2, 2), new EntityWrapper<Emp>().eq("gender", 1));
		List<Emp> emps = page.getRecords();
		System.out.println(emps);
	}	
	
}
