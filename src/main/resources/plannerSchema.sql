drop schema if exists familyPlanner;

create database if not exists familyPlanner;

use familyPlanner;

create table if not exists person(
	personId int auto_increment not null,
    `name` varchar(40) not null,
    age int not null,
    parent boolean default false,
    primary key(personId)
);

create table if not exists task(
	taskId int auto_increment not null,
    taskName varchar(40) not null,
    complete boolean default false,
    timeComplete timestamp,
    assigned boolean default false,
    assignee int,
    primary key (taskId),
    foreign key (assignee) references person(personId)
);
    