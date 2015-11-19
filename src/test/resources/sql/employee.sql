drop table city;

create table city (
  id			 	 numeric(11),
  name			 	 char(50),
  countrycode		 char(3),
  district 			 char(33),
  population 		 numeric(11),
  constraint city_pk_id primary key (id)
)

insert into city
(
	id,
	name,
	countrycode,
	district,
	population
)
values
(
	1,
	'seoul',
	'KOR',
	'Asia',
	99998
)

select * from city where countrycode='KOR'

---
---  inner join
---
select * from dept;
select * from emp;

select 
		d.deptno as dept_deptno,
		d.dname as dept_dname,
		d.loc as dept_loc,
		e.empno as emp_empno,
		e.ename as emp_ename,
		e.job as emp_job
	from emp e inner join dept d
	on e.deptno = d.deptno
	
	select 
		d.deptno as dept_deptno,
		d.dname as dept_dname,
		d.loc as dept_loc,
		e.empno as emp_empno,
		e.ename as emp_ename,
		e.job as emp_job
	from emp e left outer join dept d
	on e.deptno = d.deptno
	
select * from emp e inner join  dept d  on e.deptno= d.deptno
			where d.deptno = 81
	