package com.jqpv.admin;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@MapperScan("com.jqpv.admin.mapper")
//@ServletComponentScan("com.jqpv.admin")
@SpringBootApplication
public class BootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWebAdminApplication.class, args);
    }

}
