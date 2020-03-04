package br.com.invillia.domain;

import br.com.invillia.domain.enums.ClientKind;
import jdk.jshell.Snippet;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String CPF_CNPJ;
    private Integer clientKind;

    @ElementCollection
    @CollectionTable(name = "Phones")
    private Set<String> phones = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<>();

    public Client(Integer id, String name, String email, String CPF_CNPJ, ClientKind clientKind) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.CPF_CNPJ = CPF_CNPJ;
        this.clientKind = clientKind.getCode();
    }

    public ClientKind getClientKind() {
        return ClientKind.toEnum(clientKind);
    }

    public void setClientKind(ClientKind clientKind) {
        this.clientKind = clientKind.getCode();
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
        Client client = (Client) o;
        if(getId() == null){
            if(client.getId() != null)
                return false;
        }
        else if(!getId().equals(client.getId()))
            return false;
        return true;
    }
}
