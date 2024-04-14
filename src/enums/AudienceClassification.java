package enums;

public enum AudienceClassification {
    G("Apta para todo publico"),
    PG("Sugiere compañia de un adulto a menores de 10 años"),
    PG13("Sugiere la compañia de un adulto para menores de 13 años"),
    R("Restringido a menores de 17 años"),
    NC17("Apto para mayores de 18 años"),
    UNRATED("Peliculas que no han pasado el proceso de clasificacion");
    private String audienceClassification;

    AudienceClassification(String audienceClassification) {
        this.audienceClassification = audienceClassification;
    }
}
