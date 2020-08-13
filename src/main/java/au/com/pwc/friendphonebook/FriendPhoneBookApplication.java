package au.com.pwc.friendphonebook;

import au.com.pwc.friendphonebook.processor.Processor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class FriendPhoneBookApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FriendPhoneBookApplication.class, args);
		Processor processor = applicationContext.getBean(Processor.class);
		processor.process();
	}

}
