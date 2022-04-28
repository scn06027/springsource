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
