# Web后端知识

## 一.Maven

### 1.1 Maven相关介绍

Maven是用来管理和构建Java项目的工具

* 方便快捷地管理项目依赖的资源(jar包)
* 标准化的跨平台自动化项目构建方式
* 提供标准，统一的项目结构



**Maven结构**

<img src="C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20260920165610104.png" alt="image-20260920165610104" style="zoom:200%;" />

Maven的仓库用来存储和管理jar包

分为本地仓库，远程仓库和中央仓库



**Maven坐标**

* maven中的坐标是资源(jar)的唯一标识，通过该坐标可以唯一定位资源位置
* 使用坐标来定义项目或引入项目中需要的依赖



* Maven坐标的主要组成
  * groupId:定义当前Maven项目隶属组织的名称（域名反写）
  * artifactId:定义当前Maven项目名称（通常是模块名称 如order-service,goods-service)
  * version:当前版本号

### 1.2 Maven依赖管理

* 在pom.xml中编写<dependencies>标签
* 在<dependencies>标签中使用<denpendency>引入坐标

* 定义坐标的groupId,artifactId,version
* 刷新，引入最新加入的坐标

### 1.3 单元测试



## 二.Web基础

### 2.1 SpringBoot入门

**入门程序的剖析**

起步依赖

* spring-boot-starter-webmvc-test：包含单元测试的需要的所有依赖
* spring-boot-starter-webmvc:包含web开发的所有依赖

运行main方法运行内部集成的tomcat服务器（依赖中包含的方法）

### 2.2 HTTP协议

* 超文本传输协议，浏览器与服务器之间数据传输的规则

* 基于TCP协议：面向连接，安全
* 基于请求-响应模型：一次请求对应一次响应
* HTTP协议是无状态的协议：对于事务处理没有记忆能力，每次的请求-响应是独立的
  * 缺点：多次请求之间无法共享数据
  * 优点：速度快
  
* URL:用来定位和访问资源的地址，平常说的“网址”就是一种 URL。

  * 比如：http://localhost:8080/hello?name=heima

    | 部分          | 含义                                |
    | ------------- | ----------------------------------- |
    | `http://`     | 使用 HTTP 协议                      |
    | `localhost`   | 访问本机                            |
    | `8080`        | 访问本机的 8080 端口                |
    | **`/hello`**  | URL 路径，指定要访问的接口          |
    | `?name=heima` | 查询参数，传入 `name`，值为 `heima` |

#### 2.2.1 HTTP请求协议

**请求行**

请求数据第一行（请求方式，资源路径，协议）

**请求头**

第二行开始，格式​key:value

![image-20261027170144598](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261027170144598.png)

**各个请求头的含义**

![image-20260921172246522](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20260921172246522.png)

**请求体**

POST请求，存放请求参数；请求头和请求体之间用一个空行隔开

* 对GET请求来说：请求参数在请求行中，没有请求体，GET请求大小在浏览器中是有限制的
* 对POST请求来说：请求参数在请求体中，POST请求大小是没有限制的

#### 2.2.2 HTTP协议请求数据获取

* HttpServletRequest对象里面封装了所有的请求信息

#### 2.2.3 HTTP响应协议

响应数据分为三个部分：

响应行，响应头，响应体

* 响应行：响应数据的第一行（协议,状态码，描述）
* 响应头：第二行开始 格式key:value
* 响应体：最后一部分，存放响应数据

![image-20261027170819532](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261027170819532.png)

**常见响应状态码**

![image-20261027171049488](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261027171049488.png)



![image-20260921194027372](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20260921194027372.png)

**常见响应头的含义**

![image-20261027171108357](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261027171108357.png)



#### 2.2.4 HTTP响应数据设置

**方法一**

通过HttpServletResponse对象封装HTTP原始数据进行解析后的结果，可以直接调用API进行操作

通过调用该对象中的方法实现相应状态码（一般无需设置，浏览器处理后自动返回），响应头和响应体

**方法二**

通过ResponseEntity中的方法来完成配置

![](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20260921211708259.png)

### 2.3 分层解耦

#### 2.3.1 三层架构

Controller:控制层，接受前端发送的请求，对请求进行处理，并响应数据

service:业务逻辑层，处理具体的业务逻辑

dao：数据访问层（Data Access Object)（持久层），负责数据访问操作，包括数据的增删改查

前端给请求->controller->调用Service->调用dao取得数据

dao的实现可以有文本，网络，数据库

#### 2.3.2 IOC与DI入门

耦合：衡量软件中各个层/各个模块的依赖关联程度

内聚：软件中各个功能模块内部的功能联系

 

控制反转：IOC 

* 对象的创建控制权由程序自身转移到外部（容器）这里就是Spring容器

* 可以使用`@Component`注解将类交给IOC容器管理（是加在实现类上面而不是接口上面）

  * `@Component`的衍生注解：

    ![image-20261027182809974](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261027182809974.png)

依赖注入：DI

* 容器为应用程序提供运行时所依赖的资源
* 具体是指当一个对象需要使用另一个对象时，由容器将它需要的对象传入。依赖注入是实现控制反转的一种方式。
* 使用`@Autowired`注解可以从IOC容器中找到该类型的bean，然后完成依赖注入

Bean对象：IOC容器中创建，管理的对象

## 三.MySQL数据模型

* 关系型数据库：建立在关系模型基础上，由多张相互连接的二维表组成的数据库

### 3.1 SQL语句-DDL

* SQL：一门操作关系型数据库的编程语言，定义操作所有关系型数据库的统一标准

*   分类

  <img src="C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261007093938222.png" alt="image-20261007093938222" style="zoom:200%;" />



**==DDL -数据库==**

```sql
--查询所有数据库
show databases;
--查询当前数据库
select database();
--使用/切换数据库
use 数据库名;
--创建数据库
create database [if not exists] 数据库名 [default charset utf8mb4];
--删除数据库
drop database [if exists] 数据库名;
```

#### 3.1.1 创建表

create table tablename{

​	字段1 字段类型【约束】[comment 字段1注释]

​	字段2 字段类型【约束】[comment 字段2注释]

}【comment 表注释】

【约束】作用：约束作用于表中字段上的规则，用于限制存储在表中的数据

![image-20261008193726660](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261008193726660.png)

#### 3.1.2 数据类型



<img src="C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261008212501719.png" alt="image-20261008212501719" style="zoom:200%;" />

选取原则：在满足业务需求的前提下，尽可能选择占用磁盘空间小的数据类型

age - tinyint unsigned

id -int unsighed 



**字符串类型**

![image-20261008234118735](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261008234118735.png)



**日期类型**

![image-20261008234211096](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261008234211096.png)



**设计步骤**

* 阅读并分析页面原型及需求
* 分析表中包含哪些字段，以及字段的类型和约束
* 创建表结构

#### 3.1.3 表结构的查询修改和删除

<img src="C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261013185535275.png" alt="image-20261013185535275" style="zoom:200%;" />

### 3.2 SQL语句-DML

用于对数据库中表的数据记录进行增删改操作

**Insert**

| 类型                     | SQL 语法                                                     |
| ------------------------ | ------------------------------------------------------------ |
| 指定字段添加数据         | INSERT INTO 表名 (字段名1, 字段名2) VALUES (值1, 值2);       |
| 全部字段添加数据         | INSERT INTO 表名 VALUES (值1, 值2, ...);                     |
| 批量添加数据（指定字段） | INSERT INTO 表名 (字段名1, 字段名2) VALUES (值1, 值2), (值1, 值2); |
| 批量添加数据（全部字段） | INSERT INTO 表名 VALUES (值1, 值2, ...), (值1, 值2, ...);    |



**Update**

```sql
-- 修改数据
update 表名 set 字段名1 = 值1 , 字段名2 = 值2 , .... [ where  条件 ] ;
```

where 表示要更新的数据是哪一条；没有where就会更新整张表



**delete**

```sql
-- 删除数据
delete from 表名 [where 条件];
```

delete不能删除某一个字段的值；如果要这样操作可以使用update将该字段置为NULL

### 3.3 SQL语句-DQL

完整DQL语句语法

```sql
select
    字段列表
from
    表名列表
where
    条件列表
group by
    分组字段列表
having
    分组后条件列表
order by
    排序字段列表
limit
    分页参数
```



#### 3.3.1 基本查询

```sql
-- 查询多个字段
select 字段1,字段2,字段3 from 表名;

-- 查询所有字段(通配符)
select * from 表名;

-- 为查询字段设置别名，as关键字可以省略
select 字段1 [as 别名1], 字段2 [as 别名2] from 表名;

-- 去除重复记录
select distinct 字段列表 from 表名;
```

#### 3.3.2 条件查询

```sql
-- 条件查询
select 字段列表 from 表名 where 条件列表 ;
```

![image-20261027124119552](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261027124119552.png)

判断字段值是不是null 应该用is null

between … and … 	应该先写最小值后写最大值

like +占位符 模糊匹配 （_ 表示单个字符	%表示匹配任意个字符）

==组装多个查询条件== 	使用and或者or



## 四.JDBC

JDBC:使用java操作关系型数据库的一套API（行为规范）

### 4.1 JDBC入门

* 注册驱动
* 获取连接
* 获取SQL语句并执行对象
* 执行SQL
* 释放资源

```java

@Test
public void testUpdate() throws Exception {
    //1. 注册驱动
    //Class.forname将指定的类加载到内存中
    Class.forName("com.mysql.cj.jdbc.Driver");

    //2. 获取数据库连接
    String url = "jdbc:mysql://localhost:3306/web01";
    String username = "root";
    String password = "1234";
    Connection connection = DriverManager.getConnection(url, username, password);

    //3. 获取SQL语句执行对象
    Statement statement = connection.createStatement();

    //4. 执行SQL
    int i = statement.executeUpdate("update user set age = 25 where id = 1");//DML
    System.out.println("SQL执行完毕影响的记录数为：" + i);

    //5. 释放资源
    statement.close();
    connection.close();
}

```

### 4.2 JDBC查询数据

基于JDBC执行如下select语句，将查询结果封装到User对象中。

```sql
select * from user where username = 'daqiao' and password = '123456'
```

* ResultSet(结果集对象)：

  ```java
  ResultSet rs = statement.executeQuery()
  ```

  * `next()`：将光标从当前位置向前移动一行，并判断当前行是否为有效行，返回值为boolean。

    - `true`：有效行，当前行有数据
    - `false`：无效行，当前行没有数据

    `getXxx(...)`：获取数据，可以根据列的编号获取，也可以根据列名获取

    例如：

    ```java
    while (resultSet.next()) {
        int id = resultSet.getInt("id");
        //...省略
    }
    ```

    

### 4.3 预编译SQL

* 优势1：防止SQL注入，更安全
  * SQL注入：通过控制输入来修改事先定义好的SQL语句，以达到执行代码对服务器进行攻击的目的
* 优势2：性能更高

![image-20261029224645233](C:\Users\bairimengxiangjia\AppData\Roaming\Typora\typora-user-images\image-20261029224645233.png)

执行SQL时会直接到缓存中去找编译后的SQL,无需再次编译

## 五.Mybatis

持久层框架，用于简化 JDBC的开发
