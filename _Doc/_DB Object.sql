
-----------------------------------
-- MySQL
-----------------------------------
	CREATE TABLE TB_BOARD (
	  DOC_NO int(10) not null,
	  TITLE varchar(400) not null,
	  CONTENT varchar(4000) not null,
	  WRITER varchar(400) not null,
	  REG_DTTM timestamp  default CURRENT_TIMESTAMP,
	  READ_CNT int(10) default 0, primary key (DOC_NO)
	)ENGINE=InnoDB DEFAULT CHARSET=euckr ;

	CREATE TABLE TB_REPLY (
	  REPLY_NO int(10) not null,
	  DOC_NO int(10) not null,
	  WRITER varchar(400) not null,
	  CONTENT varchar(4000) not null,
	  REG_DTTM timestamp  default CURRENT_TIMESTAMP,
	  primary key (REPLY_NO, DOC_NO),
	  foreign key (DOC_NO) references TB_BOARD(DOC_NO)
	);

-----------------------------------
-- Oracle
-----------------------------------
   CREATE TABLE "PEARL"."TB_BOARD"
   (
    "DOC_NO" NUMBER NOT NULL ENABLE,
    "TITLE" VARCHAR2(400) NOT NULL ENABLE,
    "CONTENT" VARCHAR2(4000) NOT NULL ENABLE,
    "WRITER" VARCHAR2(100) DEFAULT 'Y' NOT NULL ENABLE,
    "REG_DTTM" DATE DEFAULT SYSDATE NOT NULL ENABLE,
    "READ_CNT" NUMBER DEFAULT 0, CONSTRAINT PK_TB_BOARD PRIMARY KEY("DOC_NO")
    );

   CREATE TABLE "PEARL"."TB_REPLY"
   (
    "REPLY_NO" NUMBER NOT NULL ENABLE,
    "DOC_NO" NUMBER NOT NULL ENABLE,
    "WRITER" VARCHAR2(100) DEFAULT 'Y' NOT NULL ENABLE,
    "CONTENT" VARCHAR2(4000) NOT NULL ENABLE,
    "REG_DTTM" DATE DEFAULT SYSDATE NOT NULL ENABLE,
    CONSTRAINT PK_TB_REPLY PRIMARY KEY("REPLY_NO", "DOC_NO") ,
    CONSTRAINT RF_TB_REPLY  FOREIGN KEY("DOC_NO")  REFERENCES TB_BOARD("DOC_NO")
    );

