
-- web library 용

-- table 생성

create table tbl_book(
    bookid number constraint pk_book_id primary key,
    booktitle varchar2(60) not null,
    author varchar2(60) not null,
    genre varchar2(30) not null,
    status char(1) default 'N' check (status in ('B','N')) not null,
    delflag char(1) default 'N' check (delflag in ('Y','N')) not null,
    deldate date
);

create table tbl_book_del(
    bookid number constraint pk_book_del_id primary key,
    booktitle varchar2(60) not null,
    author varchar2(60) not null,
    genre varchar2(30) not null,
    deldate date default sysdate not null
);

create table tbl_member(
    memberid varchar2(30) constraint pk_member_memberid primary key,
    memberpw varchar2(30) not null,
    membername varchar2(20) not null,
    gender char(1) check (gender in ('M','F')) not null,
    birthday date not null,
    phone varchar2(13) not null,
    favoritegenre varchar2(60) not null,
    presentborrowcount number default 0,
    historyborrowcount number default 0,
    enrolldate date default sysdate not null,
    quitflag char(1) default 'N' check (quitflag in ('Y','N')) not null,
    quitdate date
);

create table tbl_member_quit(
    memberid varchar2(30) constraint pk_member_quit_memberid primary key,
    memberpw varchar2(30) not null,
    membername varchar2(20) not null,
    gender char(1) check (gender in ('M','F')) not null,
    birthday date not null,
    phone varchar2(13) not null,
    favoritegenre varchar2(60) not null,
    historyborrowcount number not null,
    enrolldate date not null,
    quitdate date default sysdate not null
);

create table tbl_borrow_logger(
    logno number constraint pk_borrow_logno primary key,
    logdate date default sysdate not null,
    bookid number constraint fk_borrow_bookid references tbl_book(bookid),
    booktitle varchar2(60) not null,
    author varchar2(60) not null,
    genre varchar2(30) not null,
    borrowdate date,
    untilborrowdate date,
    returndate date,
    status char(1) default 'N' check (status in ('B','R')) not null,
    borrowmemberid constraint fk_borrow_memberid references tbl_member(memberid)
);

create table tbl_member_logger(
    logno number constraint pk_logger_no primary key,
    logdate date default sysdate not null,
    memberid varchar2(30) constraint fk_logger_memberid references tbl_member(memberid),
    status char(1) not null check (status in ('I','O')),
    ip varchar2(100) not null
);


-- sequence 생성

-- tbl_book(bookid)
create sequence seq_book;

-- tbl_borrow_log(logno)
create sequence seq_borrow_log;

-- tbl_member_logger(logno)
create sequence seq_member_logger;


-- trigger 생성

-- 책 빌리면/반납하면(tbl_borrow_log에 추가) tbl_book의 status 변경
create or replace trigger trg_borrow_logger
    after
    insert on tbl_borrow_logger
    for each row
declare
    anotherbookid number;
    anotherstatus char(1);
begin
    anotherbookid := :new.bookid;
    select status into anotherstatus from tbl_book where bookid=anotherbookid;
    case
        when :new.status='B' and anotherstatus = 'N' then
            update tbl_book set status='B' where bookid=:new.bookid;
            update tbl_member set presentborrowcount=(select presentborrowcount from tbl_member)+1;
            update tbl_member set historyborrowcount=(select historyborrowcount from tbl_member)+1;
        when :new.status='R' and anotherstatus = 'B' then
            update tbl_book set status='N' where bookid=:new.bookid;
            update tbl_member set presentborrowcount=(select presentborrowcount from tbl_member)-1;
        end case;
end;
/

-- 도서 삭제(delflag 변경)하면 tbl_book_del에 추가
create or replace trigger trg_book_del
    after
    update of delflag, deldate on tbl_book
    for each row
begin
    case when :new.delflag='Y' then
        insert into tbl_book_del (bookid,booktitle,author,genre) values (:old.bookid,:old.booktitle,:old.author,:old.genre);
    end case;
end;
/

-- 멤버 삭제(quitflag 변경)하면 tbl_member_quit에 추가
create or replace trigger trg_member_quit
    after
    update of quitflag, quitdate on tbl_member
    for each row
begin
    case when :new.quitflag='Y' then
        insert into tbl_member_quit (memberid,memberpw,membername,gender,birthday,phone,favoritegenre,historyborrowcount,enrolldate) 
                             values (:old.memberid,:old.memberpw,:old.membername,:old.gender,:old.birthday,:old.phone,:old.favoritegenre,:old.historyborrowcount,:old.enrolldate);
    end case;
end;
/




