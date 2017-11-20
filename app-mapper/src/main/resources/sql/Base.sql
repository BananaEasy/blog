

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/24 22:29:20                           */
/*==============================================================*/

DROP TABLE IF EXISTS ACCESS_RECORD;

DROP TABLE IF EXISTS ARTICLE_;

DROP TABLE IF EXISTS CATEGORY_;

DROP TABLE IF EXISTS FREND_LINK;

DROP TABLE IF EXISTS LABEL_;


/*==============================================================*/
/* Table: ACCESS_RECORD                                         */
/*==============================================================*/
CREATE TABLE ACCESS_RECORD
(
   ID                   VARCHAR(32) NOT NULL,
   STARTTIME_           TIMESTAMP default CURRENT_TIMESTAMP,
   ENDTIME_             TIMESTAMP default CURRENT_TIMESTAMP,
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
   CREATETIME           TIMESTAMP default CURRENT_TIMESTAMP COMMENT '创建时间',
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
   CREATETIME           TIMESTAMP default CURRENT_TIMESTAMP,
   VERSION_             INT,
   ICO_                 VARCHAR(1024),
   RECORD_              VARCHAR(1024),
   TITLE_               VARCHAR(1024),
   PRIMARY KEY (ID)
);

ALTER TABLE CATEGORY_ COMMENT '菜单&类别';


/*==============================================================*/
/* Table: FREND_LINK                                            */
/*==============================================================*/
CREATE TABLE FREND_LINK
(
   ID                   VARCHAR(32) NOT NULL,
   CREATETIME_          TIMESTAMP default CURRENT_TIMESTAMP,
   ENDTIME_             TIMESTAMP default CURRENT_TIMESTAMP,
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
