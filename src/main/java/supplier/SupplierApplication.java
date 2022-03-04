package supplier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import supplier.entity.Supplier;
import supplier.util.HibernateUtil;

@SpringBootApplication
@RestController
public class SupplierApplication implements CommandLineRunner {

    //https://www.codejava.net/frameworks/hibernate/getting-started-with-hibernate-annotations

    public static void main(String[] args) {
        SpringApplication.run(SupplierApplication.class, args);
    }

    @GetMapping("/welcome")
    String welcome(){
        return "Api is running";
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
