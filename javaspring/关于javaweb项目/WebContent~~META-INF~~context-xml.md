WebContent/META-INF/context.xml中的内容及解释

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Context>
	<Resource 
	name="jdbc/eesy_mybatis"						<!--数据源的名称-->
	type="javax.sql.DataSource"						<!--数据源类型-->
	auth="Container"								<!--数据源提供者-->
	maxActive="20"									<!--最大活动数-->
	maxWait="10000"									<!--最大等待时间-->
	maxIdle="5"										<!--最大空闲数-->
	username="root"									<!--用户名-->
	password="456321"								<!--密码-->
	driverClassName="com.mysql.cj.jdbc.Driver"		<!--驱动类,mysql5.0版本不用加cj-->
	url="jdbc:mysql://localhost:3306/eesy_mybatis"	<!--连接url字符串-->
	/>
</Context>
```

