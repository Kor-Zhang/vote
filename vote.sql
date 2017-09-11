prompt PL/SQL Developer import file
prompt Created on 2017年9月5日 by Kor_Zhang
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
values ('b8a6d35a-92f0-4728-8cb6-3f3fa757f076', '这是一个多选投票！！！', '2', 1, to_timestamp('02-09-2017 16:22:44.882000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into VOTES (ID, THEME, LAUNCHER, SELECTWAY, TIME)
values ('64147f77-9812-4ffe-a628-0a81c9ecf73c', '誰最帥', '1', 1, to_timestamp('02-09-2017 19:11:33.258000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into VOTES (ID, THEME, LAUNCHER, SELECTWAY, TIME)
values ('5bdf3ca8-e110-4878-a92c-74bc1cb1af6d', '最好玩的地方', '2', 1, to_timestamp('05-09-2017 08:45:32.021000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into VOTES (ID, THEME, LAUNCHER, SELECTWAY, TIME)
values ('0e23bad6-9d83-474a-84f1-6d6a1fa9b684', '最好的地方', '2', 1, to_timestamp('04-09-2017 10:35:51.516000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into VOTES (ID, THEME, LAUNCHER, SELECTWAY, TIME)
values ('49d52095-91af-45cb-98b7-f10181889e57', '最开心的事', '2', 1, to_timestamp('04-09-2017 10:37:20.924000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into VOTES (ID, THEME, LAUNCHER, SELECTWAY, TIME)
values ('7ec88707-48f8-4a73-a1a8-a903dfa28025', '今天天气？', '2', 0, to_timestamp('02-09-2017 15:48:13.393000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into VOTES (ID, THEME, LAUNCHER, SELECTWAY, TIME)
values ('3947b80c-1cc8-4838-a951-03ad2ab8f025', '那部手机好用', '2', 0, to_timestamp('02-09-2017 15:58:50.147000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into VOTES (ID, THEME, LAUNCHER, SELECTWAY, TIME)
values ('a8d254fe-5bb6-4078-a1d7-4b5d2165beda', '最热的地方', '2', 1, to_timestamp('04-09-2017 15:44:10.323000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into VOTES (ID, THEME, LAUNCHER, SELECTWAY, TIME)
values ('1b3508a9-59a4-4236-a495-a07503496740', '你认为最热的地方！！？？那里呢', '2', 1, to_timestamp('04-09-2017 15:44:37.271000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 9 records loaded
prompt Loading VOTE_ITEMS...
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('8bed56eb-f00e-4767-b606-199a6c763166', '3947b80c-1cc8-4838-a951-03ad2ab8f025', '华为');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('6fbe05d7-30d0-4634-9461-5330ef197a16', '3947b80c-1cc8-4838-a951-03ad2ab8f025', '三星');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('ad66e209-fdac-413d-a998-3e59935cfdd4', '3947b80c-1cc8-4838-a951-03ad2ab8f025', '移动');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('fe1ccac6-0641-4ef4-afc0-a527d1ce7e36', '3947b80c-1cc8-4838-a951-03ad2ab8f025', '摩托罗拉');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('ad1e49d5-3239-4568-8128-9ffb5178ceaf', '3947b80c-1cc8-4838-a951-03ad2ab8f025', '诺基亚');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('49d45eb3-1da7-46fe-a2bd-e00b561c3789', 'b8a6d35a-92f0-4728-8cb6-3f3fa757f076', '你好');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('b4dd02ef-9545-443e-80d2-82ab94bbb252', 'b8a6d35a-92f0-4728-8cb6-3f3fa757f076', '你很快乐');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('249adafd-c71d-4f50-a43b-3517bfe5989c', 'b8a6d35a-92f0-4728-8cb6-3f3fa757f076', '你很悲伤');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('ab4b2bcf-ade9-48c8-aed2-9c50ebe15f7c', '64147f77-9812-4ffe-a628-0a81c9ecf73c', '劉德華');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('0c434898-c0f5-461e-b822-32e2fa2a424d', '64147f77-9812-4ffe-a628-0a81c9ecf73c', '張學友');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('89249c0f-ee51-4ef8-9d70-6dc7debb2e00', '64147f77-9812-4ffe-a628-0a81c9ecf73c', '豬八戒');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('14572292-4588-4e6b-b6e5-590b5fecfd27', '64147f77-9812-4ffe-a628-0a81c9ecf73c', '6666');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('579f9a56-e12b-42c7-b65f-ed21c5a240b0', '64147f77-9812-4ffe-a628-0a81c9ecf73c', '7777');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('08fb5c4b-cc1b-4ae3-ae8e-3fa128269728', '0e23bad6-9d83-474a-84f1-6d6a1fa9b684', '如皋');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('cf866591-6046-451c-b734-744435f1499b', '0e23bad6-9d83-474a-84f1-6d6a1fa9b684', '彭山');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('209e6ebd-6f68-4001-8459-6d2a4cf64ca0', '7ec88707-48f8-4a73-a1a8-a903dfa28025', '晴天');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('587ef373-3400-4562-9dbd-6ac548e5f930', '7ec88707-48f8-4a73-a1a8-a903dfa28025', '五月天');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('fce38d77-717f-4bd8-b5ec-68af4ed014c0', '7ec88707-48f8-4a73-a1a8-a903dfa28025', '雨天');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('ea1e5197-8bce-46df-b2fc-078fce19fbec', '7ec88707-48f8-4a73-a1a8-a903dfa28025', '阴天');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('935486f8-31fb-4e90-9e12-9dd25470d6d8', '3947b80c-1cc8-4838-a951-03ad2ab8f025', '中兴');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('1f7cbf30-2b77-4053-a717-794e7283164e', '0e23bad6-9d83-474a-84f1-6d6a1fa9b684', '张家界');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('fbfe9027-3f58-4a2c-bfd9-47dfe9634541', '1b3508a9-59a4-4236-a495-a07503496740', '亚细亚洲');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('820bc001-0da9-4e55-9604-21d12c76fd6f', 'a8d254fe-5bb6-4078-a1d7-4b5d2165beda', '1111');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('cb7b2ea0-9643-4d8f-9d85-458a5d819a09', '1b3508a9-59a4-4236-a495-a07503496740', '阿非利加州');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('f974735a-62ab-48ba-ac54-e70329631ea8', '5bdf3ca8-e110-4878-a92c-74bc1cb1af6d', '日本������������');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('d0a9e8fa-5700-4b68-9d2f-807e73d9deea', '49d52095-91af-45cb-98b7-f10181889e57', '吃饭');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('a2801298-c8b4-481e-8f34-85032c534794', '49d52095-91af-45cb-98b7-f10181889e57', '睡觉');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('b43a29dd-f86b-4626-a5a2-ff9ad331645c', '49d52095-91af-45cb-98b7-f10181889e57', '上课');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('ae2807c4-5091-4382-8a61-22f0e5af8568', '49d52095-91af-45cb-98b7-f10181889e57', '敲代码');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('dd9879ae-8337-4896-8ce0-9752a0eccc90', '5bdf3ca8-e110-4878-a92c-74bc1cb1af6d', '中国������������');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('f9818b2d-b992-4cef-ac40-97b6b082a8ba', '5bdf3ca8-e110-4878-a92c-74bc1cb1af6d', '德国������������');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('4e4dd95c-1eac-4d44-a219-44895f98c720', 'a8d254fe-5bb6-4078-a1d7-4b5d2165beda', '非洲');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('c30fe403-d30b-4e39-afb5-2005610ded57', 'a8d254fe-5bb6-4078-a1d7-4b5d2165beda', '武汉');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('82bae6af-acdd-4b36-9a6a-b4b848d97524', 'a8d254fe-5bb6-4078-a1d7-4b5d2165beda', '成都');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('f427a9c3-028c-4e24-99f8-ff1834644b03', 'a8d254fe-5bb6-4078-a1d7-4b5d2165beda', '南京');
insert into VOTE_ITEMS (ID, MASTER, DESCRIPTION)
values ('d3b0cf65-99e6-42af-b838-d657b6b3a46a', '1b3508a9-59a4-4236-a495-a07503496740', '亚美利加洲');
commit;
prompt 36 records loaded
prompt Loading USER_VOTE_ITEM...
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('87b16134-af97-40a3-a509-d9bdfbb78324', '1', '8bed56eb-f00e-4767-b606-199a6c763166', '3947b80c-1cc8-4838-a951-03ad2ab8f025');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('77f5b35d-7bbf-47f0-b199-726e8321b672', '2', '249adafd-c71d-4f50-a43b-3517bfe5989c', 'b8a6d35a-92f0-4728-8cb6-3f3fa757f076');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('29984d06-4ce7-4f59-a9ff-e20041229b98', '2', '49d45eb3-1da7-46fe-a2bd-e00b561c3789', 'b8a6d35a-92f0-4728-8cb6-3f3fa757f076');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('9af1d3b9-8a41-4c6d-a0f1-9f5e2a129b21', '1', 'b4dd02ef-9545-443e-80d2-82ab94bbb252', 'b8a6d35a-92f0-4728-8cb6-3f3fa757f076');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('e4b77df5-9581-46ea-8917-13e609436f6e', '1', 'fce38d77-717f-4bd8-b5ec-68af4ed014c0', '7ec88707-48f8-4a73-a1a8-a903dfa28025');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('ddda4690-f772-49d2-9179-ffe63915d8cd', '1', '89249c0f-ee51-4ef8-9d70-6dc7debb2e00', '64147f77-9812-4ffe-a628-0a81c9ecf73c');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('cbc421e4-e0dd-48c5-a2cd-a7da88c0d7ba', '1', 'ab4b2bcf-ade9-48c8-aed2-9c50ebe15f7c', '64147f77-9812-4ffe-a628-0a81c9ecf73c');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('42665deb-6f08-4967-a279-7ddfd46470fe', '1', '0c434898-c0f5-461e-b822-32e2fa2a424d', '64147f77-9812-4ffe-a628-0a81c9ecf73c');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('3453d4b8-d654-4214-9187-7462c344a619', '2', '89249c0f-ee51-4ef8-9d70-6dc7debb2e00', '64147f77-9812-4ffe-a628-0a81c9ecf73c');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('d60342d4-93d7-4ccb-aced-42a0654b7603', '2', 'ea1e5197-8bce-46df-b2fc-078fce19fbec', '7ec88707-48f8-4a73-a1a8-a903dfa28025');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('f689b030-5217-44bc-aedd-444fa1fa281f', '2', '6fbe05d7-30d0-4634-9461-5330ef197a16', '3947b80c-1cc8-4838-a951-03ad2ab8f025');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('0042c0cf-f841-48b9-908c-c1373110ae39', '2', 'ab4b2bcf-ade9-48c8-aed2-9c50ebe15f7c', '64147f77-9812-4ffe-a628-0a81c9ecf73c');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('4a230284-5ee3-4151-9f18-70c160858bd6', '2', 'cf866591-6046-451c-b734-744435f1499b', '0e23bad6-9d83-474a-84f1-6d6a1fa9b684');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('254feea6-4b28-48d4-8a32-749460176121', '2', 'dd9879ae-8337-4896-8ce0-9752a0eccc90', '5bdf3ca8-e110-4878-a92c-74bc1cb1af6d');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('c2f4dd90-066b-4a5a-98d4-fb0bcc1f4919', '2', 'f9818b2d-b992-4cef-ac40-97b6b082a8ba', '5bdf3ca8-e110-4878-a92c-74bc1cb1af6d');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('eb34717b-c0d0-4cf5-802d-b09c98c4432d', '1', 'dd9879ae-8337-4896-8ce0-9752a0eccc90', '5bdf3ca8-e110-4878-a92c-74bc1cb1af6d');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('7ea26252-18a1-4f1e-8230-502e1b3370ec', '2', 'b43a29dd-f86b-4626-a5a2-ff9ad331645c', '49d52095-91af-45cb-98b7-f10181889e57');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('c8162121-dbb7-4413-95d2-07ec4dd19569', '2', 'ae2807c4-5091-4382-8a61-22f0e5af8568', '49d52095-91af-45cb-98b7-f10181889e57');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('1a038693-a637-4d65-ae32-efb69704037f', '2', '4e4dd95c-1eac-4d44-a219-44895f98c720', 'a8d254fe-5bb6-4078-a1d7-4b5d2165beda');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('bd3f1130-1c7b-4c43-8c92-a04be6f39b12', '2', 'd3b0cf65-99e6-42af-b838-d657b6b3a46a', '1b3508a9-59a4-4236-a495-a07503496740');
insert into USER_VOTE_ITEM (ID, JOINER, VOTEITEM, VOTE)
values ('0179017f-8fdd-4743-ac28-ee5d1c6b9ff0', '1', 'f9818b2d-b992-4cef-ac40-97b6b082a8ba', '5bdf3ca8-e110-4878-a92c-74bc1cb1af6d');
commit;
prompt 21 records loaded
set feedback on
set define on
prompt Done.
