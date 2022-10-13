package computer.computer.controlador;


import computer.computer.modelo.Reservation;
import computer.computer.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationServices reservationServices;
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationServices.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationServices.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationServices.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return reservationServices.delete(id);
    }
}
 