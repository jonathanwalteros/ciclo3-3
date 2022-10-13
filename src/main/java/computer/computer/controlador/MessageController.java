package computer.computer.controlador;

import computer.computer.modelo.Computer;
import computer.computer.services.ComputerServices;
import computer.computer.services.MessageServices;


import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageServices messageServices;
    @GetMapping("/all")
    public List<Message> getMessage(){
        return messageServices.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return messageServices.save(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return messageServices.delete(id);
    }
}
 