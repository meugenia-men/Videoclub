import enums.AudienceClassification;
import enums.Genre;
import models.Client;
import models.Film;
import models.Ticket;
import models.VideoClub;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Collections.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //region Listas
        Film n1 = new Film("EL Padrino", 1972, 175, AudienceClassification.NC17, Genre.DRAMA, "EEUU", "El patriarca de una organizacion criminal transfiere el control de su imperio a su reacio hijo", 3);
        Film n2 = new Film("Forrest Gump", 1994, 142, AudienceClassification.PG13, Genre.DRAMA, "EEUU", "La presidencia de Kennedy Jhonson, los eventos de vietnam, Watergate, vistas de la perspectiva de hombre de Alabama con un coeficiente mental de 75", 3);
        Film n3 = new Film("Volver al futuro", 1985, 116, AudienceClassification.G, Genre.AVENTURA, "EEUU", "Martin Mc fly, un estudiante de 17 años es enviado accidentalmente 30 años al pasado en un artefacto inventado por su amigo", 3);
        Film n4 = new Film("El resplandor", 1980, 146, AudienceClassification.R, Genre.HORROR, "EEUU", "Una familia se dirige a un hotel aislado para el invierno donde una presencia siniestra influye en la violencia del padre,mientras que su hijo psíquico ve horripilantes presentimientos tanto del pasado como del futuro", 2);
        Film n5 = new Film("The truman show", 1998, 103, AudienceClassification.G, Genre.COMEDIA, "EEUU", "Un hombre comun que no sabe que desde antes de nacer, es protagonista del mayor 'Reality Show' mundial. Sin embargo, su curiosidad innata y sentido de la aventura lo llevaran a descubrir la verdad", 2);
        Film n6 = new Film("El secreto de sus ojos", 2009, 129, AudienceClassification.PG13, Genre.DRAMA, "ARG", "Un juez tiene dudas de los planes de un oficial de justicia recientemente retirado que intenta descubrir al culpable de la violación y el asesinatos de una joven, crimen ocurrido décadas atras.", 3);

        Client c1 = new Client("Neira Maria Eugenia", "31561321", "Catamarca 2372", 2914042035L);
        Client c2 = new Client("Rodriguez Martin", "30697998", "Cordoba 2135", 2233039545L);

        List<Client> clients = new ArrayList<>();
        clients.add(c1);
        clients.add(c2);

        List<Film> films = new ArrayList<>();
        films.add(n1);
        films.add(n2);
        films.add(n3);
        films.add(n4);
        films.add(n5);
        films.add(n6);

        List<Ticket> tickets = new ArrayList<>();

        VideoClub videoClub = new VideoClub(clients, films, tickets);

        //endregion

        Film f = new Film();
        Client c;
        Scanner sc = new Scanner(System.in);
        Integer opc;

        do {
            //region MENU
            System.out.println("<<<<<<<<<<<<<<<<<<< Menu VideoCLub >>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("1) Ingreso de Cliente ");
            System.out.println("2) Ingreso de Alquiler");
            System.out.println("3) Devolucion de alquiler");
            System.out.println("4) Lista de alquileres vigentes");
            System.out.println("5) Lista de devoluciones del dia de la fecha");
            System.out.println("6) Lista de alquileres por cliente");
            System.out.println("7) Pelicula mas alquiladas");
            System.out.println("8) Detalle de informacion de una pelicula");
            System.out.println("9) Lista de peliculas por genero y popularidad");
            System.out.println("0) Salir");
            System.out.println("Seleccione la opcion deseada...");
            opc = sc.nextInt();
            sc.nextLine();
            //endregion

            String ok;
            switch (opc) {
                case 1:
                    //region Ingreso de un nuevo cliente
                    do {
                        System.out.println("_____________________________________________________________________________________");
                        System.out.println("Ingrese el nombre : ");
                        String nameNew = sc.nextLine();
                        System.out.println("Ingrese el DNI :");
                        String dniNew = sc.nextLine();
                        System.out.println("Ingrese la direccion : ");
                        String addressNew = sc.nextLine();
                        System.out.println("Ingrese el telefono : ");
                        Long phoneNew = sc.nextLong();

                        Client cNew = new Client(nameNew, dniNew, addressNew, phoneNew);

                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Datos del cliente ingresado >>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println(cNew);
                        System.out.println("------------> Los datos son correctos? si o no");
                        sc.nextLine();
                        ok = sc.nextLine();

                        if (ok.equalsIgnoreCase("si")) {
                            videoClub.getClient().add(cNew);
                            System.out.println("Cliente Ingresado con exito!");
                            sc.nextLine();
                            System.out.println("_____________________________________________________________________________________");
                        } else {
                            System.out.println("Ingrese los datos nuevamente ----------------->");
                        }
                    } while (ok.equalsIgnoreCase("no"));
                    //endregion
                    break;
                case 2:
                    //region Ingreso de un alquiler
                    System.out.println("_____________________________________________________________________________________");
                    int tries = 0;
                    //region Busco pelicula
                    do {
                        System.out.println("Ingrese la PELICULA que desea buscar en el archivo  = ");
                        String nameFilm = sc.nextLine();
                        f = videoClub.searchFilm(nameFilm);
                        tries++;
                    } while (f == null && tries < 2);
                    //endregion
                    if (tries == 2) {
                        System.out.println("Pelicula no encontrada");
                        sc.nextLine();
                    }
                    if (f != null && f.getCopiesNumber() > 0) {
                        System.out.println("Pelicula encontrada con cantidad disponible para alquilar = " + f.getCopiesNumber());
                        sc.nextLine();
                        int trying = 0; //numero de intentos
                        //region Busco cliente
                        do {
                            System.out.println("Ingrese el DNI del cliente = ");
                            String dniCustomer = sc.nextLine();
                            c = videoClub.searchClient(dniCustomer);
                            trying++;
                        } while (c == null && trying < 3); // me permite que pida nuevamente el cliente x 3 veces hasta que lo encuentra sino pregunta si desea agregarlo
                        //endregion
                        //Genero ticket de alquiler
                        if (c != null) {
                            f.setCopiesNumber(f.getCopiesNumber() - 1);// disminuyo la disponibilidad
                            Ticket ticket1 = new Ticket(c, f);//genero un ticket de alquiler
                            System.out.println("_____________________________________________________________________________________");

                            System.out.println(ticket1);
                            videoClub.getTickets().add(ticket1);
                            System.out.println("Alquiler exitoso");
                            System.out.println("_____________________________________________________________________________________");
                            sc.nextLine();

                        } else {
                            System.out.println("CLiente no encontrado ir al menu opcion 1 ...");
                            sc.nextLine();
                        }
                    }
                    //endregion
                    break;
                case 3:
                    //region Devolucion de pelicula
                    System.out.println("Ingrese el DNI del cliente : ");
                    String searchingDni = sc.nextLine();
                    System.out.println("Ingrese la pelicula a devolver : ");
                    String filmTitle = sc.nextLine();
                    Ticket t = videoClub.searchTicket(searchingDni, filmTitle);
                    if (t != null) {
                        System.out.println("Devolucion de pelicula exitosa!");
                        t.getFilm().setCopiesNumber(t.getFilm().getCopiesNumber() + 1);
                    }
                    System.out.println();
                    //endregion
                    break;
                case 4:
                    //region Lista de alquileres vigentes
                    System.out.println(videoClub.toStringTickets());
                    sc.nextLine();
                    //endregion
                    break;
                case 5:
                    //region Lista de devoluciones de hoy
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Lista de devoluciones de HOY >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    int cant = 0;
                    for (Ticket ti : videoClub.getTickets()) {
                        if (LocalDate.now().equals(ti.getReturnDate())) {
                            System.out.println(ti);
                            System.out.println("               --------------------------------------------------------------------");
                            cant++;
                        }
                        if (cant == 0) {
                            System.out.println("No hay devoluciones en el dia de la fecha");
                        }
                        sc.nextLine();
                    }
                    //endregion
                    break;
                case 6:
                    //region Lista de alquiler por cliente
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Lista de alquileres por cliente >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("Ingrese el DNI del cliente : ");
                    String dni = sc.nextLine();
                    Client cli = videoClub.searchClient(dni);
                    if (cli != null) {
                        videoClub.searchTicketsForClient(cli);
                        sc.nextLine();
                    }
                    //endregion
                    break;
                case 7:
                    //region Pelicula mas alquilada
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Pelicula mas alquilada >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    Film bestFilm = videoClub.bestFilm(videoClub.getFilms());
                    System.out.println(bestFilm.toString());
                    System.out.println("____________________________________________________________________________________________");
                    //endregion
                    break;
                case 8:
                    //region Detalle de pelicula
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Detalle de la pelicula >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("Ingrese la pelicula : ");
                    String title = sc.nextLine();
                    if (videoClub.searchFilm(title) != null) {
                        System.out.println((videoClub.searchFilm(title)).toString());
                        sc.nextLine();
                    }
                    //endregion
                    break;
                case 9:
                    //region Lista de peliculas ordenada por genero y popularidad

                    /// primero las ordeno por popularidad si es que hay lista de tickets/alquileres

                    if (!videoClub.getTickets().isEmpty()) { // verifico que tenga lista de tickets
                        List<Film> aux = videoClub.getFilms();
                        List<Film> inOrder = new ArrayList<>();
                        while (!aux.isEmpty()) {
                            Film popular = videoClub.bestFilm(aux);
                            if (popular.getTitle() == null){
                                break;
                            }
                            inOrder.add(popular);
                            aux.remove(popular);
                        }

                        if (videoClub.getFilms().size() != inOrder.size()){ // verifico que la lista in order me quede completa incluso con las peliculas que nunca nadie alquilo
                            for (Film filmInOrder : inOrder){
                                videoClub.getFilms().remove(filmInOrder);
                            }
                            inOrder.addAll(videoClub.getFilms());
                        }
                        videoClub.setFilms(inOrder); //seteo la lista original y la reemplazo por la lista ordenada por popularidad
                    }
                    /// despues las ordeno por genero
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> Lista de peliculas ordenadas por genero <<<<<<<<<<<<<<<<<<<<<<<");
                    videoClub.getFilms().sort(Comparator.comparing(Film::getGenre));
                    videoClub.getFilms().forEach(lista -> System.out.println(lista.toString()));
                    System.out.println("_____________________________________________________________________________________________________________________");
                    //endregion
                    break;
                case 0:
                    //region SALIR
                    System.out.println("Saliendo......");
                    //endregion
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta por favor!...");
                    sc.nextLine();
                    break;
            }
        } while (opc != 0);
    }
}
