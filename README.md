Integrate Spring Security with Spring Session Redis 
===============================================

1. Spring 4.0
2. Spring Security 3.2
3. Spring Session Data Redis 1.0


##Setting of spring-security.xml 
``` XML 

    <authentication-manager alias="authenticationManager"
        xmlns="http://www.springframework.org/schema/security">
        <authentication-provider>
            <user-service>
                <user name="admin" password="P@ssw0rd" authorities="ROLE_ADMIN" />
            </user-service>
        </authentication-provider>
    </authentication-manager>


```

##Setting of spring-session.xml 
1.Default Redis have no authentication (Don't need any username/password).

2.If your redis server is in the other server, to remember to allow remote connection (iptable and redis config.)

3.Default port of Redis is 6379.
### Setting of redis connection 
``` XML
    
    <bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig"/>
         <bean id="jedisConnectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory">
            <property name="hostName" value="127.0.0.1" />
            <property name="port" value="6379" />
            <!--<property name="password" value="${redis.password}" />-->
            <!--<property name="timeout" value="${redis.timeout}" />-->
            <property name="poolConfig" ref="jedisPoolConfig" />
            <property name="usePool" value="true" />
    </bean>
    
    <bean id="redisTemplate" class="org.springframework.data.redis.core.StringRedisTemplate">
        <property name="connectionFactory" ref="jedisConnectionFactory" />
    </bean>
```


### Alive Time (Second)
1200 seconds = 20 mins
``` XML

    <bean id="redisHttpSessionConfiguration" class="org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration">
        <property name="maxInactiveIntervalInSeconds" value="1200" />
    </bean>

```


Setting of spring-session.xml 
===============================================
Add Redis Filter into spring-session.xml
``` XML 

     <!-- Spring Session Data Redis Filter -->
    <filter>
        <filter-name>springSessionRepositoryFilter</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>springSessionRepositoryFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
``` 

