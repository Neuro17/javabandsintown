drop database `concerts_db`;
create database `concerts_db`;

drop table if exists `concerts_db`.`artists`;

create table if not exists `concerts_db`.`artists`( 
	artist_id varchar(50) not null, 
    artist_name varchar(50) not null, 
	primary key (artist_name));
    
select * from `concerts_db`.`artists`;

drop table if exists `concerts_db`.`venues`;

create table if not exists `concerts_db`.`venues`( 
	venue_id int not null, 
	lat double default null, 
	lng double default null,
    venue_name varchar(50) default null, 
	venue_country varchar(50) default null, 
	venue_city varchar(50) default null, 
	venue_region varchar(50) default null, 
	primary key (venue_id));

select * from `concerts_db`.`venues`;

truncate `concerts_db`.`venues`;

drop table if exists `concerts_db`.`events`;

create table if not exists `concerts_db`.`events`(
	event_id int not null,
    event_title varchar(50) default null,
	event_description varchar(50) default null,
	venue_id int not null references `concerts_db`.`venues` on delete cascade,
    primary key (event_id)
);

select * from `concerts_db`.`events`;

truncate `concerts_db`.`events`;