package in.nareshit.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.MailTemplate;
import in.nareshit.raghu.service.MailService;
import lombok.Data;
@Data
@Component
public class MailServiceRunner implements CommandLineRunner{
	
	@Autowired
	private MailService service;
	
	@Override
	public void run(String... args) throws Exception {

		Resource resource=new FileSystemResource("Screenshot (110).png");
		
		/*
		 * boolean send = service. send("muneendarkumar17@gmail.com",
		 * "muneendarkumar17@gmail.com", null, "Test Subject"+new Date(), MailTemplate.
		 * getTemplateData("KUMAR", "Rank. Jayrai", " RAJU"), resource);
		 */
	
		boolean send = service.sendEmail("javaraghu2018@gmail.com", "Welcome to MySubject",
		MailTemplate.getTemplateData(
				"SAMUL", "St. Annos", " Phillips ")
		);	
		
		
		if(send)
			System.out.println("Mail is Sent ");
		else System.out.println("Mail is not sent");
	}

}
