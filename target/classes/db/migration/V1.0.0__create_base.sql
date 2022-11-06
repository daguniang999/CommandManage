-- 命令
create table `command` (
    `command_id` bigint not null comment '命令ID',
    `name` varchar(50) character set utf8mb4 collate utf8mb4_0900_ai_ci not null comment '命令名称',
    `description` varchar(255) CHARACTER SET utf8mb4 collate utf8mb4_0900_ai_ci not null comment '命令描述',
    `create_time` datetime not null default current_timestamp comment '创建时间',
    `update_time` datetime not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (`command_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 命令参数
create table `command_arg` (
    `arg_id` bigint not null comment '命令参数ID',
    `command_id` bigint not null comment '命令ID',
    `short_name` varchar(50) default null comment '简称',
    `full_name` varchar(255) not null comment '全称',
    `description` varchar(255) default null comment '描述',
    `create_time` datetime not null default current_timestamp comment '创建时间',
    `update_time` datetime not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (`arg_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 命令分组
create table `command_group` (
    `group_id` bigint not null comment '分组ID',
    `name` varchar(50) not null comment '分组名称',
    `description` varchar(255) default null comment '分组描述',
    primary key (`group_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 命令分组关联
create table `command_group_relation` (
    `relation_id` bigint not null comment '关系ID',
    `command_id` bigint not null comment '命令ID',
    `group_id` bigint not null comment '分组ID',
    primary key (`relation_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

-- 命令模板
create table `command_template` (
    `template_id` bigint not null comment '命令模板ID',
    `name` varchar(50) not null comment '模板名称',
    `format` varchar(400) not null comment '模板格式(需要解析)',
    `description` varchar(255) not null comment '模板描述',
    primary key (`template_id`)
) engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;
