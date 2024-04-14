package enums;

public enum Genre {

    ACCION("Accion"), AVENTURA("Aventura"), COMEDIA("Comedia"), DRAMA("Drama"), HORROR("Horror"), DOCUMENTAL("Documental");


    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }
}
