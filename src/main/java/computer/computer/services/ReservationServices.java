package computer.computer.services;

import computer.computer.modelo.Computer;
import computer.computer.modelo.Reservation;
import computer.computer.repositorio.ComputerRepositorio;
import computer.computer.repositorio.ReservationRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServices {
    @Autowired
    private ReservationRepositorio reservationRepositorio;

    public List<Reservation> getAll() {
        return reservationRepositorio.getAll();


    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepositorio.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepositorio.save(reservation);


        } else {
            Optional<Reservation> opt = reservationRepositorio.getReservation(reservation.getIdReservation());
            if (opt.isEmpty()) {
                return reservationRepositorio.save(reservation);

            } else {

                return reservation;
            }
        }
    }
    public Reservation update (Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional <Reservation> op = reservationRepositorio.getReservation(reservation.getIdReservation());
            if (op.isPresent()){
                if (reservation.getName()!=null){
                    op.get().setName(reservation.getName());

                }
                if (reservation.getStatus()!=null){
                    op.get().setStatus(reservation.getStatus());

                }
                if (reservation.getDescription()!=null){
                    op.get().setDescription(reservation.getDescription());
                }
                if (reservation.getStarDate()!=null){
                    op.get().setStarDate(reservation.getStarDate());
                }
                if (reservation.getDevolutionDate()!=null){
                    op.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getScore()!=null){
                    op.get().setScore(reservation.getScore());
                }

                reservationRepositorio.save(op.get());
                return op.get();

            }else {
                return reservation;
            }
        }else {
            return reservation;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>reservation=reservationRepositorio.getReservation(id);
        if (reservation.isPresent()){
            reservationRepositorio.delete(reservation.get());
            flag=true;
        }
        return flag;
    }
}