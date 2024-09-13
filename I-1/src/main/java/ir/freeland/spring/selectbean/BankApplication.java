package ir.freeland.spring.selectbean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApplication {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_selectbean.xml");
        SelectbeanApplication selectBeanApp = context.getBean(SelectbeanApplication.class);
        selectBeanApp.reportAccount("136_123");
    }
}
