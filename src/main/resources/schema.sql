drop database if exists common_project_db;
create database common_project_db;
use common_project_db;

create table user (
    -- 사용자 번호
	user_number int unsigned auto_increment,
	-- 사용자 아이디
    id varchar(30) not null,
    -- 사용자 비밀번호
    password varchar(30) not null,
    -- 사용자 이름
    name varchar(15) not null,
    -- 사용자 전화번호
    phone varchar(13),
    -- 사용자 주소
    address text,
    -- 관리자 상태 0이면 일반 사용자, 1이면 관리자
    admin_state int unsigned default 0,
    -- 가입 날짜
    join_date datetime default now(),
    -- 회원탈퇴 상태 0이면 탈퇴 1이면 미탈퇴
    drop_state int unsigned default 0,
    constraint primary key(user_number)
);