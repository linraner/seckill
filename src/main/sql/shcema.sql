-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;

-- 使用数据库
CREATE TABLE seckill(
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMTENT '商品库存id',
`name` varchar(120) NOT NULL COMMETN '商品名称',
`number` int NOT NULL COMMETN '库存数量',
`start_time` timestamp NOT NULL COMMENT '开始时间',
`end_time` timestamp NOT NULL COMMENT '结束时间',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表'

-- 初始化数据库
insert into
  seckill(name, number, start_time, end_time)
values
  ('1000元秒杀ipad', 100, '2018-10-11 00:00:00', '2018-10-12 00:00:00')
  ('200元秒杀iphone', 100, '2018-10-11 00:00:00', '2018-10-12 00:00:00')
  ('300元秒杀ipad', 100, '2018-10-11 00:00:00', '2018-10-12 00:00:00')
  ('400元秒杀ipad', 100, '2018-10-11 00:00:00', '2018-10-12 00:00:00')