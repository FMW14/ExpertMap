create table expert (
  id int8 not null,
  name varchar(255),
  patronymic varchar(255),
  surname varchar(255),
  primary key (id)
);

create table expert_tool (
  rating int4,
  expert_id int8 not null,
  tool_id int4 not null,
  primary key (expert_id, tool_id)
);

create table problem (
  id int4 not null,
  name varchar(255),
  primary key (id)
);

create table problem_tasks (
  problems_id int4 not null,
  tasks_id int4 not null
);

create table task (
  id int4 not null,
  name varchar(255),
  primary key (id)
);

create table task_tools (
  tasks_id int4 not null,
  tools_id int4 not null
);

create table tool (
  id int4 not null,
  name varchar(255),
  primary key (id)
);

create table user_role (
  user_id int8 not null,
  roles varchar(255)
);

create table usr (
  id int8 not null,
  active boolean not null,
  password varchar(255) not null,
  username varchar(255) not null,
  primary key (id)
);

alter table expert_tool add constraint FK3rco91j3a5x50734453jivcg7 foreign key (expert_id) references expert;
alter table expert_tool add constraint FKtbfuw288p5n083of4211v82m1 foreign key (tool_id) references tool;
alter table problem_tasks add constraint FKhaulpr5s61eqrgbwfcelmxxyk foreign key (tasks_id) references task;
alter table problem_tasks add constraint FK55vax6xurxn6vdm3ptd592n49 foreign key (problems_id) references problem;
alter table task_tools add constraint FK52fanexejfoqh3kgsxawsv9p2 foreign key (tools_id) references tool;
alter table task_tools add constraint FKgsu2dh06jkk1rk2x3kp6vx4ya foreign key (tasks_id) references task;
alter table user_role add constraint FKfpm8swft53ulq2hl11yplpr5 foreign key (user_id) references usr;