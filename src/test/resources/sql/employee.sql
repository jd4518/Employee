drop table city;

create table city (
  id			 	 numeric(11),
  name			 	 char(35),
  countrycode		 char(3),
  district 			 char(20),
  population 		 numeric(11),
  constraint city_pk_id primary key (id)
)