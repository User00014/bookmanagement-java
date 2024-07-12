DROP DATABASE IF EXISTS `bookmanagement`;
CREATE DATABASE `bookmanagement`;
use `bookmanagement`;

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`username` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '账号',
`password` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '密码',
`name` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '名称',
`avatar` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '头像',
`role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'admin' COMMENT '角色标识',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='管理员表';

INSERT INTO `admin` (username, password, name, avatar, role) VALUES ('admin', '123456', '管理员', 'http://localhost:9090/files/qy-default.png', 'admin');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`username` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '账号',
`password` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '密码',
`name` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '名称',
`avatar` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '头像',
`phone` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '手机',
`role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'user' COMMENT '角色标识',
`writer_id` int(10) DEFAULT NULL COMMENT '作者ID',
`borrow_id` int(10) DEFAULT NULL COMMENT '其他图书借阅记录ID',
`book_id` int(10) DEFAULT NULL COMMENT '书籍ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';


DROP TABLE IF EXISTS `writer`;
CREATE TABLE `writer` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`username` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '账号',
`password` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '密码',
`name` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '名称',
`avatar` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '头像',
`email` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '邮箱',
`role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'writer' COMMENT '角色标识',
`book_id` int(10) DEFAULT NULL COMMENT '书籍ID',
`publisher_id` int(10) DEFAULT NULL COMMENT '出版社ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='作者表';


DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`username` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '账号',
`password` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '密码',
`name` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '名称',
`avatar` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '头像',
`email` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '邮箱',
`role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'publisher' COMMENT '角色标识',
`writer_id` int(10) DEFAULT NULL COMMENT '作者ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='出版社表';


DROP TABLE IF EXISTS `txtbook`;
CREATE TABLE `txtbook` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`trackno` int(10) DEFAULT 0 COMMENT '单本编号',
`trackname` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '单本名称',
`time` double(10,2) DEFAULT 0 COMMENT '页数',
`audio` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '电子书',
`writer_id` int(10) DEFAULT NULL COMMENT '作者ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='书籍表';


DROP TABLE IF EXISTS `otherbook`;
CREATE TABLE `otherbook` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`otherbookno` int(10) DEFAULT 0 COMMENT '其他图书编号',
`otherbookname` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '其他图书名称',
`releasedate` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '发行日期',
`author` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '作者',
`price` double(10,2) DEFAULT 0 COMMENT '价格',
`borrow_otherbook_records_id` int(10) DEFAULT NULL COMMENT '其他图书借阅记录ID',
`txtbook_id` int(10) DEFAULT NULL COMMENT '书籍ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='其他图书表';


DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`date` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '日期',
`name` varchar(255) COLLATE utf8mb4_unicode_ci COMMENT '名称',
`txtbook_id` int(10) DEFAULT NULL COMMENT '书籍ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='借阅表';



