package in.nareshit.raghu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MailTemplate {
	
	private static String template =null;
	
	static {
		try {
			FileInputStream fis = new FileInputStream(new File("mailtemplate.txt"));
			byte[] b=new byte[fis.available()];
			fis.read(b);
			template=new String(b);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getTemplate() {
		return template;
	}
	
	public static String getTemplateData(String user,String fn,String ln) {
		String template = getTemplate();
		
		template=template.replace("{{user}}",user)
		.replace("{{firstname}}", fn)
		.replace("{{lastname}}", ln)
		.replace("{{date}}", new java.util.Date().toString());
		return template;
		
	}

}
