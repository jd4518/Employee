package com.hybrid.dao;

import java.util.List;

import com.hybrid.model.Emp;

public interface EmpMapper {
	List<Emp> selectAll();
	List<Emp> selectAllWithDept();
	
	Emp selectByEmpno(int empno);
	Emp selectByEmpnoWithDept(int empno);
}
