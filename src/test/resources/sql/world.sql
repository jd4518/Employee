show tables;

drop table member;
create table member(
	id int auto_increment,
	email varchar(255),
	name varchar(255),
	password varchar(255),
	register_date date,
	constraint pk_id primary key (id)
);
-- 
-- Member CRUD (Create, Read, Update, Delete)
--
--Create
insert into member
(email, name, password, register_date)
values
('xxx@yyy', '홍길동', '1234','2015/11/11');

--Read
select * from member; 

--Update
update member set name='홍순이',password='9876' where id=5;

--Delete
delete from member;

--
--City
-- selectAll
select id,
	   name,
	   countrycode,
	   district,
	   population
	from city;
-- selectByCountryCode(String countryCode)
select id,
	   name,
	   countrycode,
	   district,
	   population
	from city
   where countrycode = 'KOR';
	
   select * from country
   
   select c.id, c.name, t.name, t.headofstate 
   from city c inner join country t
   		on c.countrycode = t.code
   		where t.code = 'KOR'
   		
   		
select id,
	   name,
	   countrycode,
	   district,
	   population
	from city
	order by countrycode asc, name asc
	limit 20, 5
	
		select id,
				name,
				countrycode,
				district,
				population
			from city
			order by countrycode asc, name asc
			limit 20,5