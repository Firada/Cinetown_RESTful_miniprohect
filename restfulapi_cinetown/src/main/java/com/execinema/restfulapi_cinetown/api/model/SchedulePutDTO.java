package com.execinema.restfulapi_cinetown.api.model;

public class SchedulePutDTO {

    private String cinema_name;
    private String film_name;
    private String film_producer;
    private String message;

    public SchedulePutDTO() {
    }

    public SchedulePutDTO(String cinema_name, String film_name, String film_producer) {
        this.cinema_name = cinema_name;
        this.film_name = film_name;
        this.film_producer = film_producer;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_producer() {
        return film_producer;
    }

    public void setFilm_producer(String film_producer) {
        this.film_producer = film_producer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SchedulePutDTO{" +
                "cinema_name='" + cinema_name + '\'' +
                ", film_name='" + film_name + '\'' +
                ", film_producer='" + film_producer + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
