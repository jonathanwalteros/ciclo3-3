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
    public Optional<Computer> getComputer(int id){
        return computerRepositorio.getComputer(id);
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
    public Computer update (Computer computer){
        if(computer.getId()!=null){
            Optional <Computer> op = computerRepositorio.getComputer(computer.getId());
            if (op.isPresent()){
                if (computer.getName()!=null){
                    op.get().setName(computer.getName());

                }
                if (computer.getBrand()!=null){
                    op.get().setBrand(computer.getBrand());

                }
                if (computer.getModel()!=null){
                    op.get().setModel(computer.getModel());
                }
                computerRepositorio.save(op.get());
                return op.get();

            }else {
                return computer;
            }
        }else {
            return computer;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Computer>computer=computerRepositorio.getComputer(id);
        if (computer.isPresent()){
            computerRepositorio.delete(computer.get());
            flag=true;
        }
        return flag;
    }
}