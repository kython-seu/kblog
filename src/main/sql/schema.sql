DROP DATABASE IF EXISTS db_kblog;
/*创建数据库，并设置编码*/
CREATE DATABASE db_kblog DEFAULT CHARACTER SET utf8;

USE db_kblog;

CREATE TABLE `t_blogger` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博主id',
  `username` VARCHAR(50) NOT NULL COMMENT '博主真实姓名',
  `password` VARCHAR(100) NOT NULL COMMENT '博主密码',
  `profile` TEXT COMMENT '博主信息',
  `nickname` VARCHAR(50) DEFAULT NULL COMMENT '博主昵称',
  `sign` VARCHAR(100) DEFAULT NULL COMMENT '博主签名',
  `imagepath` VARCHAR(100) DEFAULT NULL COMMENT '博主头像路径',
  `user_phone` bigint not null COMMENT '博主手机号码',
  `user_email` VARCHAR(50) not null COMMENT '博主邮箱',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT '博主信息明细表';

INSERT INTO t_blogger(username,password,profile,user_phone,user_email)
VALUES
('lily','123','工科生','13756678420','lily@126.com'),
('李华','3wer','北京人','13825679011','lihua@163.com'),
('bobu','123','文科生','15056671228','hehe123@126.com'),
('admin','admin','管理员','15845672331','admin@126.com');


CREATE TABLE `t_link` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '友情链接表id',
  `linkname` VARCHAR(100) DEFAULT NULL COMMENT '友情链接名',
  `linkurl` VARCHAR(200) DEFAULT NULL COMMENT '友情链接url',
  `orderNum` INT(11) DEFAULT NULL COMMENT '链接排序',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


CREATE TABLE `t_blogtype` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `typeName` VARCHAR(30) DEFAULT NULL COMMENT '博客类别',
  `orderNum` INT(11) DEFAULT NULL COMMENT '博客排序',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `t_blog` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客类型',
  `title` VARCHAR(200) NOT NULL COMMENT '博客题目',
  `summary` VARCHAR(400) DEFAULT NULL COMMENT '博客摘要',
  `releaseDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布日期',
  `clickHit` INT(11) DEFAULT NULL COMMENT '查看次数',
  `replyHit` INT(11) DEFAULT NULL COMMENT '回复次数',
  `content` TEXT COMMENT '博客内容',
  `keyWord` VARCHAR(200) DEFAULT NULL COMMENT '关键字',
  `type_id` INT(11) DEFAULT NULL COMMENT '外键关联博客类别',
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_blogtype` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

CREATE TABLE `t_comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '评论表id',
  `userIp` VARCHAR(50) DEFAULT NULL COMMENT '评论者的ip',
  `nickName` VARCHAR(50) DEFAULT NULL COMMENT '评论者的昵称',
  `content` VARCHAR(1000) DEFAULT NULL COMMENT '评论内容',
  `commentTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论日期',
  `state` INT(11) DEFAULT 0 COMMENT '审核状态',
  `blog_id` INT(11) DEFAULT NULL COMMENT '外键关联具体博客',
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/**
add data
 */
INSERT INTO t_link(linkname,linkurl,orderNum) VALUES
('github','https://github.io/',NULL),
('music','https://music.io/',NULL),
('video','https://video.io/',NULL);