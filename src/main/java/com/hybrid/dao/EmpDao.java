package com.hybrid.dao;

import java.util.List;

import com.hybrid.mapper.EmpMapper;
import com.hybrid.model.Emp;

public class EmpDao {
	
	EmpMapper empMapper;
	
	public void setEmpMapper(EmpMapper mapper){
		this.empMapper = mapper;
	}
	
	public List<Emp> selectAll(){
	
		return empMapper.selectAll();
	}
	
	public List<Emp> selectAllWithDept(){
		
		return empMapper.selectAllWithDept();
	}
	
	public Emp selectByEmpno(int empno){
		
		return empMapper.selectByEmpno(empno);
	}
	
	public Emp selectByEmpnoWithDept(int empno){
		
		return empMapper.selectByEmpnoWithDept(empno);
	}
	
	public int insertEmp(Emp e){
		
		return empMapper.insertEmp(e);
		
	}
}
