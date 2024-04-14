package models;

import enums.AudienceClassification;
import enums.Genre;

import java.util.Comparator;

public class Film  implements Comparable<Film> {
    private String title;
    private Integer year;
    private Integer minutes;
    private AudienceClassification audienceClassification;
    private Genre genre;
    private String countryInitials;
    private String description;
    private Integer copiesNumber;
    private Integer rentedAmount = 0;

    public Film() {
    }

    public Film(String title, Integer year, Integer minutes, AudienceClassification audienceClassification, Genre genre, String countryInitials, String description, Integer copiesNumber) {
        this.title = title;
        this.year = year;
        this.minutes = minutes;
        this.audienceClassification = audienceClassification;
        this.genre = genre;
        this.countryInitials = countryInitials;
        this.description = description;
        this.copiesNumber = copiesNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public AudienceClassification getAudienceClassification() {
        return audienceClassification;
    }

    public void setAudienceClassification(AudienceClassification audienceClassification) {
        this.audienceClassification = audienceClassification;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getCountryInitials() {
        return countryInitials;
    }

    public void setCountryInitials(String countryInitials) {
        this.countryInitials = countryInitials;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCopiesNumber() {
        return copiesNumber;
    }

    public void setCopiesNumber(Integer copiesNumber) {
        this.copiesNumber = copiesNumber;
    }

    public Integer getRentedAmount() {
        return rentedAmount;
    }

    public void setRentedAmount(Integer rentedAmount) {
        this.rentedAmount = rentedAmount;
    }

    @Override
    public String toString() {
        return "PELICULA\n" +
                "Titulo = '" + title + '\'' +
                "\nAño = " + year +
                "\nDuracion = " + minutes + "minutos "+
                "\nClasificacion = " + audienceClassification +
                "\nGenero = " + genre +
                "\nNacionalidad = '" + countryInitials + '\'' +
                "\nDescripcion = '" + description + '\'' +
                "\nCopias disponibles = [" + copiesNumber +
                ']';
    }

    @Override
    public int compareTo(Film o) {
        return this.getRentedAmount().compareTo(o.getRentedAmount());
    }

}
