drop database `concertsdb`;
create database `concerts_db`;

drop table `concerts_db`.`artists`;
create table if not exists `concerts_db`.`artists`( 
	artist_id varchar(50) not null, 
    artist_name varchar(50) not null, 
	primary key (artist_id));
select * from `concerts_db`.`artists`;

create table if not exists `concerts_db`.`venues`( 
	venue_id varchar(50) not null, 
	lat double default null, 
	lng double default null,
    venue_name varchar(50) default null, 
	venue_country varchar(50) default null, 
	venue_city varchar(50) default null, 
	venue_region varchar(50) default null, 
	primary key (venue_id));

select * from `concerts_db`.`venues`;
