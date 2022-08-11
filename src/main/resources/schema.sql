create database if not exists familyPlanner;

use familyPlanner;

create table if not exists person(
	personId int auto_increment not null,
    name varchar(40) not null,
    age int not null,
    parent boolean,
    primary key(personId)
);

create table if not exists task(
	taskId int auto_increment not null,
    title varchar(40) not null,
    completed boolean default false,
    timeComplete timestamp,
    assignee int,
    primary key (taskId),
    foreign key (assignee) references person(personId)
);
    