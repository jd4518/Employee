package com.hybrid.employee;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.mapper.EmpMapper;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class EmpMapperTest {
	static Log log = LogFactory.getLog(EmpMapperTest.class);
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		EmpMapper empMapper = ctx.getBean(EmpMapper.class);
		
		//List<Dept> list = deptMapper.selectAll();
		List<Emp> list = empMapper.selectAllWithDept();
		
		
		list.forEach(new Consumer<Emp>() {
			
			@Override
			public void accept(Emp t) {
				// TODO Auto-generated method stub
				String msg  = "empno = " + t.getEmpno() +
							  ", ename = " + t.getEname() +
							  ", job = " + t.getJob() +
							  ", mgr = " + t.getMgr() +
							  ", hiredate = " + t.getHiredate() +
							  ", sal = " + t.getSal() +
							  ", comm = " + t.getComm() +
							  ", deptno = " + t.getDeptno() 
							  ;
				log.info(msg);
				Dept depts = t.getDept();
				
					msg = "\t\t" + depts.getDeptno() + " " 
						  + depts.getDname() + " "
						  + depts.getLoc();
						
					
					log.info(msg);
			
				
			}
		});
		
//		Dept dept = deptMapper.selectByDeptno(10);
		
		Emp emp = empMapper.selectByEmpno(7499);
		
		String msg  = "empno = " + emp.getEmpno() +
				  ", ename = " + emp.getEname() +
				  ", job = " + emp.getJob() +
				  ", mgr = " + emp.getMgr() +
				  ", hiredate = " + emp.getHiredate() +
				  ", sal = " + emp.getSal() +
				  ", comm = " + emp.getComm() +
				  ", deptno = " + emp.getDeptno() 
				  ;
		log.info(msg);
		Dept depts = emp.getDept();
		if(depts!=null){
			
			
			msg = "\t\t" + depts.getDeptno() + " " 
				  + depts.getDname() + " "
				  + depts.getLoc();
				
			
			log.info(msg);
	
			}
		}
	}

