package br.com.invillia.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "state_id") //foreign key
    private State state;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City)o;
        if(id == null){
            if(state.getId() != null)
                return false;
        }
        else if( !getId().equals(state.getId()))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result =1;
        result = prime * result +((id == null) ? 0 : getId().hashCode());

        return result;
    }
}
