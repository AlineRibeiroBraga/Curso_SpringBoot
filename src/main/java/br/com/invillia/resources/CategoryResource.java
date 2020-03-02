package br.com.invillia.resources;

import br.com.invillia.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> listar(){

        Category cat1 = new Category(1, "informática");
        Category cat2 = new Category(2, "escritório");

        List<Category> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }
}