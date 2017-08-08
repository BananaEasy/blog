/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/24 22:29:20                           */
/*==============================================================*/


DROP TABLE IF EXISTS ACCESS_RECORD;

DROP TABLE IF EXISTS ARTICLE_;

DROP TABLE IF EXISTS CATEGORY_;

DROP TABLE IF EXISTS COMMENT_;

DROP TABLE IF EXISTS FREND_LINK;

DROP TABLE IF EXISTS LABEL_;

DROP TABLE IF EXISTS MESSAGE_;

DROP TABLE IF EXISTS USER_;

/*==============================================================*/
/* Table: ACCESS_RECORD                                         */
/*==============================================================*/
CREATE TABLE ACCESS_RECORD
(
   ID                   VARCHAR(32) NOT NULL,
   STARTTIME_           TIMESTAMP,
   ENDTIME_             TIMESTAMP,
   MILLISECOND_         INT,
   COOKIE_              VARCHAR(1000),
   USERAGENT_           VARCHAR(255),
   IPS_                 VARCHAR(1000),
   METHOD_              VARCHAR(1000),
   REFERER_             VARCHAR(1000),
   ACCEPT_              VARCHAR(1000),
   ACCEPTENCODING_      VARCHAR(1000),
   ACCEPTLANGUAGE_      VARCHAR(1000),
   CONNECTION_          VARCHAR(1000),
   HOST_                VARCHAR(1000),
   XREQUESTEDWITH_      VARCHAR(1000),
   REQUESTPATH_         TEXT,
   USERID               VARCHAR(32),
   PRIMARY KEY (ID)
);

ALTER TABLE ACCESS_RECORD COMMENT '访问记录';

/*==============================================================*/
/* Table: ARTICLE_                                              */
/*==============================================================*/
CREATE TABLE ARTICLE_
(
   ID                   INT NOT NULL AUTO_INCREMENT COMMENT 'id',
   LABEL_ID             INT COMMENT '标签_id',
   CATEGORY_ID          INT COMMENT '菜单&_ID',
   ARTICLEUSERNAME      VARCHAR(1024) COMMENT '文章作者',
   CREATETIME           TIMESTAMP COMMENT '创建时间',
   ARTICLETITLE         VARCHAR(1024) COMMENT '文章名称',
   ARTICLEHREF          VARCHAR(1024) COMMENT '文章来自链接',
   ARTICLEHREFTITLE     VARCHAR(1024) COMMENT '文章来自哪个网站的标题',
   COUNT_               BIGINT COMMENT '浏览次数',
   TOP_                 INT COMMENT '置顶',
   ISLOCK                 INT COMMENT '是否锁定',
   VERSION_             INT COMMENT '版本号',
   ISORIGINAL_          INT COMMENT '是否是原创',
   ARTICLETITLEIMAGEPATH1 VARCHAR(1024) COMMENT '文章标题提示图片',
   ARTICLETITLEIMAGEPATH2 VARCHAR(1024) COMMENT '文章标题提示图片2',
   ARTICLECONTENT       TEXT COMMENT '文章内容',
   ARTICLEPROMPT		VARCHAR(1024),
   PRIMARY KEY (ID)
);

ALTER TABLE ARTICLE_ COMMENT '文章';

/*==============================================================*/
/* Table: CATEGORY_                                             */
/*==============================================================*/
CREATE TABLE CATEGORY_
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   RANK_                INT,
   LINK_                VARCHAR(1024),
   NAME_                VARCHAR(1024),
   PARENTID_            INT,
   CREATETIME           TIMESTAMP,
   VERSION_             INT,
   ICO_                 VARCHAR(1024),
   RECORD_              VARCHAR(1024),
   TITLE_               VARCHAR(1024),
   PRIMARY KEY (ID)
);

ALTER TABLE CATEGORY_ COMMENT '菜单&类别';

/*==============================================================*/
/* Table: COMMENT_                                              */
/*==============================================================*/
CREATE TABLE COMMENT_
(
   ID                   VARCHAR(32) NOT NULL,
   ARTICLE_ID           INT,
   USER_ID              VARCHAR(32),
   CREATETIME           TIMESTAMP,
   CONTENT_             TEXT,
   ISMAIN_              INT,
   SONCOUNT_            INT,
   PARENTID             VARCHAR(32),
   RANK_                INT,
   TEMPTITLE            VARCHAR(1024),
   PRIMARY KEY (ID)
);

ALTER TABLE COMMENT_ COMMENT '评论';

/*==============================================================*/
/* Table: FREND_LINK                                            */
/*==============================================================*/
CREATE TABLE FREND_LINK
(
   ID                   VARCHAR(32) NOT NULL,
   CREATETIME_          TIMESTAMP,
   ENDTIME_             TIMESTAMP,
   LINK_                VARCHAR(1024),
   LINKTITLE_           VARCHAR(200),
   RECORD_              TEXT,
   VERSION              INT,
   PRIMARY KEY (ID)
);

ALTER TABLE FREND_LINK COMMENT '友情链接';

/*==============================================================*/
/* Table: LABEL_                                                */
/*==============================================================*/
CREATE TABLE LABEL_
(
   ID                   INT NOT NULL AUTO_INCREMENT,
   NAME_                VARCHAR(200),
   CREATETIME           TIMESTAMP,
   VERSION_             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE LABEL_ COMMENT '标签';

/*==============================================================*/
/* Table: MESSAGE_                                              */
/*==============================================================*/
CREATE TABLE MESSAGE_
(
   ID                   VARCHAR(32) NOT NULL,
   USER_ID              VARCHAR(32),
   CONTENT_             TEXT,
   CREATETIME           TIMESTAMP,
   PRIMARY KEY (ID)
);

ALTER TABLE MESSAGE_ COMMENT '留言';

/*==============================================================*/
/* Table: USER_                                                 */
/*==============================================================*/
CREATE TABLE USER_
(
   ID                   VARCHAR(32) NOT NULL,
   CREATETIME           TIMESTAMP,
   EMAIL_               VARCHAR(200),
   USERNAME_            VARCHAR(200),
   USERHEADIMAGE        VARCHAR(1024),
   PRIMARY KEY (ID)
);

ALTER TABLE USER_ COMMENT '用户表';

ALTER TABLE ARTICLE_ ADD CONSTRAINT FK_RELATIONSHIP_1 FOREIGN KEY (CATEGORY_ID)
      REFERENCES CATEGORY_ (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ARTICLE_ ADD CONSTRAINT FK_RELATIONSHIP_2 FOREIGN KEY (LABEL_ID)
      REFERENCES LABEL_ (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE COMMENT_ ADD CONSTRAINT FK_RELATIONSHIP_3 FOREIGN KEY (ARTICLE_ID)
      REFERENCES ARTICLE_ (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE COMMENT_ ADD CONSTRAINT FK_RELATIONSHIP_4 FOREIGN KEY (USER_ID)
      REFERENCES USER_ (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE MESSAGE_ ADD CONSTRAINT FK_RELATIONSHIP_5 FOREIGN KEY (USER_ID)
      REFERENCES USER_ (ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

