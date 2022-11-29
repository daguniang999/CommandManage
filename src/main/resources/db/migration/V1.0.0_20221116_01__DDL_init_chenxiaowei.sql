-- 命令
drop table if exists `command`;
create table `command` (
    `command_id` bigint not null comment '命令ID',
    `name` varchar(50) not null comment '命令名称',
    `description` varchar(255) default null comment '命令描述',
    PRIMARY KEY (`command_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 命令参数
drop table if exists `command_arg`;
create table `command_arg` (
    `command_arg_id` bigint not null comment '命令参数ID',
    `command_id` bigint not null comment '命令ID',
    `type` tinyint(4) not null comment '参数类型',
    `symbol` tinyint(4) not null comment '分隔符',
    `name` varchar(50) default null comment '参数名',
    `sequence` int(11) not null comment '顺序',
    `description` varchar(255) default null comment '描述',
    PRIMARY KEY (`command_arg_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 命令分组
drop table if exists `command_group`;
create table `command_group` (
    `group_id` bigint not null comment '命令分组ID',
    `name` varchar(50) not null comment '分组名称',
    `description` varchar(255) default null comment '分组描述',
    primary key (`group_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 命令分组关联
drop table if exists `command_group_relation`;
create table `command_group_relation` (
    `group_relation_id` bigint not null comment '命令分组关联ID',
    `command_id` bigint not null comment '命令ID',
    `group_id` bigint not null comment '分组ID',
    primary key (`group_relation_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 命令实例
drop table if exists `command_instance`;
create table `command_instance` (
    `instance_id` bigint not null comment '命令实例ID',
    `command_id` bigint not null comment '命令ID',
    `description` varchar(255) default null comment '命令实例描述',
    primary key (`instance_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 命令实例参数
drop table if exists `command_instance_arg`;
create table `command_instance_arg` (
    `instance_arg_id` bigint not null comment '命令实例参数ID',
    `command_arg_id` bigint not null comment '命令参数ID',
    `value` varchar(255) default null comment '参数值',
    `default_value` varchar(255) default null comment '参数默认值',
    primary key (`instance_arg_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 环境配置
drop table if exists `environment`;
create table `environment` (
    `env_id` bigint(11) not null comment '环境ID',
    `name` varchar(255) not null comment '环境名称',
    `description` varchar(255) default null comment '环境描述',
    primary key (`env_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 环境变量配置
drop table if exists `environment_variable`;
create table `environment_variable` (
    `env_variable_id` bigint not null comment '环境变量ID',
    `env_id` bigint not null comment '环境ID',
    `name` varchar(255) not null comment '变量名称',
    `value` varchar(255) default null comment '变量值',
    primary key (`env_variable_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 回收站
drop table if exists `recycle`;
create table `recycle` (
    `recycle_id` bigint not null comment '回收ID',
    `type` tinyint(4) not null comment '类型',
    `json` json not null comment '删除数据结构',
    `time` datetime not null comment '删除时间',
    primary key (`recycle_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;
