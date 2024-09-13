package ir.freeland.spring.value.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BankiranService {

	@Value("${bankiran.address}")
	private String address;
	
	@Value("#{'${bankiran.username}'.toUpperCase()}")
	private String username;
	
	
    public void setup() {
        System.out.println("bank iran address is: " + address + " username: " + username );
    }

}
