package ir.freeland.spring.selectbean;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ir.freeland.spring.selectbean.service.BankiranServices;

@Service
public class SelectbeanApplication {
	private final Map<String, BankiranServices> services = new HashMap<>();

	@Autowired
	public SelectbeanApplication(List<BankiranServices> services) {
		services.forEach(service -> this.services
				.put(service.getClass().getAnnotation(Component.class).value(), service));
	}

	public File reportAccount(String account) {
		BankiranServices service = services.get(account);
		if (service == null) {
			throw new UnsupportedOperationException("Unsupported format: " + account);
		}
		System.out.println("Account transaction of " + account + " account is:");
		return service.accountTransaction(account);
	}
}
