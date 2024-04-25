package models;

import enums.Genre;

import java.util.ArrayList;
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

    public String toStringTickets() {
        String data = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Lista de alquileres  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n";
        for (Ticket t : tickets) {
            data += t.toString() + "\n________________________________________________________________________________________________________________________________________\n ";
        }
        return data;
    }

    public String searchTicketsForClient(Client c) {
        if (tickets != null) {
            for (Ticket t : tickets) {
                if (t.getClient().equals(c)) {
                    System.out.println(t.toString());
                    System.out.println("_____________________________________________________________________");
                }
            }
        }
        return null;
    }

    public Film bestFilm(List<Film> x) {
        Integer rentNumber;
        Integer max = 0;
        Film bestFilm = new Film();

        for (Film f : x) {
            rentNumber = 0;
            for (Ticket t : tickets) {
                if (f.getTitle().equalsIgnoreCase(t.getFilm().getTitle())) {
                    rentNumber++;
                }
            }
            if (rentNumber > max) {
                max = rentNumber;
                bestFilm = f;
            }
        }
        return bestFilm;
    }

    public List<Film> filmsListForGenre() {

        List<Film> aux = films;
        List<Film> filmsXGenre = new ArrayList<>();

        while (!aux.isEmpty()) {
            Genre firstGenre = aux.getFirst().getGenre();
            for (Film x : aux) {
                if (x.getGenre().equals(firstGenre)) {
                    filmsXGenre.add(x);
                    aux.remove(x);
                } else {
                    aux.addFirst(x);
                }
            }
        }

        return filmsXGenre;
    }


    public List<Film> filmsListForGenreAndPopularity() {
        this.setFilms(this.filmsListForGenre());
        List<Film> newList = new ArrayList<>();

        while (!films.isEmpty()) {
            Genre firstGenre = films.getFirst().getGenre();
            Integer position = 0;
            while (films.get(position).getGenre().equals(firstGenre)) {
                newList.add(films.get(position));
                films.remove(films.get(position));
                position++;
            }


        }
        return newList;
    }

}
