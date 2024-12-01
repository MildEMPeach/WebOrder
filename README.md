# WebOrder
## 关于数据库
需要mysql环境，在mysql中运行工程中的[sql脚本](databaseInitial.sql), 会进行建立数据库和建表的工作，以及向乐器表中插入三个乐器。

关于数据库的用户名及密码，在[配置文件](src/main/resources/application.yml)里面的`datasource`中配置，默认用户名是`root`，密码是`123456`。
