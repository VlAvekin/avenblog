create sequence hibernate_sequence start 1 increment 1;

create table articles (
  id int8 not null,
  brief_descriptions varchar(255) not null,
  photo varchar(255),
  text varchar not null,
  theme varchar(255),
  user_id int8,
  primary key (id)
);

create table files (
  id int8 not null,
  file_id varchar(255),
  filename varchar(255) not null,
  primary key (id)
);

create table user_role (
  user_id int8 not null,
  roles varchar(255)
);

create table usr (
  id int8 not null,
  activation_code varchar(255),
  active boolean not null,
  email varchar(255) ,
  password varchar(255) not null,
  username varchar(255) not null,
  primary key (id)
);

alter table if exists articles
  add constraint articles_user_fk
  foreign key (user_id) references usr;

alter table if exists user_role
  add constraint user_role_user_fk
  foreign key (user_id) references usr;