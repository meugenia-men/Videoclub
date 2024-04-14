package models;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class VideoClub {
    private List<Client> clients;
    private List<Film> films;
    private List<Ticket> tickets;

    public VideoClub() {
    }

    public VideoClub(List<Client> clients, List<Film> films, List<Ticket> tickets) {
        this.clients = clients;
        this.films = films;
        this.tickets = tickets;
    }

    public List<Client> getClient() {
        return clients;
    }

    public void setClient(List<Client> client) {

        this.clients = client;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Film searchFilm(String nameFilm) {

        if (this.films != null) {
            for (Film f : this.films) {
                if (f.getTitle().equalsIgnoreCase(nameFilm)) {
                    return f;
                }
            }
        }
        return null;
    }

    public Client searchClient(String dni) {
        if (this.clients != null) {
            for (Client c : this.clients) {
                if (c.getDni().equalsIgnoreCase(dni)) {
                    return c;
                }
            }
        }
        return null;
    }

    public Ticket searchTicket(String dni, String title) {
        if (this.tickets != null) {
            for (Ticket t : tickets) {
                if (t.getClient().getDni().equalsIgnoreCase(dni) && t.getFilm().getTitle().equalsIgnoreCase(title)) {
                    return t;
                }
            }
        }
        return null;
    }

    public String toStringTickets(){
        String data = "Lista de alquileres generados : \n";
        for (Ticket t : tickets){
            data += t.toString() +"\n_____________________________________________________________________________________________________________\n ";
        }
        return data;
    }

    public String searchTicketsForClient(Client c){
        if (this.tickets != null) {
            for (Ticket t : tickets) {
                if (t.getClient().equals(c)) {
                    System.out.println(t.toString());
                    System.out.println("_____________________________________________________________________");
                }
            }
        }
        return null;
    }


}
