## 1. 创建maven项目

	创建webapp ：maven-archetype-webapp 1.0

	Group Id：org.seckill	//组织Id，一般是域名的反写

	Artifact Id：seckill		//项目名称

## 2. 设置JDK版本

> ##### 2.1 设置\src\main\webapp\WEB-INF\web.xml，修改WEB-INF下的web.xml文件中servlet版本。（参考Tomcat/webapps/examples/WEB-INF下的web.xml文件。）

    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
    	http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
      version="3.1"
      metadata-complete="true">
    </web-app>

> ##### 2.2 eclipse的workspace下，\workspace\mybatis.settings\org.eclipse.jdt.core.prefs

    eclipse.preferences.version=1
    org.eclipse.jdt.core.compiler.codegen.inlineJsrBytecode=enabled
    org.eclipse.jdt.core.compiler.codegen.targetPlatform=1.8
    org.eclipse.jdt.core.compiler.compliance=1.8
    org.eclipse.jdt.core.compiler.problem.assertIdentifier=error
    org.eclipse.jdt.core.compiler.problem.enumIdentifier=error
    org.eclipse.jdt.core.compiler.problem.forbiddenReference=warning
    org.eclipse.jdt.core.compiler.source=1.8

> ##### 2.3 eclipse的workspace下，\workspace\mybatis.settings\org.eclipse.wst.common.component

    <project-modules id="moduleCoreId" project-version="1.5.0">
        <wb-module deploy-name="mybatis">
            <wb-resource deploy-path="/" source-path="/target/m2e-wtp/web-resources"/>
            <wb-resource deploy-path="/" source-path="/src/main/webapp" tag="defaultRootSource"/>
            <wb-resource deploy-path="/WEB-INF/classes" source-path="/src/main/java"/>
            <wb-resource deploy-path="/WEB-INF/classes" source-path="/src/main/resources"/>
            <wb-resource deploy-path="/WEB-INF/classes" source-path="/src/test/java"/>
            <property name="context-root" value="mybatis"/>
            <property name="java-output-path" value="/mybatis/target/classes"/>
        </wb-module>
    </project-modules>

> ##### 2.4 eclipse的workspace下，\workspace\mybatis.settings\org.eclipse.wst.common.project.facet.core.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <faceted-project>
      <fixed facet="wst.jsdt.web"/>
      <installed facet="java" version="1.8"/>
      <installed facet="jst.web" version="3.1"/>
      <installed facet="wst.jsdt.web" version="1.0"/>
    </faceted-project>

> ##### 2.5 eclipse菜单，Project下clean...， 项目右键后 refresh

> ##### 2.6 项目右键，properties：java build path:jdk SE -> jdk workspace default JRE设置本机的设有环境变量的JDK

> ##### 2.7 项目右键，properties：选择Project Facets java -> 1.8 和选择Dynamic Web Module ->3.1

> ##### 2.8 设置 pom.xml

    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>demo.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <packaging>war</packaging>
      <version>0.0.1-SNAPSHOT</version>
      <name>mybatis Maven Webapp</name>
      <url>http://maven.apache.org</url>
      <dependencies>
        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>3.8.1</version>
          <scope>test</scope>
        </dependency>
        <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    	</dependency>
      </dependencies>
      <build>
        <finalName>mybatis</finalName>
        <plugins>
        <plugin>
    	    <groupId>org.apache.maven.plugins</groupId>
    	    <artifactId>maven-compiler-plugin</artifactId>
    	    <version>3.1</version>
    	    <configuration>
    	        <source>1.8</source>
    	        <target>1.8</target>
    	    </configuration>
    	</plugin>
        </plugins>
      </build>
    </project>

## 3. 修改maven框架结构目录
    	src
    	 -main
    	   -java
    	   -resources
    	   -webapp
    	     -WEB-INF
    	       -web.xml
    	 -test
    	   -java
    	   -resources

## 4. 修改pom.xml，添加相关依赖。

    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>org.ice</groupId>
      <artifactId>seckill</artifactId>
      <packaging>war</packaging>
      <version>0.0.1-SNAPSHOT</version>
      <name>seckill Maven Webapp</name>
      <url>http://maven.apache.org</url>
      <dependencies>
        <dependency>
        <!-- 用注解的方式使用junit4 -->
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.11</version>
          <scope>test</scope>
        </dependency>
        
        <!-- 补全项目依赖 -->
        <!-- 1.日志 java日志：slf4j，log4j，logback，common-logging
        		slf4j 是规范／接口
        		日志实现：log4j，logback，common-logging
        		使用：slf4j + logback 
        	-->
        	
        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
    	<dependency>
    	    <groupId>org.slf4j</groupId>
    	    <artifactId>slf4j-api</artifactId>
    	    <version>1.7.21</version>
    	</dependency>
    	
    	<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-core -->
    	<dependency>
    	    <groupId>ch.qos.logback</groupId>
    	    <artifactId>logback-core</artifactId>
    	    <version>1.1.2</version>
    	</dependency>
    	
    	<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
    	<!-- 实现slf4j接口并整合 -->
    	<dependency>
    	    <groupId>ch.qos.logback</groupId>
    	    <artifactId>logback-classic</artifactId>
    	    <version>1.1.2</version>
    	</dependency>
    	
    	<!-- 2:数据库相关依赖 -->
    	<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    	<dependency>
    	    <groupId>mysql</groupId>
    	    <artifactId>mysql-connector-java</artifactId>
    	    <version>5.1.38</version>
    	    	<scope>runtime</scope>
    	</dependency>
    	
    	<!-- https://mvnrepository.com/artifact/c3p0/c3p0 -->
    	<dependency>
    	    <groupId>c3p0</groupId>
    	    <artifactId>c3p0</artifactId>
    	    <version>0.9.1.2</version>
    	</dependency>
    	
    	<!-- 3:DAO框架：MyBatis依赖 -->
    	<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
    	<dependency>
    	    <groupId>org.mybatis</groupId>
    	    <artifactId>mybatis</artifactId>
    	    <version>3.4.1</version>
    	</dependency>
    	
    	<!-- MyBatis自身实现的spring整合依赖 -->
    	<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
    	<dependency>
    	    <groupId>org.mybatis</groupId>
    	    <artifactId>mybatis-spring</artifactId>
    	    <version>1.3.0</version>
    	</dependency>
    		
    	<!-- 4:servlet web 相关依赖 -->
    	<!-- https://mvnrepository.com/artifact/taglibs/standard -->
    	<dependency>
    	    <groupId>taglibs</groupId>
    	    <artifactId>standard</artifactId>
    	    <version>1.1.2</version>
    	</dependency>
    	<!-- https://mvnrepository.com/artifact/jstl/jstl -->
    	<dependency>
    	    <groupId>jstl</groupId>
    	    <artifactId>jstl</artifactId>
    	    <version>1.2</version>
    	</dependency>
    
    	<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
    	<dependency>
    	    <groupId>com.fasterxml.jackson.core</groupId>
    	    <artifactId>jackson-databind</artifactId>
    	    <version>2.8.8</version>
    	</dependency>
    	<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
    	<dependency>
    	    <groupId>javax.servlet</groupId>
    	    <artifactId>javax.servlet-api</artifactId>
    	    <version>3.1.0</version>
    	</dependency>
    	
    	<!-- 4:spring依赖 -->
    	<!-- 1）sprin核心依赖 -->
    	<!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
    	<dependency>
    	    <groupId>org.springframework</groupId>
    	    <artifactId>spring-core</artifactId>
    	    <version>4.3.7.RELEASE</version>
    	</dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
    	<dependency>
    	    <groupId>org.springframework</groupId>
    	    <artifactId>spring-beans</artifactId>
    	    <version>4.3.7.RELEASE</version>
    	</dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
    	<dependency>
    	    <groupId>org.springframework</groupId>
    	    <artifactId>spring-context</artifactId>
    	    <version>4.3.7.RELEASE</version>
    	</dependency>
    	
    	<!-- 2）spring dao层依赖 -->
    	<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
    	<dependency>
    	    <groupId>org.springframework</groupId>
    	    <artifactId>spring-jdbc</artifactId>
    	    <version>4.3.7.RELEASE</version>
    	</dependency>
    	<!-- https://mvnrepository.com/artifact/org.springframework/spring-tx -->
    	<dependency>	
    	    <groupId>org.springframework</groupId>
    	    <artifactId>spring-tx</artifactId>
    	    <version>4.3.7.RELEASE</version>
    	</dependency>
    
    	<!-- 3）spring web 相关依赖 -->
    	<!-- https://mvnrepository.com/artifact/org.springframework/spring-web -->
    	<dependency>
    	    <groupId>org.springframework</groupId>
    	    <artifactId>spring-web</artifactId>
    	    <version>4.3.7.RELEASE</version>
    	</dependency>
    	<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    	<dependency>
    	    <groupId>org.springframework</groupId>
    	    <artifactId>spring-webmvc</artifactId>
    	    <version>4.3.7.RELEASE</version>
    	</dependency>
    	
    	<!-- 4）spring test依赖 -->
    	<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
    	<dependency>
    	    <groupId>org.springframework</groupId>
    	    <artifactId>spring-test</artifactId>
    	    <version>4.3.7.RELEASE</version>
    	    <scope>test</scope>
    	</dependency>
    	
      </dependencies>
      <build>
        <finalName>seckill</finalName>
    	  <plugins>
    	       <plugin>
    	             <groupId>org.apache.maven.plugins</groupId>
    	             <artifactId>maven-compiler-plugin</artifactId>
    	             <version>3.1</version>
    	             <configuration>
    	                 <source>1.8</source>
    	                 <target>1.8</target>
    	             </configuration>
    	       </plugin>
    	  </plugins>
    	</build>
    </project>

## 5. 数据库建表

    -- 数据库初始化脚本
    -- 创建数据库
    CREATE DATABASE seckill;
    -- 使用数据库
    use seckill;
    -- 创建秒杀库存表
    CREATE TABLE seckill(
    seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
    name varchar(120) NOT NULL COMMENT '商品名称',
    number int NOT NULL COMMENT '库存数量',
    start_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀开启时间',
    end_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束时间',
    create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (seckill_id),
    key idx_start_time(start_time),
    key idx_end_time(end_time),
    key idx_create_time(create_time)
    )ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';
    
    -- 初始化数据
    insert INTO 
    seckill(name,number,start_time,end_time)
    VALUES
    ('1000元秒杀iphone6',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
    ('500元秒杀ipad2',200,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
    ('300元秒杀小米4',300,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
    ('200元秒杀红米note',400,'2015-11-01 00:00:00','2015-11-02 00:00:00');
    
    -- 秒杀成功明细表
    -- 用户登录认证相关的信息
    create table success_killed(
    seckill_id BIGINT NOT NULL COMMENT '秒杀商品id',
    user_phone BIGINT NOT NULL COMMENT '用户手机号',
    state TINYINT NOT NULL  NOT NULL DEFAULT -1 COMMENT '标识状态 -1 无效 0成功 1已付款 2 已发货 ',
    create_time TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (seckill_id,user_phone),/*联合主键*/
    KEY idx_create_time(create_time)
    )ENGINE =InnoDB DEFAULT CHARSET =utf8 COMMENT ='秒杀成功明细';
    
    -- 连接数据库控制台
    mysql -u root -p

## 6. 实现Dao层

> ##### 6.1 配置mybatis。在src/main/resources下创建mybatis-config.xml。打开Mybatis官网 http://mybatis.github.io/mybatis-3/zh/index.html，在“入门”中找到Mybatis全局配置文件，拷贝一个xml规范。

    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE configuration
      PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
      "http://mybatis.org/dtd/mybatis-3-config.dtd">
    <!-- 以上来自Mybatis官网 -->
    
    <configuration>
    	<!-- 配置全局属性 -->
    	<settings>
    		<!-- 使用jdbc的getGeneratedKeys 获取数据库自增主键值-->
    		<setting name="useGeneratedKeys" value="true"/>
    		<!-- 使用列别名替换列名 默认true
    		select name as title from table
    		-->
    		<setting name="userColumnLabel" value="true"/>
    		<!-- 开启驼峰命名转换：Table(create_time) ->Entity(createTime) -->
    		<setting name="mapUnderscoreCamelCase" value="true"/>
    	</settings>
    </configuration>

> ##### 6.2 在src/main/java下创建包org.seckill.entity，建立一个Seckill.java实体类

    public class Seckill {
    	private long seckillId;
    	
    	private String name;
    	
    	private int number;
    	
    	private Date startTime;
    	
    	private Date endTime;
    	
    	private Date createTime;
    
    	public long getSeckillId() {
    		return seckillId;
    	}
    
    	public void setSeckillId(long seckillId) {
    		this.seckillId = seckillId;
    	}
    
    	public String getName() {
    		return name;
    	}
    
    	public void setName(String name) {
    		this.name = name;
    	}
    
    	public int getNumber() {
    		return number;
    	}
    
    	public void setNumber(int number) {
    		this.number = number;
    	}
    
    	public Date getStartTime() {
    		return startTime;
    	}
    
    	public void setStartTime(Date startTime) {
    		this.startTime = startTime;
    	}
    
    	public Date getEndTime() {
    		return endTime;
    	}
    
    	public void setEndTime(Date endTime) {
    		this.endTime = endTime;
    	}
    
    	public Date getCreateTime() {
    		return createTime;
    	}
    
    	public void setCreateTime(Date createTime) {
    		this.createTime = createTime;
    	}
    
    	@Override
    	public String toString() {
    		return "Seckill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", startTime=" + startTime
    				+ ", endTime=" + endTime + ", createTime=" + createTime + "]";
    	}
    }

> ##### 和SuccessKilled.java

    public class SuccessKilled {
    	private long secKillId;
    	
    	private long userPhone;
    	
    	private short state;
    	
    	private Date createTime;
    
    	private Seckill seckill;
    	
    	public long getSecKillId() {
    		return secKillId;
    	}
    
    	public void setSecKillId(long secKillId) {
    		this.secKillId = secKillId;
    	}
    
    	public long getUserPhone() {
    		return userPhone;
    	}
    
    	public void setUserPhone(long userPhone) {
    		this.userPhone = userPhone;
    	}
    
    	public short getState() {
    		return state;
    	}
    
    	public void setState(short state) {
    		this.state = state;
    	}
    
    	public Date getCreateTime() {
    		return createTime;
    	}
    
    	public void setCreateTime(Date createTime) {
    		this.createTime = createTime;
    	}
    	
    	
    	public Seckill getSeckill() {
    		return seckill;
    	}
    
    	public void setSeckill(Seckill seckill) {
    		this.seckill = seckill;
    	}
    
    	@Override
    	public String toString() {
    		return "SuccessKilled [secKillId=" + secKillId + ", userPhone=" + userPhone + ", state=" + state
    				+ ", createTime=" + createTime + "]";
    	}
    }

> ##### 6.3 在src/main/java下创建包org.seckill.dao，然后针对实体创建出对应dao层的接口Seckill.java

    public interface SeckillDao {
    	/**
    	 * 减库存
    	 * @param seckillId
    	 * @param killTime
    	 * @return 如果影响行数>1，表示更新的记录行数
    	 */
    	int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);
    	
    	/**
    	 * 根据id查询秒杀对象
    	 * @param seckillId
    	 * @return
    	 */
    	Seckill queryById(long seckillId);
    	
    	/**
    	 * 根据偏移量查询秒杀商品列表
    	 * @param offet
    	 * @param limit
    	 * @return
    	 */
    	List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
    }

> ##### 和接口SuccessKilledDao.java

    public interface SuccessKilledDao {
    	/**
    	 * 插入购买明细，可过滤重复
    	 * @param seckillId
    	 * @param userPhone
    	 * @return 插入的行数
    	 */
    	int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone")  long userPhone);
    	
    	/**
    	 * 根据id查询SuccessKilled并携带秒杀产品对象实体
    	 * @param seckillId
    	 * @return
    	 */
    	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone")  long userPhone);
    }

> ##### 6.4 配置文件创建好后我们需要关注的是Dao接口该如何实现，mybatis为我们提供了mapper动态代理开发的方式为我们自动实现Dao的接口。在mapper包下创建对应Dao接口的xml映射文件，里面用于编写我们操作数据库的sql语句，SeckillDao.xml和SuccessKilledDao.xml。

> ###### 在mybatis官网中，进入"XML配置"。找到映射文件所需要的xml约束。

    <!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

	在src/main/resources下建立文件夹mapper。实现SeckillDao.xml。

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="org.seckill.dao.SeckillDao">
    	<!-- 目的：为DAO接口方法提供sql语句配置 -->
    	
    	<update id="reduceNumber">
    		<!-- 具体sql -->
    		update
    			seckill
    		set
    			number = number - 1
    		where seckill_id = #{seckillId}
    		and start_time <![CDATA[ <= ]]> #{killTime}
    		and end_time >= #{killTime}
    		and number > 0;
    	</update>
    	
    	<select id="queryById" resultType="Seckill" parameterType="long">
    		select seckill_id,name,number,start_time,end_time,create_time
    		from seckill
    		where seckill_id = #{seckillId}
    	</select>
    	
    	<select id="queryAll" resultType="Seckill">
    		select seckill_id,name,number,start_time,end_time,create_time
    		from seckill
    		order by create_time desc
    		limit #{offset},#{limit}
    	</select>
    </mapper>

> ###### 实现SuccessKilledDao.xml。

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="org.seckill.dao.SuccessKilledDao">
    	<insert id="insertSuccessKilled">
    		<!-- 主键冲突，报错。ingnored的作用就是避免主键冲突报错，如果主键存在不插入，如果主键不存在，则插入 -->
    		insert ignore into success_killed(seckill_id,user_phone,state)
    		values (#{seckillId},#{userPhone},0)
    	</insert>
    	
    	<select id="queryByIdWithSeckill" resultType="SuccessKilled">
            <!--根据seckillId查询SuccessKilled对象，并携带Seckill对象-->
            <!--如何告诉mybatis把结果映射到SuccessKill属性同时映射到Seckill属性-->
            <!--可以自由控制SQL语句-->
            SELECT
                sk.seckill_id,
                sk.user_phone,
                sk.create_time,
                sk.state,
                s.seckill_id "seckill.seckill_id",
                s.name "seckill.name",
                s.number "seckill",
                s.start_time "seckill.start_time",
                s.end_time "seckill.end_time",
                s.create_time "seckill.create_time"
            FROM success_killed sk
            INNER JOIN seckill s ON sk.seckill_id=s.seckill_id
            WHERE sk.seckill_id=#{seckillId}
            AND sk.user_phone=#{userPhone}
        </select>
    </mapper>

> ##### 6.5 MyBatis和Spring的整合，整合目标:1.更少的编码:只写接口，不写实现类。2.更少的配置:别名、配置扫描映射xml文件、dao实现。3.足够的灵活性:自由定制SQL语句、自由传结果集自动赋值。

> ##### 在src/main/resources下建立文件夹spring。在spring包下创建一个spring配置dao层对象的配置文件spring-dao.xml，加入上述dtd约束。（相关约束在http://docs.spring.io/spring/docs/中找）

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context 
            	http://www.springframework.org/schema/context/spring-context.xsd">
    <!--以上是dtd约束-->
            	
            	<!-- 配置整合mybatis过程 -->
            	<!-- 1:配置数据库相关参数propertie的属性：${url} -->
            	<context:property-placeholder location="classpath:jdbc.properties"/>
            	 <!--2.数据库连接池-->
    	    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
    	        <!--配置连接池属性-->
    	        <property name="driverClass" value="${driver}" />
    	
    	        <!-- 基本属性 url、user、password -->
    	        <property name="jdbcUrl" value="${url}" />
    	        <property name="user" value="${username}" />
    	        <property name="password" value="${password}" />
    	
    	        <!--c3p0私有属性-->
    	        <property name="maxPoolSize" value="30"/>
    	        <property name="minPoolSize" value="10"/>
    	        <!--关闭连接后不自动commit-->
    	        <property name="autoCommitOnClose" value="false"/>
    	
    	        <!--获取连接超时时间-->
    	        <property name="checkoutTimeout" value="1000"/>
    	        <!--当获取连接失败重试次数-->
    	        <property name="acquireRetryAttempts" value="2"/>
    	    </bean>
    	
    	    <!--约定大于配置-->
           	<!-- 3:配置SqlSessionFactory对象 -->
           	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
           		<!-- 注入数据库连接池 -->
           		<property name="dataSource" ref="dataSource"/>
           		<!-- 配置MyBatis全局配置文件：mybatis-config.xml -->
           		<property name="configLocation" value="classpath:mybatis-config.xml"/>
           		<!-- 扫描entity包 使用别名 -->
           		<property name="typeAliasesPackage" value="org.seckill.entity"/>
           		<!-- 扫描sql配置文件：mapper需要的xml文件 -->
           		<property name="mapperLocations" value="classpath:mapper/*.xml"></property>
           	</bean>
           	
           	<!-- 4：配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中 -->
           	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
           		<!-- 注入sqlSessionFactory -->
           		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
           		<!-- 给出需要扫描Dao接口包 -->
           		<property name="basePackage" value="org.seckill.dao"/>
           	</bean>
    </beans>

> ##### 6.6 在src/main/resources下创建jdbc.properties用于配置数据库的连接信息。

    driver=com.mysql.jdbc.Driver
    url=jdbc:mysql://localhost:3306/seckill?useUnicode=true&characterEncoding=utf-8
    username=root
    password=root

## 7. 利用junit对Dao层编码进行测试（eclipse版）

> ##### 7.1 将JUnit4单元测试包引入这个项目。“项目”上点击右键—>“properties”—>“java Build Path”—>“Libraries”—>“Add Library”—>选择“JUnit 4”。

> ##### 7.2 生成JUnit测试框架。在需要测试类中选择“New JUnit Test Case ”—点击next，选择需要测试的方法。

> ##### 7.3 实现相关测试函数。（本例是对src/main/java/org/seckill/dao下的SeckillDao.java接口和SuccessKilledDao.java接口进行测试）

> ###### 实现SeckillDao.java的测试代码。

    /**
     * 配置spring和junit整合，junit启动时加载springIOC容器
     * spring-test，junit
     */
    @RunWith(SpringJUnit4ClassRunner.class)
    //告诉junit spring配置文件
    @ContextConfiguration({"classpath:spring/spring-dao.xml"})
    public class SeckillDaoTest {
    
    	//注入Dao实现类依赖
    	@Resource
    	private SeckillDao seckillDao;
    	
    	@Test
        public void reduceNumber() throws Exception {
    		Date killTime = new Date();
    		int updateCount = seckillDao.reduceNumber(1000L, killTime);
    		System.out.println("updateCount = " + updateCount);
        }
    
        @Test
        public void queryById() throws Exception {
        		long id = 1000;
        		Seckill seckill = seckillDao.queryById(id);
        		System.out.println(seckill.getName());
        		System.out.println(seckill);
        }
    
        @Test
        public void queryAll() throws Exception {
        		List<Seckill> seckills = seckillDao.queryAll(0, 100);
        		for(Seckill seckill :seckills) {
        			System.out.println(seckill);
        		}
        }
    }

> ###### 实现SuccessKilledDao.java的测试代码。

    @RunWith(SpringJUnit4ClassRunner.class)
    //告诉junit spring配置文件
    @ContextConfiguration({"classpath:spring/spring-dao.xml"})
    public class SuccessKilledDaoTest {
    
    	@Resource
    	private SuccessKilledDao successkilledDao;
    	
    	@Test
        public void insertSuccessKilled() throws Exception 	{
    		long id = 1001L;
    		long phone = 18806529292L;
    		int insertCount = successkilledDao.insertSuccessKilled(id, phone);
    		System.out.println("insertCount = " + insertCount);
        }
    
        @Test
        public void queryByIdWithSeckill() throws Exception 	{
        	long id = 1001L;
    		long phone = 18806529292L;
    		SuccessKilled successKilled = successkilledDao.queryByIdWithSeckill(id, phone);
    		System.out.println(successKilled);
    		System.out.println(successKilled.getSeckill());
        }
    }

> ###### 右键运行需要测试的方法。

> ###### 注意：java不能够保存行参的记录，java运行时会把List<Seckill> queryAll(int offet, int limit);中的参数变成queryAll(int arg0,int arg1);这样我们就不能实现多个参数的传递。所以需要在SeckillDao接口中修改方法：List<Seckill> queryAll(@Param("offset") int offet, @Param("limit") int limit);

## 8. 秒杀Service接口设计

> ##### 在org.seckill包下创建一个service包（org.seckill.service）用于存放我们的Service接口和其实现类，创建一个exception包（org.seckill.exception）用于存放service层出现的异常例如重复秒杀商品异常、秒杀已关闭等异常，一个dto包（org.seckill.dto）作为传输层,dto和entity的区别在于:entity用于业务数据的封装，而dto用于完成web和service层的数据传递。

> ##### 8.1 在service包下实现接口SeckillService.java。

    /**
     * 业务接口：站在"使用者"的角度设计接口
     * 三个方面：方法定义粒度，参数，返回类型（return 类型／异常）
     * @author xuqibin
     */
    public interface SeckillService {
    	
    	/**
    	 * 查询所有秒杀记录
    	 * @return
    	 */
    	List<Seckill> getSeckillList();
    	
    	/**
    	 * 查询单个秒杀记录
    	 * @param seckillId
    	 * @return
    	 */
    	Seckill getById(long seckillId);
    	
    	/**
    	 * 秒杀开启时输出秒杀地址，
    	 * 否则输出系统时间和秒杀时间
    	 * @param seckillId
    	 * @return
    	 */
    	Exposer exportSeckillUrl(long seckillId);
    	
    	/**
    	 * 执行秒杀操作
    	 * @param seckillId
    	 * @param userPhone
    	 * @param md5
    	 */
    	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
    		throws SeckillException,RepeatKillException,SeckillCloseException;
    }

> ###### 该接口中前面两个方法返回的都是跟我们业务相关的对象，而后两个方法返回的对象与业务不相关，这两个对象我们用于封装service和web层传递的数据，方法的作用我们已在注释中给出。

> ##### 8.2 相应在的dto包中创建Exposer.java，用于封装秒杀的地址信息，各个属性的作用在代码中已给出注释，代码如下:

    /**
     * 暴露秒杀地址DTO
     * @author xuqibin
     */
    public class Exposer {
    	//是否开启秒杀
    	private boolean exposed;
    	
    	//一种加密措施
    	private String md5;
    	
    	//id
    	private long seckillId;
    	
    	//系统当前时间（毫秒）
    	private long now;
    	
    	private long start;
    	
    	private long end;
    	
    	//Generate Constructor using Fields
    	public Exposer(boolean exposed, String md5, long seckillId) {
    		super();
    		this.exposed = exposed;
    		this.md5 = md5;
    		this.seckillId = seckillId;
    	}
    
    	public Exposer(boolean exposed, long seckillId, long now, long start, long end) {
    		super();
    		this.exposed = exposed;
    		this.seckillId = seckillId;
    		this.now = now;
    		this.start = start;
    		this.end = end;
    	}
    
    	public Exposer(boolean exposed, long seckillId) {
    		super();
    		this.exposed = exposed;
    		this.seckillId = seckillId;
    	}
    
    	public boolean isExposed() {
    		return exposed;
    	}
    
    	public void setExposed(boolean exposed) {
    		this.exposed = exposed;
    	}
    
    	public String getMd5() {
    		return md5;
    	}
    
    	public void setMd5(String md5) {
    		this.md5 = md5;
    	}
    
    	public long getSeckillId() {
    		return seckillId;
    	}
    
    	public void setSeckillId(long seckillId) {
    		this.seckillId = seckillId;
    	}
    
    	public long getNow() {
    		return now;
    	}
    
    	public void setNow(long now) {
    		this.now = now;
    	}
    
    	public long getStart() {
    		return start;
    	}
    
    	public void setStart(long start) {
    		this.start = start;
    	}
    
    	public long getEnd() {
    		return end;
    	}
    
    	public void setEnd(long end) {
    		this.end = end;
    	}
    
    	@Override
    	public String toString() {
    		return "Exposer [exposed=" + exposed + ", md5=" + md5 + ", seckillId=" + seckillId + ", now=" + now + ", start="
    				+ start + ", end=" + end + "]";
    	}	
    }

> ###### 和SeckillExecution.java，用于判断秒杀是否成功，成功就返回秒杀成功的所有信息(包括秒杀的商品id、秒杀成功状态、成功信息、用户明细)，失败就抛出一个我们允许的异常(重复秒杀异常、秒杀结束异常),代码如下:

    /**
     * 封装秒杀执行后结果
     * @author xuqibin
     */
    public class SeckillExecution {
    	
    	private long seckillId;
    	
    	//秒杀执行结果状态
    	private int state;
    	
    	//状态表示
    	private String stateInfo;
    	
    	//秒杀成功对象
    	private SuccessKilled successKilled;
    
    	public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
    		super();
    		this.seckillId = seckillId;
    		this.state = statEnum.getState();
    		this.stateInfo = statEnum.getStateInfo();
    		this.successKilled = successKilled;
    	}
    
    	public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
    		super();
    		this.seckillId = seckillId;
    		this.state = statEnum.getState();
    		this.stateInfo = statEnum.getStateInfo();
    	}
    
    	public long getSeckillId() {
    		return seckillId;
    	}
    
    	public void setSeckillId(long seckillId) {
    		this.seckillId = seckillId;
    	}
    
    	public int getState() {
    		return state;
    	}
    
    	public void setState(int state) {
    		this.state = state;
    	}
    
    	public String getStateInfo() {
    		return stateInfo;
    	}
    
    	public void setStateInfo(String stateInfo) {
    		this.stateInfo = stateInfo;
    	}
    
    	public SuccessKilled getSuccessKilled() {
    		return successKilled;
    	}
    
    	public void setSuccessKilled(SuccessKilled successKilled) {
    		this.successKilled = successKilled;
    	}
    
    	@Override
    	public String toString() {
    		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state + ", stateInfo=" + stateInfo
    				+ ", successKilled=" + successKilled + "]";
    	}
    }

> ##### 8.3 然后我们需要在org.seckill.exception中创建秒杀业务过程中允许的异常，重复秒杀异常RepeatKillException.java:

    /**
     * 重复秒杀异常（运行期异常）
     * @author xuqibin
     */
    public class RepeatKillException extends SeckillException {
    	
    	public RepeatKillException(String message) {
    		super(message);
    		// TODO Auto-generated constructor stub
    	}
    
    	public RepeatKillException(String message, Throwable cause) {
    		super(message, cause);
    		// TODO Auto-generated constructor stub
    	}
    }
> ###### 秒杀关闭异常SeckillCloseException.java:

    /**
     * 秒杀关闭异常
     * @author xuqibin
     */
    public class SeckillCloseException extends SeckillException {
    
    	public SeckillCloseException(String message, Throwable cause) {
    		super(message, cause);
    		// TODO Auto-generated constructor stub
    	}
    
    	public SeckillCloseException(String message) {
    		super(message);
    		// TODO Auto-generated constructor stub
    	}
    }

> ###### 和一个异常包含与秒杀业务所有出现的异常SeckillException.java:

    public class SeckillException extends RuntimeException{
    
    	public SeckillException(String message, Throwable cause) {
    		super(message, cause);
    		// TODO Auto-generated constructor stub
    	}
    
    	public SeckillException(String message) {
    		super(message);
    		// TODO Auto-generated constructor stub
    	}
    }

> ###### 到此，接口的工作便完成，接下来进行接口实现类的编码工作。

> ##### 8.4 秒杀Service接口的实现

> ###### 在service包下创建impl包存放它的实现类，SeckillServiceImpl.java，内容如下:

    //@Component @Service @Dao @Controller
    @Service
    public class SeckillServiceImpl implements SeckillService{
    
    	private Logger logger = LoggerFactory.getLogger(this.getClass());
    	
    	//注入Service依赖
    	@Autowired
    	private SeckillDao seckillDao;
    	
    	@Autowired
    	private SuccessKilledDao successKilledDao;
    	
    	//md5盐值字符串，用于混淆MD5
    	private final String slat = "fg4tgsfgsg4gasdsgrf4qgdjgl[jjfhjhg";
    	
    	@Override
    	public List<Seckill> getSeckillList() {
    		return seckillDao.queryAll(0, 4);
    	}
    
    	@Override
    	public Seckill getById(long seckillId) {
    		return seckillDao.queryById(seckillId);
    	}
    
    	@Override
    	public Exposer exportSeckillUrl(long seckillId) {
    		Seckill seckill = seckillDao.queryById(seckillId);
    		if (seckill == null) {
    			return new Exposer(false, seckillId);
    		}
    
    		Date startTime = seckill.getStartTime();
    		Date endTime = seckill.getEndTime();
    		// 系统当前时间
    		Date nowTime = new Date();
    		if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
    			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
    		}
    		//转化特定字符串的过程，不可逆
    		String md5 = getMD5(seckillId);
    		return new Exposer(true, md5, seckillId);
    	}
    
    	private String getMD5(long seckillId) {
    		String base = seckillId + "/" + slat;
    		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
    		return md5;
    	}
    	
    	@Override
    	@Transactional
    	/**
    	 * 使用注解控制事务方法的优点：
    	 * 1:开发团队达成一致的约定，明确标注事务方法的编程风格。
    	 * 2:保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC／HTTP请求或者 剥离到事务方法外
    	 * 3:不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
    	 */
    	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
    			throws SeckillException, RepeatKillException, SeckillCloseException {
    		if (md5 == null || !md5.equals(getMD5(seckillId))) {
    			throw new SeckillException("seckill data rewrite");
    		}
    		//执行秒杀逻辑：减库存 + 记录购买行为
    		Date nowTime = new Date();
    		
    		try {
    			// 减库存
    			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
    			if (updateCount <= 0) {
    				// 没有更新到记录，秒杀结束
    				throw new SeckillCloseException("seckill is closed");
    			} else {
    				// 记录购买行为
    				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
    				// 唯一：seckillId, userPhone
    				if (insertCount <= 0) {
    					throw new RepeatKillException("seckill repeated");
    				} else {
    					// 秒杀成功
    					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
    					return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
    				}
    			}
    		} catch (SeckillCloseException e1) {
    			throw e1;
    		} catch (RepeatKillException e2) {
    			throw e2;
    		} catch (Exception e) {
    			logger.error(e.getMessage(), e);
    			// 所有编译期异常转化为运行期异常
    			throw new SeckillException("seckill inner error:" + e.getMessage());
    		}
    	}
    }

> ###### 对上述代码进行分析一下，在return new SeckillExecution(seckillId,1,"秒杀成功",successKilled);代码中，我们返回的state和stateInfo参数信息应该是输出给前端的，但是我们不想在我们的return代码中硬编码这两个参数，所以我们应该考虑用枚举的方式将这些常量封装起来，在org.seckill包下新建一个枚举包enums，创建一个枚举类型SeckillStatEnum.java，内容如下:

    /**
     * 使用枚举表述常量数据字段
     * @author xuqibin
     */
    public enum SeckillStatEnum {
    	SUCCESS(1,"秒杀成功"),
    	END(0,"秒杀结束"),
    	REPEAT_KILL(-1,"重复秒杀"),
    	INNER_ERROR(-2,"系统异常"),
    	DATA_REWRITE(-3,"数据篡改");
    	
    	private int state;
    	
    	private String stateInfo;
    
    	private SeckillStatEnum(int state, String stateInfo) {
    		this.state = state;
    		this.stateInfo = stateInfo;
    	}
    
    	public int getState() {
    		return state;
    	}
    
    	public String getStateInfo() {
    		return stateInfo;
    	}
    	
    	public static SeckillStatEnum stateOf(int index) {
    		for(SeckillStatEnum state:values()) {
    			if(state.getState() == index) {
    				return state;
    			}
    		}
    		return null;
    	}
    }

> ##### 8.5 使用Spring托管Service依赖配置

> ###### 在spring包下创建一个spring-service.xml文件，内容如下:

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
    
    	<!-- 扫描service包下所有使用注解的类型 -->
    	<context:component-scan base-package="org.seckill.service"/>
    	
    	<!-- 配置事务管理器 -->
    	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    		<!-- 注入数据库连接池 -->
    		<property name="dataSource"  ref="dataSource"></property>
    	</bean>
    </beans>

> ###### 然后采用注解的方式将Service的实现类加入到Spring IOC容器中:

    //@Component @Service @Dao @Controller
    @Service
    public class SeckillServiceImpl implements SeckillService

> ###### 下面我们来运用Spring的声明式事务对我们项目中的事务进行管理。

> ##### 8.6 使用Spring声明式事务配置

> ###### 声明式事务的使用方式:1.早期使用的方式:ProxyFactoryBean+XMl.2.tx:advice+aop命名空间，这种配置的好处就是一次配置永久生效。3.注解@Transactional的方式。在实际开发中，建议使用第三种对我们的事务进行控制，优点见下面代码中的注释。下面让我们来配置声明式事务，在spring-service.xml中添加对事务的配置:

    	<!-- 配置基于注解的声明式事务默认使用注解来管理事务行为 -->
    	 <tx:annotation-driven transaction-manager="transactionManager"/>

> ###### 然后在Service实现类的方法中，在需要进行事务说明的方法上加上事务的注解：

    @Transactional
    	/**
    	 * 使用注解控制事务方法的优点：
    	 * 1:开发团队达成一致的约定，明确标注事务方法的编程风格。
    	 * 2:保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC／HTTP请求或者 剥离到事务方法外
    	 * 3:不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
    	 */
    	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)

> ###### 下面给出spring-service.xml完整的代码。

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
    
    	<!-- 扫描service包下所有使用注解的类型 -->
    	<context:component-scan base-package="org.seckill.service"/>
    	
    	<!-- 配置事务管理器 -->
    	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    		<!-- 注入数据库连接池 -->
    		<property name="dataSource"  ref="dataSource"></property>
    	</bean>
    	
    	<!-- 配置基于注解的声明式事务
    		默认使用注解来管理事务行为
    	 -->
    	 <tx:annotation-driven transaction-manager="transactionManager"/>
    </beans>

## 9. 使用集成测试Service逻辑

	对org.seckill.service包下的SeckillService进行单元测试。

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration({
    	"classpath:spring/spring-dao.xml",
    	"classpath:spring/spring-service.xml"})
    public class SeckillServiceTest {
    	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    	
    	@Autowired
    	private SeckillService seckillService;
    	
    	@Test
    	public void testGetSeckillList() throws Exception {
    		List<Seckill> list = seckillService.getSeckillList();
    		logger.info("list={ }", list);
    	}
    
    	@Test
    	public void testGetById() throws Exception {
    		long id = 1000;
    		Seckill seckill = seckillService.getById(id);
    		logger.info("seckill={}", seckill);
    	}
    	/*
    	@Test
    	public void testExportSeckillUrl() throws Exception {
    		long id = 1000;
    		Exposer exposer = seckillService.exportSeckillUrl(id);
    		logger.info("exposer={}",exposer);
    	}
    
    	@Test
    	public void testExecuteSeckill() throws Exception {
    		long id = 1000;
    		long phone = 18806529292L;
    		String md5 = "0fab3da527c0249cfc72a6e0141bdfd5";
    		try {
    			SeckillExecution exception = seckillService.executeSeckill(id, phone, md5);
    			logger.info("result={}",exception);
    		} catch (RepeatKillException e) {
    			logger.error(e.getMessage());
    		}catch (SeckillCloseException e) {
    			logger.error(e.getMessage());
    		}
    	}
    	 */
    	//测试代码完整逻辑，注意可重复执行
    	@Test
    	public void testSeckillLogic() throws Exception {
    		long id = 1001;
    		Exposer exposer = seckillService.exportSeckillUrl(id);
    		if(exposer.isExposed()) {
    			String md5 = exposer.getMd5();
    			long phone = 18806529292L;
    			try {
    				SeckillExecution exception = seckillService.executeSeckill(id, phone, md5);
    				logger.info("result={}",exception);
    			} catch (RepeatKillException e) {
    				logger.error(e.getMessage());
    			}catch (SeckillCloseException e) {
    				logger.error(e.getMessage());
    			}
    		} else {
    			//秒杀未开启
    			logger.warn("exposer={}", exposer);
    		}
    	}
    }

## 10. 整合配置Spring MVC框架

> ##### 10.1 首先在WEB-INF的web.xml中进行我们前端控制器DispatcherServlet的配置，如下:

    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                          http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
      version="3.1"
      metadata-complete="true">
      
    <!--用maven创建的web-app需要修改servlet的版本为3.1-->
    <!--配置DispatcherServlet-->
        <servlet>
            <servlet-name>seckill-dispatcher</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <!--
                配置SpringMVC 需要配置的文件
                spring-dao.xml，spring-service.xml,spring-web.xml
                Mybites -> spring -> springMvc
            -->
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:spring/spring-*.xml</param-value>
            </init-param>
        </servlet>
        <servlet-mapping>
            <servlet-name>seckill-dispatcher</servlet-name>
            <!--默认匹配所有请求-->
            <url-pattern>/</url-pattern>
        </servlet-mapping>
    </web-app>

> ##### 10.2 然后在spring容器中进行web层相关bean(即Controller)的配置，在spring包下创建一个spring-web.xml，内容如下:

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xmlns:mvc="http://www.springframework.org/schema/mvc"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context 
            http://www.springframework.org/schema/context/spring-context.xsd
            http://www.springframework.org/schema/mvc 
            http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    
        <!--配置spring mvc-->
        <!--1,开启springmvc注解模式
        a.自动注册DefaultAnnotationHandlerMapping,AnnotationMethodHandlerAdapter
        b.默认提供一系列的功能:数据绑定，数字和日期的format@NumberFormat,@DateTimeFormat
        c:xml,json的默认读写支持-->
        <mvc:annotation-driven/>
    
        <!--2.静态资源默认servlet配置-->
        <!--
            1).加入对静态资源处理：js,gif,png
            2).允许使用 "/" 做整体映射
        -->
        <mvc:default-servlet-handler/>
    
        <!--3：配置JSP 显示ViewResolver-->
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
            <property name="prefix" value="/WEB-INF/jsp/"/>
            <property name="suffix" value=".jsp"/>
        </bean>
    
        <!--4:扫描web相关的bean-->
        <context:component-scan base-package="org.seckill.web"/>
    </beans>

> ##### 这样我们便完成了Spring MVC的相关配置(即将Spring MVC框架整合到了我们的项目中)，接下来就要基于Restful接口进行我们项目的Controller开发工作了。

## 11. Controller开发

> ##### 11.1 Controller中的每一个方法都对应我们系统中的一个资源URL，其设计应该遵循Restful接口的设计风格。在org.seckill包下创建一个web包用于放web层Controller开发的代码，在该包下创建一个SeckillController.java，内容如下:

    @Controller
    @RequestMapping("/seckill") // url:/模块/资源/{}/细分 /seckill/list
    public class SeckillController {
    
    	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    	@Autowired
    	private SeckillService seckillService;
    
    	@RequestMapping(value = "/list", method = RequestMethod.GET)
    	public String list(Model model) {
    
    		// 获取列表页
    		List<Seckill> list = seckillService.getSeckillList();
    		model.addAttribute("list", list);
    
    		// list.jsp+model = ModelAndView
    
    		return "list"; // ==> /WEB-INF/jsp/list.jsp
    	}
    
    	@RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    	public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
    
    		if (seckillId == null) {
    			return "redirect:/seckill/list";
    		}
    
    		Seckill seckill = seckillService.getById(seckillId);
    		if (seckill == null) {
    			return "forward:/seckill/list";
    		}
    		model.addAttribute("seckill", seckill);
    
    		return "detail";
    	}
    
    	@RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {
    			"application/json;charset=UTF-8" })
    	@ResponseBody
    	public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
    		SeckillResult<Exposer> result;
    		try {
    			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
    			result = new SeckillResult<Exposer>(true, exposer);
    		} catch (Exception e) {
    			logger.error(e.getMessage(), e);
    			result = new SeckillResult<Exposer>(false, e.getMessage());
    		}
    
    		return result;
    	}
    
    	@RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST, produces = {
    			"application/json;charset=UTF-8" })
    	@ResponseBody
    	public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
    			@PathVariable("md5") String md5, @CookieValue(value = "killPhone", required = false) Long phone) {
    		if (phone == null) {
    
    			return new SeckillResult<SeckillExecution>(false, "未注册");
    
    		}
    		SeckillResult<SeckillExecution> result;
    		try {
    			// 修改为存储过程调用
    			 SeckillExecution execution = seckillService.executeSeckill(seckillId, phone, md5);
    
    			return new SeckillResult<SeckillExecution>(true, execution);
    		} catch (RepeatKillException e1) {
    			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
    			return new SeckillResult<SeckillExecution>(true, execution);
    		} catch (SeckillCloseException e2) {
    			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
    			return new SeckillResult<SeckillExecution>(true, execution);
    		} catch (Exception e) {
    			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
    			return new SeckillResult<SeckillExecution>(true, execution);
    		}
    
    	}
    
    	// 获取系统时间
    	@RequestMapping(value = "/time/now",method = RequestMethod.GET)
        @ResponseBody
        public SeckillResult<Long> time(){
        	
            Date now=new Date();
            return new SeckillResult<Long>(true,now.getTime());
            
        }
    }

> ##### 11.2 Controller开发中的方法完全是对照Service接口方法进行开发的，第一个方法用于访问我们商品的列表页，第二个方法访问商品的详情页，第三个方法用于返回一个json数据，数据中封装了我们商品的秒杀地址，第四个方法用于封装用户是否秒杀成功的信息，第五个方法用于返回系统当前时间。代码中涉及到一个将返回秒杀商品地址封装为json数据的一个Vo类，即SeckillResult.java，在dto包中创建它，内容如下:

    //将所有的ajax请求返回类型，全部封装成json数据
    public class SeckillResult<T> {
    
      private boolean success;
      private T data;
      private String error;
    
      public SeckillResult(boolean success, T data) {
          this.success = success;
          this.data = data;
      }
    
      public SeckillResult(boolean success, String error) {
          this.success = success;
          this.error = error;
      }
    
      public boolean isSuccess() {
          return success;
      }
    
      public void setSuccess(boolean success) {
          this.success = success;
      }
    
      public T getData() {
          return data;
      }
    
      public void setData(T data) {
          this.data = data;
      }
    
      public String getError() {
          return error;
      }
    
      public void setError(String error) {
          this.error = error;
      }
    }

> ###### 到此，Controller的开发任务完成，接下来进行我们的页面开发。

## 12. 前端开发

> ##### 12.1 在webapp下创建sesources文件夹，sesources下创建script文件夹，在script下写seckill.js，如下所示：

    /**
     * 存放主要交互逻辑js代码
     * javascript 模块化
     * seckill.detail.init{(params)}
     */
    
    var seckill={
    	//封装秒杀相关ajax的url
    	URL:{
    		now :function(){
    			return '/seckill/seckill/time/now';
    		},
    		
    		exposer:function(seckillId){
    			console.log(seckillId);
    			return '/seckill/seckill/'+seckillId +'/exposer';
    		},
    		execution: function (seckillId, md5) {
    			console.log(seckillId);
                return '/seckill/seckill/' + seckillId + '/' + md5 + '/execution';
            }
    	},
    	
    	//验证手机号
    	vaildatePhone:function(phone){
    		if(phone && phone.length==11 && !isNaN(phone)){
    			return true;
    		}else{
    			return false;
    		}
    	},
    	
        countDown: function (seckillId, nowTime, startTime, endTime){
        	console.log(seckillId + '_' + nowTime + '_' + startTime + '_' + endTime);
        	var seckillBox = $('#seckill-box');
        	if(nowTime>endTime){
        		//秒杀结束
                seckillBox.html('秒杀结束!');
        	}else if (nowTime < startTime) {
                //秒杀未开始,计时事件绑定
                var killTime = new Date(startTime + 1000);//todo 防止时间偏移
                seckillBox.countdown(killTime, function (event) {
                //时间格式
                var format = event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒 ');
                seckillBox.html(format);
                }).on('finish.countdown', function () {
                    //时间完成后回调事件
                    //获取秒杀地址,控制现实逻辑,执行秒杀
                	console.log(seckillId);
                    seckill.handlerSeckill(seckillId, seckillBox);
                });
            } else {
                //秒杀开始
                seckill.handlerSeckill(seckillId, seckillBox);
            }
        },
        
        //获取秒杀地址,控制现实逻辑,执行秒杀
        handlerSeckill:function(seckillId,node){
        	node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
        	console.log(seckillId);
        	$.post(seckill.URL.exposer(seckillId),{},function(result){
        		console.log(seckillId);
        		//在回掉函数中执行交互逻辑
        		if (result && result['success']){
        			var exposer = result['data'];
        			//开启秒杀
        			if (exposer['exposed']){
        				//获取秒杀地址
                        var md5 = exposer['md5'];
                        var killUrl = seckill.URL.execution(seckillId, md5);
                        console.log("killUrl: " + killUrl);
                        //绑定一次点击事件
                        $('#killBtn').one('click', function () {
                            //执行秒杀请求
                            //1.先禁用按钮
                            $(this).addClass('disabled');//,<-$(this)===('#killBtn')->
                            //2.发送秒杀请求执行秒杀
                            $.post(killUrl, {}, function (result) {
                                if (result && result['success']) {
                                    var killResult = result['data'];
                                    var state = killResult['state'];
                                    var stateInfo = killResult['stateInfo'];
                                    //显示秒杀结果
                                    node.html('<span class="label label-success">' + stateInfo + '</span>');
                                }
                            });
                        });
                        node.show();
                                           
        			}else{
        				//未开启秒杀(浏览器计时偏差)
                        var now = exposer['now'];
                        var start = exposer['start'];
                        var end = exposer['end'];
                        console.log(seckillId);
                        seckill.countDown(seckillId, now, start, end);
        			}
        		}else{
        			 console.log('result: ' + result);
        		}
        	});
        },
    	
    	//详情页秒杀逻辑
    	detail:{
    		//详情页初始化
    		init:function(params){
    			//用户手机验证和登陆,计时交互
    			//规划交互流程
    			//在cookie中查找手机号
    			var killPhone=$.cookie('killPhone');			
    			var startTime = params['startTime'];
    	        var endTime = params['endTime'];
    	        var seckillId = params['seckillId'];
    	        
    	        //验证手机
    	        if(!seckill.vaildatePhone(killPhone)){
    	        	//绑定手机
    	        	//控制输出
    	        	var killPhoneModal=$('#killPhoneModal');
    	        	killPhoneModal.modal({
    	        		//显示弹出层
    	        		show :true,
    	        		//禁止位置关闭
    	        		backdrop:'static',
    	        		//关闭键盘事件
    	        		keyboard:false
    	        	});
    	        	$('#killPhoneBtn').click(function(){
    	        		var inputPhone=$('#killPhoneKey').val();
    	        		if(seckill.vaildatePhone(inputPhone)){
    	        			//电话写入cookie(7天过期)
                            $.cookie('killPhone', inputPhone, {expires: 7, path: '/seckill'});
    	        			//刷新页面
    	        			window.location.reload();
    	        		}else{
    	        			//todo 错误文案信息抽取到前端字典里
                            $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
    	        		}
    	        	});
    	        }
    	        
    	        //已经登陆 计时交互
    	        $.get(seckill.URL.now(),{},function(result){
    	        	if(result && result['success']){
    	        		var nowTime = result['data'];
    	        		console.log(seckillId);
                        //时间判断 计时交互
                        seckill.countDown(seckillId, nowTime, startTime, endTime);
                        
    	        	}else{
    	        		alert('result: ' + result);
    	        	}
    	        });
    		}
    	}
    }

> ##### 12.2 在webapp/WEB-INF下创建jsp文件夹，用来存放jsp文件。list.jsp内容如下所示：

    <%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
    <%@ page contentType="text/html;charset=UTF-8" language="java"%>
    <%@include file="common/tag.jsp"%>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>秒杀列表页面</title>
    	<%@include file="common/head.jsp"%>
    </head>
    <body>
    	<!-- 页面显示部分 -->
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h2>秒杀列表</h2>
            </div>
            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>库存</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>创建时间</th>
                        <th>详情页</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="sk">
                        <tr>
                            <td>${sk.name}</td>
                            <td>${sk.number}</td>
                            <td>
                                <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                            <td>
                                <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                            <td>
                                <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                            <td><a class="btn btn-info" href="/seckill/seckill/${sk.seckillId}/detail" target="_blank">详情</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
    
            </div>
        </div>
    </div>
    </body>
    
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
    </html>

> ###### 和detail.jsp如下所示：

    <%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
    <%@ page contentType="text/html;charset=UTF-8" language="java"%>
    <%@include file="common/tag.jsp"%>
    <!DOCTYPE html>
    <html>
    <head>
    
    	<title>秒杀详情页面</title>
    	<%@include file="common/head.jsp" %>
    </head>
    <body>
    <div class="container">
    	<div class="panel panel-default text-center">
    		<div class="pannel-heading">
    			<h1>${seckill.name}</h1>
    		</div>
    
    		<div class="panel-body">
    			<h2 class="text-danger">
    				<%--显示time图标--%>
    				<span class="glyphicon glyphicon-time"></span>
    				<%--展示倒计时--%>
    				<span class="glyphicon" id="seckill-box"></span>
    			</h2>			
    		</div>
    	</div>
    </div>
    
    <%--登录弹出层 输入电话--%>
    <div id="killPhoneModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title text-center">
                        <span class="glyphicon glyphicon-phone"> </span>秒杀电话:
                    </h3>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-8 col-xs-offset-2">
                            <input type="text" name="killPhone" id="killPhoneKey" placeholder="填写手机号^o^" class="form-control">
                        </div>
                    </div>
                </div>
    
                <div class="modal-footer">
                    <%--验证信息--%>
                    <span id="killPhoneMessage" class="glyphicon"> </span>
                    <button type="button" id="killPhoneBtn" class="btn btn-success">
                        <span class="glyphicon glyphicon-phone"></span>
                        Submit
                    </button>
                </div>
            </div>
        </div>
    </div>
    </body>
    
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--jQuery Cookie操作插件--%>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
    <script src="/seckill/resources/script/seckill.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	$(function(){
    		//使用el表达式传入参数
    		seckill.detail.init({
    			seckillId:"${seckill.seckillId}",
    			startTime:"${seckill.startTime.time}",
    			endTime:"${seckill.endTime.time}"
    		});
    	});
    </script>
    </html>

> ##### 12.3 上面两jsp文件需要的公共部分可以放在webapp/WEB-INF/jsp下新建的common文件夹中。分别是head.jsp，内容如下所示：

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file:// 引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

> ###### 和tag.jsp，内容如下所示：

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

> ###### 以上，整个开（kao）发（bei）已经完成。
