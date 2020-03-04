package br.com.invillia;

import br.com.invillia.domain.Category;
import br.com.invillia.domain.City;
import br.com.invillia.domain.Product;
import br.com.invillia.domain.State;
import br.com.invillia.repository.CategoryRepository;
import br.com.invillia.repository.CityRepository;
import br.com.invillia.repository.ProductRepository;
import br.com.invillia.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productrepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category category1 = new Category(null,"informática");
		Category category2 = new Category(null,"escritório");

		Product product1 = new Product(null,"Computador",2000.00);
		Product product2 = new Product(null,"Impressora",800.00);
		Product product3 = new Product(null,"Mouse",80.00);

		category1.getProducts().addAll(Arrays.asList(product1,product2,product3));
		category2.getProducts().addAll(Arrays.asList(product2));

		product1.getCategories().add(category1);
		product2.getCategories().addAll(Arrays.asList(category1,category2));
		product3.getCategories().add(category1);

		categoryRepository.saveAll(Arrays.asList(category1,category2));
		productrepository.saveAll(Arrays.asList(product1,product2,product3));

		State state1 = new State(null,"Minas Gerais");
		State state2 = new State(null,"São Paulo");
		System.out.println(state1);
		System.out.println(state2);
		City city1 = new City(null, "Uberlândia",state1);
		City city2 = new City(null, "São Paulo",state2);
		City city3 = new City(null, "Campinas",state2);

		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2,city3));

		stateRepository.saveAll(Arrays.asList(state1,state2));
		cityRepository.saveAll(Arrays.asList(city1,city2,city3));
	}
}
