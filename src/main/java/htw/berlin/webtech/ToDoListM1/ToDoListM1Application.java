package htw.berlin.webtech.ToDoListM1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ToDoListM1Application {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListM1Application.class, args);
	}

}
