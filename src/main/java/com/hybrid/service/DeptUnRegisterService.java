package com.hybrid.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hybrid.dao.DeptDao;
import com.hybrid.dao.EmpDao;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class DeptUnRegisterService {

	DeptDao deptDao;
	EmpDao empDao;
	DataSource dataSource;
	
	
	public void setDeptDao(DeptDao dao){
		
		this.deptDao = dao;
	}
	public void setEmpDao(EmpDao dao){
		this.empDao = dao;
	}
	
	public void setDataSource(DataSource d){
		this.dataSource = d;
		
	}
	
	public void unregist(Dept dept){
		List<Emp> emps = empDao.selectByDeptno(dept.getDeptno());
		
		for (Emp emp : emps){
			empDao.delete(emp);
		}
		deptDao.delete(dept);
	}
	public void unregist(int  deptno){
		List<Dept> depts = deptDao.selectGreaterThan(deptno);
		
		for(Dept d : depts){
			unregist(d);
		}
		
		
//		deptDao.deleteGreaterThan(deptno);
	}
}
