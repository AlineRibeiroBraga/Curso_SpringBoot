package br.com.invillia;

import br.com.invillia.domain.Category;
import br.com.invillia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category category1 = new Category(null,"informática");
		Category category2 = new Category(null,"escritório");

		categoryRepository.saveAll(Arrays.asList(category1,category2));
	}
}
