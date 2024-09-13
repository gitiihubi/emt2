package ir.freeland.spring.selectbean.service;

import java.io.File;
import org.springframework.stereotype.Component;

@Component("324")
public class BSIBankiranServices implements BankiranServices {

	@Override
	public File accountTransaction(String accountNumber) {
		return new File("account-report");
	}
}
