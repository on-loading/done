####用XML配置实现MyBatis增删改查的例子
数据库结构：<br>
		+------+----------------------+---------+-------+<br>
		| no   | bookName             | author  | price |<br>
		+------+----------------------+---------+-------+<br>
		| 1001 | effective-java-2     | shad    |   101 |<br>
		| 1002 | MyBatis从入门到精通  | sidf    |   101 |<br>
		| 1004 | 阿里巴巴Java开发手册 | masof   |    32 |<br>
		| 1006 | MySQL技术内幕        | shad    |   100 |<br>
		| 1016 | 数据库原理           | seyg    |    47 |<br>
		| 1021 | 数据结构             | sudfuyi |   101 |<br>
		| 1024 | 算法导论             | sudfuyi |   156 |<br>
		+------+----------------------+---------+-------+<br>
• models包中的是实体类
• mappers包中的是对应的映射接口
• unitTest包中是单元测试类
• mybatisConfig.xml文件中是各种配置信息，SQL语句在BookMapper.xml中