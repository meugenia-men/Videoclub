package models;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Ticket {
    private static Integer id = 0;
    private Client client;
    private Film film;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public Ticket() {
    }

    public Ticket(Client client, Film film) {
        id++;
        this.client = client;
        this.film = film;
        this.rentalDate = LocalDate.now();
        this.returnDate = rentalDate.plusDays(3);
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    @Override
    public String toString(){
        return "Cliente ["+this.client.getName()+"] - Pelicula alquilada ["+this.film.getTitle()+"] - Fecha de alquiler ["+this.rentalDate+"] - Fecha de devolucion ["+this.returnDate+"]";
    }
}
