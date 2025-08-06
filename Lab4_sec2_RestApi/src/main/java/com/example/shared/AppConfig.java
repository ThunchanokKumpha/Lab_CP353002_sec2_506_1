package com.example.shared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.example.shared")//ค้นหาcomponentได้ในpackagesนี้

public class AppConfig {
	@Bean({"company","comp"}) //ตั้งเป็นsetได้ ถ้าไม่ตั้งตรงนี้ก็ใช้ชื่อclass
	@Scope("singleton")
	
	//@Scope("prototype")
	public CompanyInformation companyinformation() {
		return new CompanyInformation();
	}
	
	

}
