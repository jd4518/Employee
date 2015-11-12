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

select * from city where countrycode='kor'