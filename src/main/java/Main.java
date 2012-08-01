import java.io.File;
import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//System.out.println("msin");
		//File f = new File("s");
		//System.out.println(f.getCanonicalPath());
		
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./../../root-context.xml");
        String[] beanNames = context.getBeanDefinitionNames();
        
        for (String s : beanNames){
        	System.out.println(s);
        }
        
	}

}
