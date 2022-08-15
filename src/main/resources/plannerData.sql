use familyPlanner;

insert into person (`name`, age, parent) values ("Peter", 53, true);
insert into person (`name`, age, parent) values ("Jackie", 52, true);
insert into person (`name`, age, parent) values ("Daniel", 23, false);
insert into person (`name`, age, parent) values ("Thomas", 19, false);

insert into task (taskName) values ("Cook dinner");
insert into task (taskName) values ("Load dishwasher");
insert into task (taskName) values ("Make Bed");
insert into task (taskName, assignee) values ("Wash clothes", 1);




select * from task;