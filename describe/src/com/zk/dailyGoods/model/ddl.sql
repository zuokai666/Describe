
drop table Goods if exists;
create table Goods(
	id int(11) not null auto_increment,
	goodsType varchar(255) not null comment='物品类型',
	longName varchar(255) not null comment='长名称',
	shortName varchar(255) default null comment='短名称',
	inputTime varchar(19) not null comment='添加时间yyyy-MM-dd HH:mm:ss',
	beginTime varchar(19) not null comment='开始时间yyyy-MM-dd HH:mm:ss',
	endTime varchar(19) not null comment='结束时间yyyy-MM-dd HH:mm:ss',
	price decimal(6,2) not null comment='单价max9999.99',
	distributor varchar(255) default null comment='经销商',
	goodsFactory varchar(255) default null comment='厂家',
	remark varchar(255) default null comment='备注',
	update_time,
	primary key('id')
)engine=innodb charset=utf-8 comment='日常物品模型';



