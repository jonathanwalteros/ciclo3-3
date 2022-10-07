package computer.computer.controlador;

import computer.computer.modelo.Client;
import computer.computer.modelo.Computer;
import computer.computer.services.ClientServices;
import computer.computer.services.ComputerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientServices clientServices;
    @GetMapping("/all")
    public List<Client> getClient(){
        return clientServices.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientServices.save(client);
    }
}
 