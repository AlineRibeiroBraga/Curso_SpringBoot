package br.com.invillia.service;

import br.com.invillia.domain.Category;
import br.com.invillia.domain.Client;
import br.com.invillia.repository.ClientRepository;
import br.com.invillia.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client find(Integer id){

        Optional<Client> client =clientRepository.findById(id);

        return client.orElseThrow( () -> new ObjectNotFoundException(String.format("Object wasn't found! Id: " +
                "%d, Tipo: %s",id,Category.class.getName())));
    }
}
