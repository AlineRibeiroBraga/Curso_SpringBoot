package br.com.invillia.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "state")
    private List<City> cities = new ArrayList<>();

    public State(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
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

