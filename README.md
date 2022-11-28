<H1 align="center">命令管理</H1>

<p align="center">
    <img src="https://img.shields.io/badge/SpringBoot-2.6.8-brightgreen.svg"/>
    <img src="https://img.shields.io/badge/maven-3.6.3-green"/>
</p>

专门用于管理命令的客户端

## 如何开始

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### 先决条件

- MySQL 5.6/8.0
- npm

```
Give examples
```

### 功能前瞻
- 可以通过命令行简单的将命令导入的库中
- 有一个在线写shell, 在线写dockerfile的命令提示编辑器
- 支持解析命令到入到库中
- 支持vim的方式操作软件
- 支持导入导出pdf等功能
- 支持离线, 通过文件的方式存储结构
- 支持在线修改命令用于使用, 一个小弹框编辑器 (支持vim编辑)
- 支持环境变量配置, 可根据环境动态生成适用于本机的命令

### 命令格式

> 一般命令格式

```shell    
# 一般命令
# ls -a /
command [option] [arguments]

# 一般命令参数合并
ls -al /

# 短格式/长格式
ls -a /
ls --all /

```