
此目录是平台基于maven-assembly-plugin插件输出制品部署包，目录文件为 $[ARTIFACTID]-$[VERSION]-package.zip，每一个服务单独解压、启动。

使用方法可以查看文档 http://win-data.ddns.e-lead.cn:10010/#/./others/assembly

assembly目录结构

```bash
assembly
├── UserGuide.md                          指导描述
├── assembly.xml                          maven-assembly-plugin插件配置
├── apps                                  制品jar包
├── bin                                   
|         ├── 00-1-1-init-db.sh           初始化数据库 for Windows
|         ├── 00-1-1-init-db.bat            初始化数据库 for Linux
|         ├── 00-2-load-db.bat            跨库数据库脚本 for Windows
|         ├── 00-2-load-db.sh             跨库数据库脚本 for Linux
|         ├── 01-1-start.bat              启动脚本服务 for Windows
|         └── 01-1-start.sh               启动脚本服务 for Linux
├── docker
|         └── docker-compose.yaml         docker-compose定义文件
└── init-sql
          ├── message                     跨库脚本目录
          |         ├── change            当前版本增量  
          |             └── ....sql 
          |         └── data              数据脚本
          |             └── ....sql
          ├── system                      初始化数据库脚本目录
          |         ├── change            补丁版本脚本目录
          |         |         ├── data    数据脚本
          |         |             └── ....sql
          |         |         └── ddl     结构脚本
          |         |             └── ....sql
          |         ├── data              初始化数据库数据脚本    
          |         |   └── ....sql
          |         └── ddl               初始化数据库结构脚本
          |             └── ....sql
          └── upgrade                     大版本升级脚本
              ├── data                    数据脚本  
              |   └── ....sql
              └── ddl                     结构脚本
                  └── ....sql
```


| 序号 | 名称          | 版本                         | 说明 |
| ---- | ------------- | ---------------------------- | ---- |
| 1    | MySQL         | 5.7                          |      |
| 2    | MongoDB       | 4.4.10                       |      |
| 3    | Redis         | 4.0-alpine                   |      |
| 4    | Elasticsearch | 6.8.2                        |      |
| 5    | Nacos-server  | 1.4.2                        |      |
| 6    | JAVA          | 8                            |      |
| 7    | RocketMQ      | 4.5.0                        | 消息队列服务类型为rocketmq时需要     |


| 序号 | 名称 | 版本 | 说明 |
| ---- |----|----|----|
| 1 | erdcloud-system | 2.3.0 |  |
| 2 | erdcloud-message | 2.2.0 |  |
| 3 | erdcloud-core-mq | 2.2.0 |  |


使用maven mvn install命令，maven-assembly-plugin插件会在target目录下生成一份 $[ARTIFACTID]-$[VERSION]-package.zip 文件，解压可得到制品包目录。


