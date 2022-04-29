select * from spring_board;

create table spring_board(
	bno number(10,0),
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
);

alter table spring_board add constraint pk_spring_board primary key(bno);

insert into spring_board(bno,title,content,writer) values(seq_board.nextval,'아아','이이','오오');

--oracle페이지 나누기
--rownum 을 사용한다 (가상의 인덱스번호)
select rownum,bno,title from spring_board;

--rownum은 order by절과 함께 쓸때 조심해야된다.
--order by절에서 사용하는 컬럼이 index가 아닐때 !
--임의로 행을 갖고 나온 후 버노를 붙이는거다
-- 인라인쿼리.
--select rownum 
--from(select * from board where bno>0 order by re_ref desc)



--더미데이터
insert into SPRING_BOARD(bno,title,content,writer)
(select seq_board.nextval,title,content,writer from spring_board);
--1) rownum 사용 방식
select rownum,bno,title,writer 
from (select bno,title,writer from spring_board 
order by bno desc)
where rownum<=10;

--2) order by 컬럼이 인덱스라면 오라클 힌트 이용 가능
		--이렇게 힌트를 줘서 똑같은 작업을 시킬 수 있다?
select /*+INDEX_DESC(spring_board pk_spring_board)*/rownum,bno,title,writer 
from spring_board
where rownum<=10;

--1page의 최신글
select bno,title,writer,regdate,updatedate
from (
	select /*+INDEX_DESC(spring_board pk_spring_board)*/rownum rn,bno,title,writer,regdate,updatedate
	from spring_board
	where rownum<=10
)
where rn>0;


--1page의 최신글
select bno,title,writer,regdate,updatedate
from (select /*+INDEX_DESC(spring_board pk_spring_board)*/rownum rn,bno,title,writer,regdate,updatedate from spring_board where rownum<=?)where rn>?;