/*Table(name="artists")	private String name;	private String id;	*/
create database if not exists `concerts_db`;

#drop table `concerts_db`.`artists`;

create table if not exists `concerts_db`.`artists`(
    artist_id varchar(30),
	artist_name varchar(30),
    primary key(artist_id)
);

#drop table `concerts_db`.`events`;

create table if not exists `concerts_db`.`events`(
	event_id int primary key,
	event_title varchar(30),
    event_description varchar(50)
);

#drop table `concerts_db`.`venues`;

create table if not exists `concerts_db`.`venues`(
	venue_id int primary key,
    lat double,
    lng double,
    venue_name varchar(30),
    country varchar(30),
    city varchar(30)
);

select *
from `concerts_db`.`artists`;