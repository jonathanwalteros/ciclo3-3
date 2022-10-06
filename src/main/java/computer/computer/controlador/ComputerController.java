package computer.computer.controlador;

import computer.computer.modelo.Computer;
import computer.computer.services.ComputerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Computer")
public class ComputerController {
    @Autowired
    private ComputerServices computerServices;
    @GetMapping("/all")
    public List<Computer> getComputer(){
        return computerServices.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer save(@RequestBody Computer computer){
        return computerServices.save(computer);
    }
}