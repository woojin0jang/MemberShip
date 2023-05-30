
create table admin_accounts(
    
    idx number(4) not null,
    admin_id varchar2(50) not null,
    admin_password varchar2(50) not null

);
alter table admin_accounts add(

    constraint admin_idx_pk primary key(idx)

)
create sequence admin_idx_seq start with 1;

insert into admin_accounts(idx,admin_id,admin_password)values (admin_idx_seq.NEXTVAL, 'admin', 'sungil');



create table member_accounts (

    idx number(4) not null,
    user_name varchar2(50) not null,
    user_id varchar2(50) not null,
    user_password varchar2(50) not null,
    user_hak number(4) not null,
    user_ban number(4) not null,
    user_bun number(4) not null

);

alter table member_accounts add (

    constraint member_idx_pk primary key (idx)

);

create sequence member_idx_seq start with 1;

insert into member_accounts (idx,user_name,user_id,user_password,user_hak,user_ban,user_bun)
values
(member_idx_seq.NEXTVAL,'Å×½ºÆ®1','test1','12345',2,10,22);





















