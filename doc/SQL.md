# SQL

```sql
-- 命令
CREATE TABLE `command` (
    `command_id` bigint NOT NULL COMMENT '命令ID',
    `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '命令名称',
    `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '命令描述',
    PRIMARY KEY (`command_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

```sql
-- 命令参数表
CREATE TABLE `command_arg` (
    `arg_id` bigint NOT NULL COMMENT '命令参数ID',
    `command_id` bigint NOT NULL COMMENT '命令ID',
    `short_name` varchar(50) DEFAULT NULL COMMENT '简称',
    `full_name` varchar(255) NOT NULL COMMENT '全称',
    `description` varchar(255) DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`arg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
