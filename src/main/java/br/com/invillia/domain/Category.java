package br.com.invillia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    private Integer Id;
    private String name;

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