/*Table(name="artists")	private String name;	private String id;	*/
create database if not exists `concerts_db`;

create table if not exists `concerts_db`.`artists`(
	name varchar(30),
    id varchar(10) primary key
);