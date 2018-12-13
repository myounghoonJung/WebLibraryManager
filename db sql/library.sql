
-- web library 용

-- table 생성

create table tbl_book(
    bookid varchar2(60) constraint pk_book_id primary key,
    booktitle varchar2(60) not null,
    author varchar2(60) not null,
    genre varchar2(30) not null,
    status char(1) default 'N' check (status in ('B','N')) not null
);

create table tbl_book_del(
    delno number constraint pk_book_del_delno primary key,
    deldate date default sysdate not null,
    bookid varchar2(60) not null,
    booktitle varchar2(60) not null,
    author varchar2(60) not null,
    genre varchar2(30) not null
);

create table tbl_member(
    memberid varchar2(30) constraint pk_member_memberid primary key,
    memberpw varchar2(30) not null,
    membername varchar2(20) not null,
    gender char(1) check (gender in ('M','F')) not null,
    birthday date,
    phone varchar2(13) not null,
    favoritegenre varchar2(60),
    presentborrowcount number default 0,
    historyborrowcount number default 0,
    enrolldate date default sysdate not null
);

create table tbl_member_quit(
    quitno number constraint pk_member_quit_quitno primary key,
    quitdate date default sysdate not null,
    memberid varchar2(30) not null,
    memberpw varchar2(30) not null,
    membername varchar2(20) not null,
    gender char(1) check (gender in ('M','F')) not null,
    birthday date not null,
    phone varchar2(13) not null,
    favoritegenre varchar2(60) not null,
    historyborrowcount number not null,
    enrolldate date not null
);

create table tbl_borrow_logger(
    logno number constraint pk_borrow_logno primary key,
    logdate date default sysdate not null,
    bookid varchar2(60) not null,
    borrowdate date,
    untilborrowdate date,
    returndate date,
    status char(1) default 'N' check (status in ('B','R')) not null,
    memberid varchar2(30) not null
);

create table tbl_member_logger(
    logno number constraint pk_logger_no primary key,
    logdate date default sysdate not null,
    memberid varchar2(30),
    status char(1) not null check (status in ('I','O')),
    ip varchar2(100) not null
);


-- sequence 생성
-- tbl_book_del(delno)
create sequence seq_book_del;

-- tbl_member_quit(quitno)
create sequence seq_member_quit;

-- tbl_borrow_logger(logno)
create sequence seq_borrow_logger;

-- tbl_member_logger(logno)
create sequence seq_member_logger;


-- trigger 생성

-- 책 빌리면/반납하면(tbl_borrow_log에 추가) tbl_book의 status 변경
create or replace trigger trg_borrow_logger
    after
    insert on tbl_borrow_logger
    for each row
declare
    cnt_memberid varchar2(30);
    cnt_bookid varchar2(60);
    v_status char(1);
begin
    select status into v_status from tbl_book where bookid=:new.bookid;
    -- case문으로 bookid랑 memberid가 존재해야지만 빌릴 수 있게
    select count(*) into cnt_memberid from tbl_member where memberid=:new.memberid;
    select count(*) into cnt_bookid from tbl_book where bookid=:new.bookid;
    case
        when :new.status='B' and v_status = 'N' and cnt_memberid = 1 and cnt_bookid = 1 then
            update tbl_book set status='B' where bookid=:new.bookid;
            update tbl_member set presentborrowcount=(select presentborrowcount from tbl_member)+1 where memberid=:new.memberid;
            update tbl_member set historyborrowcount=(select historyborrowcount from tbl_member)+1 where memberid=:new.memberid;
        when :new.status='R' and v_status = 'B' and cnt_memberid = 1 and cnt_bookid = 1 then
            update tbl_book set status='N' where bookid=:new.bookid;
            update tbl_member set presentborrowcount=(select presentborrowcount from tbl_member)-1 where memberid=:new.memberid;
        end case;
end;
/

-- 도서 삭제하면 tbl_book_del에 추가
create or replace trigger trg_book_del
    after
    delete on tbl_book
    for each row
begin
    insert into tbl_book_del (delno,bookid,booktitle,author,genre) values (SEQ_BOOK_DEL.nextval,:old.bookid,:old.booktitle,:old.author,:old.genre);
end;
/

-- 멤버 삭제하면 tbl_member_quit에 추가
create or replace trigger trg_member_quit
    after
    delete on tbl_member
    for each row
begin
    insert into tbl_member_quit (quitno,memberid,memberpw,membername,gender,birthday,phone,favoritegenre,historyborrowcount,enrolldate) 
                         values (seq_member_quit.nextval,:old.memberid,:old.memberpw,:old.membername,:old.gender,:old.birthday,:old.phone,:old.favoritegenre,:old.historyborrowcount,:old.enrolldate);
end;
/




