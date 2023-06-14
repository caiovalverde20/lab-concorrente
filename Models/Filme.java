package Models;

import java.util.List;

public class Filme {
    private String id;
    private String titulo;
    private double averageRating;
    private int numberOfVotes;
    private int startYear;
    private Integer lengthInMinutes;
    private List<String> genres;


    public Filme(String id, String titulo, double averageRating, int numberOfVotes, int startYear, Integer lengthInMinutes, List<String> genres) {
        this.id = id;
        this.titulo = titulo;
        this.averageRating = averageRating;
        this.numberOfVotes = numberOfVotes;
        this.startYear = startYear;
        this.lengthInMinutes = lengthInMinutes;
        this.genres = genres;
    }


    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public int getStartYear() {
        return startYear;
    }

    public Integer getLengthInMinutes() {
        return lengthInMinutes;
    }

    public List<String> getGenres() {
        return genres;
    }

}