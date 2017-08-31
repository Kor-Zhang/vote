prompt PL/SQL Developer import file
prompt Created on 2017年8月31日 by Kor_Zhang
set feedback off
set define off
prompt Creating USERS...
create table USERS
(
  ID       NVARCHAR2(36) not null,
  USERNAME NVARCHAR2(15) not null,
  PASSWORD NVARCHAR2(16) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table USERS
  add constraint USERS_PK_ID primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table USERS
  add constraint UK_USERNAME unique (USERNAME)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating VOTES...
create table VOTES
(
  ID         NVARCHAR2(36) not null,
  THEME      NVARCHAR2(30) not null,
  LAUNCHER   NVARCHAR2(36) not null,
  SELECT_WAY NUMBER(1) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column VOTES.LAUNCHER
  is '该投票所属的用户(即发起者)';
comment on column VOTES.SELECT_WAY
  is '该投票是单选(0)还是多选(1)';
alter table VOTES
  add constraint VOTES_PK_ID primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table VOTES
  add constraint VOTES_FK_LAUNCHER foreign key (LAUNCHER)
  references USERS (ID);

prompt Creating VOTE_ITEMS...
create table VOTE_ITEMS
(
  ID          NVARCHAR2(36) not null,
  MASTER      NVARCHAR2(36) not null,
  DESCRIPTION NVARCHAR2(30) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column VOTE_ITEMS.MASTER
  is '该投票选项所属的投票';
alter table VOTE_ITEMS
  add constraint VOTE_ITEM_PK_ID primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table VOTE_ITEMS
  add constraint VOTE_ITEM_FK_MASTER foreign key (MASTER)
  references VOTES (ID);

prompt Creating USERS_VOTE_ITEMS...
create table USERS_VOTE_ITEMS
(
  ID        NVARCHAR2(36) not null,
  ACTOR     NVARCHAR2(36),
  VOTE_ITEM NVARCHAR2(36)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column USERS_VOTE_ITEMS.ACTOR
  is 'ACTOR表示投票者';
comment on column USERS_VOTE_ITEMS.VOTE_ITEM
  is 'VOTE_ITEM表示投票者选择的选项';
alter table USERS_VOTE_ITEMS
  add constraint USERS_VOTE_ITEMS_PK_ID primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table USERS_VOTE_ITEMS
  add constraint USERS_VOTE_ITEMS_FK_ACTOR foreign key (ACTOR)
  references USERS (ID);
alter table USERS_VOTE_ITEMS
  add constraint USERS_VOTE_ITEMS_FK_VOTE_ITEM foreign key (VOTE_ITEM)
  references VOTE_ITEMS (ID);

prompt Loading USERS...
prompt Table is empty
prompt Loading VOTES...
prompt Table is empty
prompt Loading VOTE_ITEMS...
prompt Table is empty
prompt Loading USERS_VOTE_ITEMS...
prompt Table is empty
set feedback on
set define on
prompt Done.
