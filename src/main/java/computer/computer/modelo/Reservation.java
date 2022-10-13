package computer.computer.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")

public class Reservation implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date starDate;
    private Date devolutionDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "computerid")
    @JsonIgnoreProperties("computer")
    private Computer computer;




    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnoreProperties("reservation")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "messageid")
    @JsonIgnoreProperties("messages")
    private Message message;
    @ManyToOne
    @JoinColumn(name = "clientid")
    @JsonIgnoreProperties("client")
    private Client client;

    private Integer score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}