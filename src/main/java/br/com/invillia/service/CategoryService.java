package br.com.invillia.service;

import br.com.invillia.domain.Category;
import br.com.invillia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category find(Integer id){

        Optional<Category> category =categoryRepository.findById(id);

        return category.orElse(null);
    }
}
