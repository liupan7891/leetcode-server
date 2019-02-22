package cn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import java.util.TimeZone;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SpringApplication.run(Application.class, args);
        
    }

}