# WebLibraryManager



## DB 설정

### table 설정

```sql
create table tbl_book(
    bookid number constraint pk_book_id primary key,
    booktitle varchar2(60) not null,
    author varchar2(60) not null,
    genre varchar2(30) not null,
    status char(1) default 'N' check (status in ('B','N'))
);

create table tbl_book_del(
    deldate date default sysdate,
    bookid number constraint pk_book_del_id primary key,
    booktitle varchar2(60) not null,
    author varchar2(60) not null,
    genre varchar2(30) not null
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
    enrolldate date default sysdate
);

create table tbl_member_quit(
    quitdate date default sysdate,
    memberid varchar2(30) constraint pk_member_quit_memberid primary key,
    memberpw varchar2(30) not null,
    membername varchar2(20) not null,
    gender char(1) check (gender in ('M','F')) not null,
    birthday date not null,
    phone varchar2(13) not null,
    favoritegenre varchar2(60) not null,
    historyborrowcount number not null,
    enrolldate date not null
);

create table tbl_borrow_log(
    logno number constraint pk_borrow_logno primary key,
    logdate date default sysdate,
    bookid number constraint fk_borrow_bookid references tbl_book(bookid) on delete set null,
    booktitle varchar2(60) not null,
    author varchar2(60) not null,
    genre varchar2(30) not null,
    borrowdate date,
    untilborrowdate date,
    returndate date,
    status char(1) default 'N' check (status in ('B','R')),
    borrowmemberid constraint fk_borrow_memberid references tbl_member(memberid) on delete cascade
);
```



### sequence 설정

```sql
-- tbl_book(bookid)
create sequence seq_book;

-- tbl_borrow_log(logno)
create sequence seq_borrow_log;
```



### trigger 설정

```sql
-- 책 빌리면/반납하면(tbl_borrow_log에 추가) tbl_book의 status 변경
create or replace trigger trg_borrow_log
    after
    insert on tbl_borrow_log
    for each row
begin
    case
        when :new.status='B' then
            update tbl_book set status='B' where bookid=:new.bookid;
        when :new.status='R' then
            update tbl_book set status='N' where bookid=:new.bookid;
        end case;
end;
/

-- 도서 삭제하면 tbl_book_del에 추가
create or replace trigger trg_book_del
    after
    delete on tbl_book
    for each row
begin
    insert into tbl_book_del (bookid,booktitle,author,genre) values (:old.bookid,:old.booktitle,:old.author,:old.genre);
end;
/

-- 멤버 삭제하면 tbl_member_quit에 추가
create or replace trigger trg_member_quit
    after
    delete on tbl_member
    for each row
begin
    insert into tbl_member_quit (memberid,memberpw,membername,gender,birthday,phone,favoritegenre,historyborrowcount,enrolldate) 
    values (:old.memberid,:old.memberpw,:old.membername,:old.gender,:old.birthday,:old.phone,:old.favoritegenre,:old.historyborrowcount,:old.enrolldate);
end;
/
```



