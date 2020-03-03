package br.com.invillia.repository;

import br.com.invillia.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepository extends JpaRepository<Product, Integer> {
}
