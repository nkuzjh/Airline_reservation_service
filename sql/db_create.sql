DROP DATABASE IF EXISTS air_booking;

CREATE DATABASE IF NOT EXISTS `air_booking` character set utf8;

USE `air_booking`;

#用户表
DROP TABLE IF EXISTS `operate_user`;
CREATE TABLE IF NOT EXISTS `operate_user`
(
    `operate_id`       INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户编号',
    `operate_tel`      VARCHAR(11) NOT NULL COMMENT '用户电话',
--     `operate_surname`  CHAR(2)     NOT NULL COMMENT '用户姓',
    `operate_username` VARCHAR(20) NOT NULL COMMENT '用户名',
    `operate_password` VARCHAR(16) NOT NULL COMMENT '用户密码',
    `operate_role`     INT         NOT NULL DEFAULT 1 COMMENT '用户权限',#1普通用户 2超级管理员
    `operate_member`   INT         NOT NULL DEFAULT 1 COMMENT '用户是否是会员',#1普通用户 2会员用户
    `operate_status`   INT         NOT NULL DEFAULT 1 COMMENT '用户状态',# 1可用 2不可用
    `operate_update`   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户默认创建时间'
);

-- insert into `operate_user` values (0,'17312300720','A','admin','admin',1,1,1,default);
insert into `operate_user` values (0,'18622745198','admin','admin',2,2,1,default);



#用户证件表
DROP TABLE IF EXISTS `certificate_info`;
CREATE TABLE IF NOT EXISTS `certificate_info`
(
    `cer_id`   INT PRIMARY KEY AUTO_INCREMENT COMMENT '证件ID',
    `cer_name` VARCHAR(50) NOT NULL COMMENT '证件名称'
);

INSERT INTO `certificate_info`(CER_ID, CER_NAME)
VALUES (0, '护照'),
       (0, '军官证'),
       (0, '身份证');
      
#用户信息表
DROP TABLE IF EXISTS `passager_info`;
CREATE TABLE IF NOT EXISTS `passager_info`
(
    `pk_id`    INT PRIMARY KEY AUTO_INCREMENT COMMENT '乘客信息ID',
    `passager_name`  VARCHAR(50) NOT NULL COMMENT '乘客姓名',
    `passager_phone` VARCHAR(13) NOT NULL COMMENT '乘客联系电话',
    `passager_gender`   VARCHAR(5)  NOT NULL COMMENT '乘客性别',
    `passager_id_type`   INT         NOT NULL COMMENT '乘客证件类型',
    `passager_id`  VARCHAR(18) NOT NULL COMMENT '乘客证件号'
);

#机舱类型表
DROP TABLE IF EXISTS `cabin_type`;
CREATE TABLE IF NOT EXISTS `cabin_type`
(
    `cabin_id`     INT PRIMARY KEY AUTO_INCREMENT COMMENT '机舱ID',
    `cabin_name`   VARCHAR(20) NOT NULL COMMENT '机舱类型名称',
    `cabin_status` INT         NOT NULL DEFAULT 1 COMMENT '机舱类型状态',# 1 可用 2 不可用
    `cabin_update` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '默认创建时间'
);

insert into cabin_type
values (0, '经济舱', 1, default);
insert into cabin_type
values (0, '商务舱', 1, default);
insert into cabin_type
values (0, '头等舱', 1, default);


#航空公司表
DROP TABLE IF EXISTS `airline_company`;
CREATE TABLE IF NOT EXISTS `airline_company`
(
    `airline_id`     INT PRIMARY KEY AUTO_INCREMENT COMMENT '航空公司ID',
    `airline_name`   VARCHAR(20) NOT NULL COMMENT '航空公司名称',
    `airline_logo`   VARCHAR(50) NOT NULL COMMENT '航空公司LOGO',
    `airline_model`  VARCHAR(50) NOT NULL COMMENT '飞机型号',
    `airline_status` INT         NOT NULL DEFAULT 1 COMMENT '航空公司状态',#1 可用 2 不可用
    `airline_update` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '默认创建时间'
);

insert into airline_company
values (0, '北京航空', '../assets/air_images/fm.png', '波音73V', 1, default);
insert into airline_company
values (0, '江苏航空', '../assets/air_images/mu.png', '波音12V', 1, default);
insert into airline_company
values (0, '南京航空', '../assets/air_images/ho.png', '波音23W', 1, default);


#航班记录表
DROP TABLE IF EXISTS `flight_records`;
CREATE TABLE IF NOT EXISTS `flight_records`
(
    `flight_id`         INT PRIMARY KEY AUTO_INCREMENT COMMENT '航班ID',
    `flight_number`     VARCHAR(50) NOT NULL COMMENT '航班编号',
    `flight_leave`      VARCHAR(50) NOT NULL COMMENT '出发地点',
    `flight_arrive`     VARCHAR(50) NOT NULL COMMENT '到达地点',
    `flight_leaveport`  VARCHAR(50) NOT NULL COMMENT '出发机场',
    `flight_arriveport` VARCHAR(50) NOT NULL COMMENT '到达机场',
    `flight_leavetime`  DATETIME    NOT NULL COMMENT '出发时间',
    `flight_arrivetime` DATETIME    NOT NULL COMMENT '抵达时间',
    `flight_duration`   VARCHAR(50) NOT NULL COMMENT '耗费时长',
    `flight_price`      FLOAT       NOT NULL COMMENT '机票价格',
    `cabins_id`         INT         NOT NULL COMMENT '外键机舱类型ID',
    `airlines_id`       INT         NOT NULL COMMENT '航空公司外键ID'
);
   
insert into flight_records values(0,'202201171747','北京','上海','北京国际机场','上海虹桥机场','2022-01-30 19:53:00','2022-01-30 23:37:00','03:44:00','12345',1,1);

#机票详情表
DROP TABLE IF EXISTS `ticket_details`;
CREATE TABLE IF NOT EXISTS `ticket_details`
(
    `ticket_id`     INT PRIMARY KEY AUTO_INCREMENT COMMENT '机票ID',
    `ticket_number` VARCHAR(255) NOT NULL COMMENT '机票详情编号',
    `operates_id`   INT          NOT NULL COMMENT '操作用户外键ID',
    `cabins_id`     INT          NOT NULL COMMENT '外键机舱类型ID',
    `airlines_id`   INT          NOT NULL COMMENT '航空公司外键ID',
    `flights_id`    INT          NOT NULL COMMENT '航班记录外键ID',
    `ticket_status` INT          NOT NULL DEFAULT 1 COMMENT '机票状态',#1 可用 2 不可用
    `ticket_update` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '默认创建时间'
);

#座位表
DROP TABLE IF EXISTS `air_seat`;
CREATE TABLE IF NOT EXISTS `air_seat`
(
    `seat_id`     INT PRIMARY KEY AUTO_INCREMENT COMMENT '座位ID',
    `seat_number` VARCHAR(50) NOT NULL COMMENT '座位编号',
    `seat_status` INT         NOT NULL DEFAULT 1 COMMENT '座位状态',#1 可用 2 不可用
    `operates_id` INT         NOT NULL COMMENT '操作用户外键ID',
    `cabins_id`   INT         NOT NULL COMMENT '机舱类型外键ID',
    `airlines_id` INT         NOT NULL COMMENT '航空公司外键ID',
    `flights_id`  INT         NOT NULL COMMENT '航班记录外键ID',
    `seat_update` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '默认创建时间'
);

#订单记录表
DROP TABLE IF EXISTS `air_order`;
CREATE TABLE IF NOT EXISTS `air_order`
(
    `order_id`     INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单记录ID',
    `order_number` VARCHAR(255) UNIQUE COMMENT '订单记录编号',
    `order_zfb_no` VARCHAR(50) NOT NULL COMMENT '支付宝账号',
    `order_update` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '默认创建时间',
    `order_status` INT         NOT NULL DEFAULT 1 COMMENT '订单状态',#1 可用 2 不可用
    `operates_id`  INT         NOT NULL COMMENT '操作用户外键ID',
    `cabins_id`    INT         NOT NULL COMMENT '机舱类型外键ID',
    `airlines_id`  INT         NOT NULL COMMENT '航空公司外键ID',
    `flights_id`   INT         NOT NULL COMMENT '航班记录外键ID',
    `tickets_id`   INT         NOT NULL COMMENT '机票详情外键ID',
    `seats_id`     INT         NOT NULL COMMENT '座位外键ID'
);
