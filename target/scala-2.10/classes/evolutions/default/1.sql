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




alter table CADEIRA_REQUISITO add constraint fk_CADEIRA_REQUISITO_cadeira_01 foreign key (CD_CADEIRA_1) references cadeira (id) on delete restrict on update restrict;

alter table CADEIRA_REQUISITO add constraint fk_CADEIRA_REQUISITO_cadeira_02 foreign key (CD_CADEIRA_2) references cadeira (id) on delete restrict on update restrict;

alter table TB_PERIODO_CADEIRA add constraint fk_TB_PERIODO_CADEIRA_periodo_01 foreign key (CD_PERIODO_CADEIRA) references periodo (id) on delete restrict on update restrict;

alter table TB_PERIODO_CADEIRA add constraint fk_TB_PERIODO_CADEIRA_cadeira_02 foreign key (CD_CADEIRA) references cadeira (id) on delete restrict on update restrict;

alter table TB_PLANO_PERIODO add constraint fk_TB_PLANO_PERIODO_plano_de__01 foreign key (CD_PLANO_PERIODO) references plano_de_curso (id) on delete restrict on update restrict;

alter table TB_PLANO_PERIODO add constraint fk_TB_PLANO_PERIODO_periodo_02 foreign key (CD_PERIODO) references periodo (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists cadeira;

drop table if exists CADEIRA_REQUISITO;

drop table if exists periodo;

drop table if exists TB_PERIODO_CADEIRA;

drop table if exists plano_de_curso;

drop table if exists TB_PLANO_PERIODO;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists cadeira_seq;

drop sequence if exists periodo_seq;

drop sequence if exists plano_de_curso_seq;

