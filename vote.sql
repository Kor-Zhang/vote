prompt PL/SQL Developer import file
prompt Created on 2017年9月2日 by Kor_Zhang
set feedback off
set define off
prompt Creating USERS...
create table USERS
(
  ID       NVARCHAR2(50) not null,
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
    next 8K
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
  ID        NVARCHAR2(50) not null,
  THEME     NVARCHAR2(30) not null,
  LAUNCHER  NVARCHAR2(50) not null,
  SELECTWAY NUMBER(1) not null,
  TIME      TIMESTAMP(6) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column VOTES.LAUNCHER
  is '该投票所属的用户(即发起者)';
comment on column VOTES.SELECTWAY
  is '该投票是单选(0)还是多选(1)';
comment on column VOTES.TIME
  is '该投票创建时间';
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
  references USERS (ID) on delete cascade;

prompt Creating VOTE_ITEMS...
create table VOTE_ITEMS
(
  ID          NVARCHAR2(50) not null,
  MASTER      NVARCHAR2(50) not null,
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
    next 8K
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
  references VOTES (ID) on delete cascade;

prompt Creating USER_VOTE_ITEM...
create table USER_VOTE_ITEM
(
  ID       NVARCHAR2(50) not null,
  JOINER   NVARCHAR2(50) not null,
  VOTEITEM NVARCHAR2(50) not null,
  VOTE     NVARCHAR2(50) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column USER_VOTE_ITEM.JOINER
  is 'ACTOR表示投票者';
comment on column USER_VOTE_ITEM.VOTEITEM
  is 'VOTE_ITEM表示投票者选择的选项';
comment on column USER_VOTE_ITEM.VOTE
  is 'VOTE表示用户参加的投票';
alter table USER_VOTE_ITEM
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
alter table USER_VOTE_ITEM
  add constraint USERS_VOTE_ITEMS_FK_ACTOR foreign key (JOINER)
  references USERS (ID) on delete cascade;
alter table USER_VOTE_ITEM
  add constraint USERS_VOTE_ITEMS_FK_VOTE foreign key (VOTE)
  references VOTES (ID) on delete cascade;
alter table USER_VOTE_ITEM
  add constraint USERS_VOTE_ITEMS_FK_VOTE_ITEM foreign key (VOTEITEM)
  references VOTE_ITEMS (ID) on delete cascade;

prompt Loading USERS...
insert into USERS (ID, USERNAME, PASSWORD)
values ('1', 'zhangke', '123');
insert into USERS (ID, USERNAME, PASSWORD)
values ('2', '1', '1');
insert into USERS (ID, USERNAME, PASSWORD)
values ('c02efa8f-58af-47e6-b62c-3639a473493e', '2', '2');
insert into USERS (ID, USERNAME, PASSWORD)
values ('7c1d7b13-89ba-4153-8511-6f579102be4a', '3', '3');
insert into USERS (ID, USERNAME, PASSWORD)
values ('4066c383-182a-495e-9002-6549ae2a84c8', '4', '4');
commit;
prompt 5 records loaded
prompt Loading VOTES...
insert into VOTES (ID, THEME, LAUNCHER, SELECTWAY, TIME)
values ('7ec88707-48f8-4a73-a1a8-a903dfa28025', '今天天气？', '2', 0, to_timestamp('02-09-2017 15:48:13.393000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 1 records loaded
prompt Loading VOTE_ITEMS...
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('209e6ebd-6f68-4001-8459-6d2a4cf64ca0', '7ec88707-48f8-4a73-a1a8-a903dfa28025', '晴天');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('587ef373-3400-4562-9dbd-6ac548e5f930', '7ec88707-48f8-4a73-a1a8-a903dfa28025', '五月天');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('fce38d77-717f-4bd8-b5ec-68af4ed014c0', '7ec88707-48f8-4a73-a1a8-a903dfa28025', '雨天');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('ea1e5197-8bce-46df-b2fc-078fce19fbec', '7ec88707-48f8-4a73-a1a8-a903dfa28025', '阴天');
commit;
prompt 4 records loaded
prompt Loading USER_VOTE_ITEM...
prompt Table is empty
set feedback on
set define on
prompt Done.
