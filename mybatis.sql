-- system user
drop user mybatis cascade; -- 복습을 위한 코드

-- 과제: mybatis/mybatis 인 user 를 만들어라.
create user mybatis identified by mybatis default tablespace users; -- system user와 다른저장공간을 사용(포트폴리오때도 사용)
-- role 부여
grant connect, resource to mybatis;
-- DCL(Data Control Language)

-- 과제: 카페의 테이블설계도를 보고, 테이블 3개를 만들어라. mybatis - mybatis 스키마 - 테이블설계도
-- mybatis 스키마에 만들어야한다, 접속스키마를 하나 더만들던지, 객체경로 명시하던지
--create table mybatis.users(
--    user_id number(2) constraint users_userid_pk primary key,
--    user_name varchar2(12),
--    reg_date date);
--
--create table mybatis.addresses(
--    user_id number(2) constraint addresses_users_fk references mybatis.users(user_id)
--                      constraint addresses_userid_pk primary key,
--    address varchar2(30));
--    
--create table mybatis.posts(
--    post_id number(3) constraint posts_postid_pk primary key,
--    post_title varchar2(60),
--    post_content varchar2(120),
--    user_id number(2) constraint posts_users_fk references mybatis.users(user_id));
----------
-- 제약조건과 필드를 구분
create table mybatis.users(
user_id number(2),
user_name varchar2(12),
reg_date date);

create table mybatis.addresses(
user_id number(2),
address varchar2(30));

create table mybatis.posts(
post_id number(3),
post_title varchar2(60),
post_content varchar2(120),
user_id number(2));

alter table mybatis.users
    add constraint user_userid_pk primary key(user_id);
alter table mybatis.addresses
    add constraint addr_userid_pk primary key(user_id);
alter table mybatis.posts
    add constraint post_postid_pk primary key(post_id);
    
alter table mybatis.addresses
    add constraint addr_userid_fk foreign key(user_id)
    references mybatis.users(user_id);
alter table mybatis.posts
    add constraint post_userid_fk foreign key(user_id)
    references mybatis.users(user_id);
    
insert into mybatis.users
    values(1, 'john', to_date('2024-05-20', 'yyyy-mm-dd'));
insert into mybatis.users
    values(2, 'terry', to_date('2024-05-23', 'yyyy_mm_dd'));
    
insert into mybatis.addresses
    values(1, '서울시 마포구');
insert into mybatis.addresses
    values(2, '성남시 분당구');

insert into mybatis.posts
    values(101, '사랑', '너와 나의 연결고리', 1);
insert into mybatis.posts
    values(102, '정의', '너와 나의 연대고리', 1);
insert into mybatis.posts
    values(201, '김치', '네가 있어야 밥을 먹지', 2);
insert into mybatis.posts
    values(202, '비빔밥', '동학농민항쟁이 만든 음식이다.', 2);
insert into mybatis.posts
    values(203, '찹쌀떡', '네가 그리워.', 2);
    
commit; -- F5 스크립트 전체 실행