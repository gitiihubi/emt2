package ir.freeland.spring.usebean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsebeanApplication {
  public static void main(String[] args) {
    // InternetbankServices internetbankServices = new InternetbankServices();
    ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
    InternetbankServices internetbankServices = context.getBean(InternetbankServices.class);
    internetbankServices.doCardToCard("6274.1211.6623.6810", "6037.9919.1267.1343");
  }
}
