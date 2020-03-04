package br.com.invillia.service;

import br.com.invillia.domain.Category;
import br.com.invillia.repository.CategoryRepository;

import br.com.invillia.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category find(Integer id){

        Optional<Category> category =categoryRepository.findById(id);

        return category.orElseThrow( () -> new ObjectNotFoundException(String.format("Object wasn't found! Id: " +
                "%d, Tipo: %s",id,Category.class.getName())));
    }
}
