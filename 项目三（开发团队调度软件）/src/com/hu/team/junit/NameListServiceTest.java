package com.hu.team.junit;
/**
 * 
* @Description 对NameListService进行测试
* @author hu Email:3300786078@qq.com
* @version jdk1.8
* @date 2021年9月28日下午3:58:09
*
 */

import com.hu.team.domain.Employee;
import com.hu.team.service.NameListService;
import com.hu.team.service.TeamException;
import org.junit.Test;

public class NameListServiceTest {
//	@Test
//	public void testGetAllEmployees() {
//		NameListService service = new NameListService();
//		Employee employees[] = service.getAllEmployees();
//		for(int i=0;i<employees.length;i++) {
//			System.out.println(employees[i]);
//		}
//	}
	@Test
	public void testGetEmployee(){
		NameListService service = new NameListService();
		try {
			Employee employee = service.getEmployee(8);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}

