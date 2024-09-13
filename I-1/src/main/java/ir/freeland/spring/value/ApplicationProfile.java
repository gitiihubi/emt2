package ir.freeland.spring.value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ir.freeland.spring.value.service.BankiranService;


@SpringBootApplication (scanBasePackages = "ir.freeland.spring.value.service")
public class ApplicationProfile {
	
	public static void main(String[] args)  {
		ApplicationContext applicationContext =  SpringApplication.run(ApplicationProfile.class, args);
		var bankiran = applicationContext.getBean(BankiranService.class);
		bankiran.setup();
	
	}
}
