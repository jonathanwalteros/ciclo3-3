package computer.computer.services;

import computer.computer.modelo.Computer;
import computer.computer.repositorio.ComputerRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServices {
    @Autowired
    private ComputerRepositorio computerRepositorio;

    public List<Computer> getAll() {
        return computerRepositorio.getAll();


    }

    public Computer save(Computer computer) {
        if (computer.getId() == null) {
            return computerRepositorio.save(computer);


        } else {
            Optional<Computer> opt = computerRepositorio.getComputer(computer.getId());
            if (opt.isEmpty()) {
                return computerRepositorio.save(computer);

            } else {

                return computer;
            }
        }
    }
}