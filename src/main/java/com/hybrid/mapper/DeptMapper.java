package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Dept;

public interface DeptMapper {
	
	List<Dept> selectAll();
	List<Dept> selectAllWithEmps();
	List<Dept> selectAllWithEmps_outer();
	List<Dept> selectGreaterThan(int deptno);
	
	Dept selectByDeptno(int deptno);
	Dept selectByDeptnoWithEmps(int deptno);
	
	int insert(Dept dept);
	int delete(Dept dept);
	int deleteGreateThan(int deptno);
	
}
