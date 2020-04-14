package store.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication
public class MStoreApplication extends WebMvcAutoConfiguration{

	public static void main(String[] args) {
		SpringApplication.run(MStoreApplication.class, args);
	}

}
