package com.example.shared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.example.shared") // ค้นหา component ได้ใน package นี้
public class AppConfig {

    @Bean({"company", "comp"}) // ตั้งชื่อ bean ได้หลายชื่อ
    @Scope("prototype") // เปลี่ยนจาก singleton เป็น prototype
    public CompanyInformation companyinformation() {
        return new CompanyInformation();
    }

}
