package computer.computer.repositorio;

import computer.computer.modelo.Computer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComputerCrudRepository extends CrudRepository<Computer,Integer> {
    @Query("SELECT c.model,count (c.model) from Computer as c order by count (c.model) desc ")
    public List<Object[]> countTotalComputerByModel();

}
