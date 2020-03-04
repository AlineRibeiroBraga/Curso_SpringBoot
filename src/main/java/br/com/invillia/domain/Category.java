package br.com.invillia.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;


    @JsonManagedReference
    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

    public Category(Integer id, String name) {
        Id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result =1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        if(getId() == null){
            if(category.getId() != null)
                return false;
        }
        else if(!getId().equals(category.getId()))
            return false;
        return true;
    }
}
