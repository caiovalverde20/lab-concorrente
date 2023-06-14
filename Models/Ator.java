package Models;

import java.util.List;

public class Ator {
    private String id;
    private String nome;
    private List<String> filmes;


    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getFilmes() {
        return filmes;
    }

    public Ator(String id, String nome, List<String> filmes) {
        this.id = id;
        this.nome = nome;
        this.filmes = filmes;
    }

}