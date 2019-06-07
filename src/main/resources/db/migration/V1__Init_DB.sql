create table _countries (
  country_id  bigserial not null,
  title_en varchar(255),
  title_ru varchar(255),
  primary key (country_id)
);

create table _lang (
  id  bigserial not null,
  title_ru varchar(255),
  primary key (id)
);

create table expert (
  id  bigserial not null,
  email varchar(255),
  name varchar(255),
  offline boolean,
  online boolean,
  patronymic varchar(255),
  phone varchar(255),
  surname varchar(255),
  city_id bigint,
  country_id bigint,
  primary key (id), city varchar(255)
);

create table expert_lang (
  experts_id serial not null,
  lang_id serial not null,
  primary key (experts_id, lang_id)
);

create table expert_tool (
  rating int4,
  expert_id serial not null,
  tool_id serial not null,
  primary key (expert_id, tool_id)
);

create table problem (
  id  serial not null,
  name varchar(255),
  type boolean,
  primary key (id)
);

create table problem_tasks (
  problems_id serial not null,
  tasks_id serial not null,
  primary key (problems_id, tasks_id)
);

create table task (
  id  serial not null,
  name varchar(255),
  primary key (id)
);

create table task_tools (
  tasks_id serial not null,
  tools_id serial not null,
  primary key (tasks_id, tools_id)
);

create table tool (
  id  serial not null,
  name varchar(255),
  primary key (id)
);

create table user_role (
  user_id serial not null,
  roles varchar(255)
);

create table usr (
  id  bigserial not null,
  active boolean not null,
  password varchar(255),
  username varchar(255),
  primary key (id)
);

alter table expert add constraint FKjgc3yauvv2m0coy2e8aiqomvv foreign key (country_id) references _countries;
alter table expert_lang add constraint FK8483uy6scrftv62dy8f9ao6gw foreign key (lang_id) references _lang;
alter table expert_lang add constraint FKinxbaqa6p3vda35f74w0897ar foreign key (experts_id) references expert;
alter table expert_tool add constraint FK3rco91j3a5x50734453jivcg7 foreign key (expert_id) references expert;
alter table expert_tool add constraint FKtbfuw288p5n083of4211v82m1 foreign key (tool_id) references tool;
alter table problem_tasks add constraint FKhaulpr5s61eqrgbwfcelmxxyk foreign key (tasks_id) references task;
alter table problem_tasks add constraint FK55vax6xurxn6vdm3ptd592n49 foreign key (problems_id) references problem;
alter table task_tools add constraint FK52fanexejfoqh3kgsxawsv9p2 foreign key (tools_id) references tool;
alter table task_tools add constraint FKgsu2dh06jkk1rk2x3kp6vx4ya foreign key (tasks_id) references task;
alter table user_role add constraint FKfpm8swft53ulq2hl11yplpr5 foreign key (user_id) references usr;