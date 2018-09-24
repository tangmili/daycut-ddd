package com.cathay;

import com.cathay.acctdaycut.facade.SofaBootSampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * com.cathay.Slite2SpringBootAPPNAMEApplication
 * <p>
 * Create a non-web application:
 * http://docs.spring.io/spring-boot/docs/1.4.2.RELEASE/reference/htmlsingle/#howto-create-a-non-web-application
 * <p>
 * <p>
 * Created by yangguanchao on 16/12/9.
 */
@ImportResource({"classpath*:META-INF/APPNAME/*.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@ComponentScan(basePackages = {"com.cathay", "zdal"})
@Slf4j
public class Slite2SpringBootAPPNAMEApplication {
    public static void main(String[] args) throws Exception {
        System.out.println(Slite2SpringBootAPPNAMEApplication.class.getResource("/com/cathay"));
        System.out.println(Slite2SpringBootAPPNAMEApplication.class.getResource("config"));
        System.out.println(Slite2SpringBootAPPNAMEApplication.class.getResource("/zdal"));

        SpringApplication springApplication = new SpringApplication(Slite2SpringBootAPPNAMEApplication.class);

        //springApplication.getClass().getClassLoader().getResource()
        //a non-web application
        springApplication.setWebEnvironment(false);
        ApplicationContext applicationContext = springApplication.run(args);
        Environment environment = applicationContext.getEnvironment();

        SofaBootSampleService sampleService = applicationContext.getBean(SofaBootSampleService.class);
        System.out.println("Sample Service Result = " + sampleService.excutemethod("hello"));
        System.out.println("Current Application Context : " + applicationContext);

        DataSource dataSource = (DataSource) applicationContext.getBean("daycutdataSource");
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            log.info("get ZdalDataSource Suceess -------------------------------");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }


    }
}
