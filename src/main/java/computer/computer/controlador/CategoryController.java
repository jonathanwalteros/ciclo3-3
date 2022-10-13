package computer.computer.controlador;

import computer.computer.modelo.Category;

import computer.computer.services.CategoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;
    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryServices.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryServices.save(category);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryServices.update(category);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return categoryServices.delete(id);
    }

}
 