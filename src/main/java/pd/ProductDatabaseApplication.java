package pd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (scanBasePackages = "pd")
@EntityScan (basePackages = "pd.entity")
@EnableJpaRepositories(basePackages = "pd.repository")
public class ProductDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDatabaseApplication.class, args);
		System.out.println("spring boot security app up!");
	}

}
