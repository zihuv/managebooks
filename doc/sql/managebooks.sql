/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50740 (5.7.40)
 Source Host           : localhost:3306
 Source Schema         : managebooks

 Target Server Type    : MySQL
 Target Server Version : 50740 (5.7.40)
 File Encoding         : 65001

 Date: 08/02/2023 11:42:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员名称',
  `admin_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
  `admin_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `admin_admin_name_uindex`(`admin_name`) USING BTREE,
  UNIQUE INDEX `admin_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'wuyanzu', '123', 'yanzu@qq.com');
INSERT INTO `admin` VALUES (2, 'liuhuaqiang', '444', 'huaqiang@163.com');
INSERT INTO `admin` VALUES (3, 'xiaoma', '648', 'xiaoma@qq.com');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书籍id',
  `book_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书籍名称',
  `book_author` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书籍作者',
  `book_publish` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书籍出版社',
  `book_category` int(11) NOT NULL COMMENT '书籍类别',
  `book_prize` double NULL DEFAULT NULL COMMENT '书籍价格',
  `book_introduction` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书籍介绍',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `book_id_uindex`(`id`) USING BTREE,
  INDEX `book_book_category_id_fk`(`book_category`) USING BTREE,
  CONSTRAINT `book_book_category_id_fk` FOREIGN KEY (`book_category`) REFERENCES `book_category` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '书籍基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '三国演义', '罗贯中', '四川天地出版社', 1, 30, '我国第一部长篇章回体历史演义小说');
INSERT INTO `book` VALUES (2, '我与地坛', '史铁生', '人名文学出版社', 2, 31, '《我与地坛》是史铁生文学作品中，充满哲思又极为人性化的代表作之一。');
INSERT INTO `book` VALUES (3, '活着', '余华', '北京十月文艺出版社', 1, 29, '人是为了活着本身而活着的，而不是为了活着之外的任何事物而活着。');
INSERT INTO `book` VALUES (4, '瓦尔登湖', '梭罗', '中央编译出版社', 2, 9.9, '“给生活做减法，给思想做加法”');
INSERT INTO `book` VALUES (5, 'Head First Java', '贝茨', '中国电力出版社', 10, 39.5, 'JAVA经典畅销书 生动有趣 轻松学好JAVA');
INSERT INTO `book` VALUES (6, '三体', '刘慈欣', '重庆出版社', 1, 44.7, '《三体》第73届世界科幻雨果奖获奖作品，银河奖特别奖，《三体3》轨迹奖长篇科幻小说！2017年世界雨果奖提名作品。');
INSERT INTO `book` VALUES (7, '理想国', '柏拉图', '民主与建设出版社', 3, 30.4, '《理想国》将读者引入一个朴素美好的思想殿堂，成为培养读者心灵与智慧的沃土。');
INSERT INTO `book` VALUES (8, '苏东坡传', '林语堂', '湖南文艺出版社', 5, 12.99, '林语堂完整授权，各版本累计销量超300万册，中国传记文学经典之作。');
INSERT INTO `book` VALUES (9, '孙子兵法', '孙武', '安徽文艺出版社', 4, 25.5, '名家译注，精选底本，万字导言，用典注释，精妙解读，选纸考究，封面覆触感膜，附四色战役经过示意图。');
INSERT INTO `book` VALUES (10, '时间简史', '史蒂芬·霍金', '湖南科技出版社', 9, 29.3, '史蒂芬·霍金的《时间简史》自1988年首版以来的岁月里，已成为全球科学著作的里程碑。它被翻译成40种文字，销售了近1000万册，成为国际出版史上的奇观。');
INSERT INTO `book` VALUES (11, '鸡汤是怎样炼成的', '老冯', '日本天皇出版社', 6, 43, '诶嘿嘿嘿~鸡汤来咯~~');
INSERT INTO `book` VALUES (12, '学会拒绝', '阿伟', '湾湾出版社', 5, 32, '“杰哥不要！”——阿伟书中如是说道');
INSERT INTO `book` VALUES (13, '站狼', '昊京', '中国出版社', 1, 33, '任何邪恶，终将绳之以法！！！');
INSERT INTO `book` VALUES (14, '炎拳', '藤本树', '东立出版社', 7, 249, '“对他使用炎拳吧！”藤本树暖心治愈之作，堂堂连载！');
INSERT INTO `book` VALUES (15, '野兽仙人', '田所浩二', '下北泽出版社', 5, 11.45, '逸一时，误一世，逸久逸久罢已龄（悲）');

-- ----------------------------
-- Table structure for book_category
-- ----------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书籍类别id',
  `category_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书籍类别名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `book_category_id_uindex`(`id`) USING BTREE,
  UNIQUE INDEX `book_category_category_name_uindex`(`category_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '书籍类别' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_category
-- ----------------------------
INSERT INTO `book_category` VALUES (8, '书法');
INSERT INTO `book_category` VALUES (5, '传记');
INSERT INTO `book_category` VALUES (4, '军事');
INSERT INTO `book_category` VALUES (3, '哲学');
INSERT INTO `book_category` VALUES (1, '小说');
INSERT INTO `book_category` VALUES (2, '散文');
INSERT INTO `book_category` VALUES (7, '漫画');
INSERT INTO `book_category` VALUES (9, '科普读物');
INSERT INTO `book_category` VALUES (10, '计算机');
INSERT INTO `book_category` VALUES (6, '食谱');

-- ----------------------------
-- Table structure for borrow_book
-- ----------------------------
DROP TABLE IF EXISTS `borrow_book`;
CREATE TABLE `borrow_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '借书用户id',
  `book_id` int(11) NOT NULL COMMENT '所借的书籍id',
  `borrow_date` date NOT NULL COMMENT '借书日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `borrow_books_id_uindex`(`id`) USING BTREE,
  UNIQUE INDEX `borrow_books_book_id_fk`(`book_id`) USING BTREE,
  INDEX `borrow_books_user_id_fk`(`user_id`) USING BTREE,
  CONSTRAINT `borrow_book_book_id_fk` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `borrow_books_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '借书记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow_book
-- ----------------------------
INSERT INTO `borrow_book` VALUES (1, 1, 1, '2022-01-01');
INSERT INTO `borrow_book` VALUES (2, 4, 4, '2023-01-30');

-- ----------------------------
-- Table structure for borrow_book_backup
-- ----------------------------
DROP TABLE IF EXISTS `borrow_book_backup`;
CREATE TABLE `borrow_book_backup`  (
  `id` int(11) NOT NULL COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `book_id` int(11) NOT NULL COMMENT '书籍id',
  `borrow_date` date NOT NULL COMMENT '借书日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `borrow_book_backup_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '记录借书表删除数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow_book_backup
-- ----------------------------

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作者的用户名',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作类名',
  `method_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方法名称',
  `uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作路径',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `create_date` datetime NULL DEFAULT NULL COMMENT '日志创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `operation_log_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_user_name_uindex`(`user_name`) USING BTREE,
  UNIQUE INDEX `user_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '333', 'zhangsan@outlook.com');
INSERT INTO `user` VALUES (2, 'lisi', '444', 'lisi@qq.com');
INSERT INTO `user` VALUES (3, 'wangwu', '555', 'wangwu@gmail.com');
INSERT INTO `user` VALUES (4, 'zhaoliu', '666', 'zhaoliu@163.com');
INSERT INTO `user` VALUES (5, 'qiqi', '777', 'qiqi@qq.com');

-- ----------------------------
-- Triggers structure for table borrow_book
-- ----------------------------
DROP TRIGGER IF EXISTS `borrow_book_delete_trigger`;
delimiter ;;
CREATE TRIGGER `borrow_book_delete_trigger` AFTER DELETE ON `borrow_book` FOR EACH ROW begin
        insert into borrow_book_backup values (old.id,old.user_id,OLD.book_id,OLD.borrow_date);
    end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
