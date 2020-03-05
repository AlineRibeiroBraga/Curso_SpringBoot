package br.com.invillia.resources;


import br.com.invillia.domain.Client;
import br.com.invillia.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientResource {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Client client = clientService.find(id);

        return ResponseEntity.ok().body(client);
    }
}
