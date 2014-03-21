# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cadeira (
  id                        bigint not null,
  nome                      varchar(255) not null,
  creditos                  integer,
  dificuldade               integer,
  periodo_default           integer,
  constraint uq_cadeira_nome unique (nome),
  constraint pk_cadeira primary key (id))
;

create table periodo (
  id                        bigint not null,
  numero                    integer,
  constraint pk_periodo primary key (id))
;

create table plano_de_curso (
  id                        bigint not null,
  constraint pk_plano_de_curso primary key (id))
;

create table account (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (email))
;


create table CADEIRA_REQUISITO (
  CD_CADEIRA_1                   bigint not null,
  CD_CADEIRA_2                   bigint not null,
  constraint pk_CADEIRA_REQUISITO primary key (CD_CADEIRA_1, CD_CADEIRA_2))
;

create table TB_PERIODO_CADEIRA (
  CD_PERIODO_CADEIRA             bigint not null,
  CD_CADEIRA                     bigint not null,
  constraint pk_TB_PERIODO_CADEIRA primary key (CD_PERIODO_CADEIRA, CD_CADEIRA))
;

create table TB_PLANO_PERIODO (
  CD_PLANO_PERIODO               bigint not null,
  CD_PERIODO                     bigint not null,
  constraint pk_TB_PLANO_PERIODO primary key (CD_PLANO_PERIODO, CD_PERIODO))
;
create sequence cadeira_seq;

create sequence periodo_seq;

create sequence plano_de_curso_seq;

create sequence account_seq;




alter table CADEIRA_REQUISITO add constraint fk_CADEIRA_REQUISITO_cadeira_01 foreign key (CD_CADEIRA_1) references cadeira (id);

alter table CADEIRA_REQUISITO add constraint fk_CADEIRA_REQUISITO_cadeira_02 foreign key (CD_CADEIRA_2) references cadeira (id);

alter table TB_PERIODO_CADEIRA add constraint fk_TB_PERIODO_CADEIRA_periodo_01 foreign key (CD_PERIODO_CADEIRA) references periodo (id);

alter table TB_PERIODO_CADEIRA add constraint fk_TB_PERIODO_CADEIRA_cadeira_02 foreign key (CD_CADEIRA) references cadeira (id);

alter table TB_PLANO_PERIODO add constraint fk_TB_PLANO_PERIODO_plano_de__01 foreign key (CD_PLANO_PERIODO) references plano_de_curso (id);

alter table TB_PLANO_PERIODO add constraint fk_TB_PLANO_PERIODO_periodo_02 foreign key (CD_PERIODO) references periodo (id);

# --- !Downs

drop table if exists cadeira cascade;

drop table if exists CADEIRA_REQUISITO cascade;

drop table if exists periodo cascade;

drop table if exists TB_PERIODO_CADEIRA cascade;

drop table if exists plano_de_curso cascade;

drop table if exists TB_PLANO_PERIODO cascade;

drop table if exists account cascade;

drop sequence if exists cadeira_seq;

drop sequence if exists periodo_seq;

drop sequence if exists plano_de_curso_seq;

drop sequence if exists account_seq;

