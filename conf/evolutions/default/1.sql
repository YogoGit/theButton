# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                        varchar(255) not null,
  contents                  varchar(255),
  constraint pk_task primary key (id))
;

create table user (
  username                  varchar(255) not null,
  email                     varchar(255),
  constraint pk_user primary key (username))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table task;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

