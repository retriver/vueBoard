
CREATE TABLE TB_BOARD (
  DOC_NO int(10) not null,
  TITLE varchar(400) not null,
  CONTENT varchar(4000) not null,
  WRITER varchar(400) not null,
  REG_DTTM timestamp  default CURRENT_TIMESTAMP,
  VIEW int(10) default 0, primary key (DOC_NO)
)ENGINE=InnoDB DEFAULT CHARSET=euckr ;

create table TB_REPLY (
  REPLY_NO int(10) not null,
  DOC_NO int(10) not null,
  WRITER varchar(400) not null,
  CONTENT varchar(4000) not null,
  REG_DTTM timestamp  default CURRENT_TIMESTAMP,
  primary key (REPLY_NO, DOC_NO),
  foreign key (DOC_NO) references TB_BOARD(DOC_NO)
);