package br.com.invillia.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;

    @ManyToMany
    @JoinTable(name="Product_Category",
            joinColumns = @JoinColumn(name = "product_Id"),
            inverseJoinColumns = @JoinColumn(name = "category_Id")
    )
    private List<Category> categories = new ArrayList<>();

    public Product(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result =1;
        result = prime * result +((id == null) ? 0 : getId().hashCode());

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        if(id == null){
            if(product.getId() != null)
                return false;
        }
        else if( !getId().equals(product.getId()))
            return false;

        return true;
    }
}
