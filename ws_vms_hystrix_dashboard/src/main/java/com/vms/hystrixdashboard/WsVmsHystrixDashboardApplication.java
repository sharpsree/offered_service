package com.vms.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class WsVmsHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsVmsHystrixDashboardApplication.class, args);
	}

}
