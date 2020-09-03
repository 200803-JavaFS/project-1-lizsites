


drop table if exists ers_reimbursement;
drop table if exists ers_users;
drop table if exists ers_reimbursement_type;
drop table if exists ers_reimbursement_status;
drop table if exists ers_user_roles;
create table ers_user_roles (ERS_USER_ROLE_ID SERIAL primary key, USER_ROLE varchar(10) not null);
create table ers_reimbursement_type (REIMB_TYPE_ID SERIAL primary key, REIMB_TYPE varchar(10) NOT NULL);
create table ers_reimbursement_status (REIMB_STATUS_ID SERIAL primary key, REIMB_STATUS varchar(10)not NULL);
create table ers_users (ERS_USERS_ID SERIAL primary key, ERS_USERNAME varchar(50) not NULL, ERS_PASSWORD varchar(50) not NULL, USER_FIRST_NAME varchar(100) not NULL, USER_LAST_NAME varchar(100) not NULL, USER_EMAIL varchar(150) not null, USER_ROLE_ID Integer references ers_user_roles not NULL);

create table ers_reimbursement (REIMB_ID SERIAL primary key, REIMB_AMOUNT numeric(12,2) not null, REIMB_SUBMITTED TIMESTAMP not null, REIMB_RESOLVED TIMESTAMP, REIMB_DESCRIPTION VARCHAR(250), REIMB_AUTHOR Integer references ers_users not null , REIMB_RESOLVER Integer references ers_users, REIMB_STATUS_ID Integer references ers_reimbursement_status not null, REIMB_TYPE_ID integer references ers_reimbursement_type not null); 
drop function getTime();
create or replace function getTime() returns TIMESTAMP with time zone as 
$$ select current_timestamp;
$$ language sql;
insert into ers_user_roles (user_role) values ('admin');
insert into ers_reimbursement_type (reimb_type) values ('FOOD');
insert into ers_reimbursement_status (reimb_status) values ('DENIED');
insert into ers_reimbursement_status (reimb_status) values ('APPROVED');
insert into ers_reimbursement_status (reimb_status) values ('PENDING');
insert into ers_users (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) values ('melia23', 'password', 'melia', 'miller', 'doggo@yahoo.com', 1);
insert into ers_reimbursement (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) values (38, getTime(), 'Wasted my time at India Palace',1,1,1);

ALTER TABLE public.ers_users ADD CONSTRAINT ers_users_un UNIQUE (ers_username);
alter table ers_users add constraint user_email_un unique (user_email);