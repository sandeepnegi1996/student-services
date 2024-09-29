# SpringBoot Project with Integration Tests


### sample log file using logback-spring.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <property name="LOG_ROOT" value="logs" />
    <property name="LOG_FILE_NAME" value="esgapi" />


    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>


    <!--
    The given logback configuration creates daily rolled-over logs with max log size of 10 MB, keeping 30 days worth of history,
    but at most 10 GB of total archived logs. Older logs start getting deleted as soon as the size limit is breached.-->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">

        <file>${LOG_ROOT}/${LOG_FILE_NAME}.log</file>

        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${LOG_ROOT}/${LOG_FILE_NAME}-%d{yyyy-MM-dd}.%i.log.gz</fileNamePattern>
<!--               each archived file's size will be max 10MB -->
            <maxFileSize>1MB</maxFileSize>
<!--          30 days to keep -->
            <maxHistory>30</maxHistory>
<!--         total size of all archive files, if total size > 100GB, it will delete old archived file -->
            <totalSizeCap>100GB</totalSizeCap>
        </rollingPolicy>
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>



    <logger name="com.hashcodehub.springboot.studentservices" level="INFO" additivity="false">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </logger>



</configuration>


```


![img.png](img.png)