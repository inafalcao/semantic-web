package com.javacodegeeks.examples.model.newmodel;

/**
 * Created by inafalcao on 7/19/16.
 */
public class MusicArtist {

    private String name;
    private String homePage;
    private String genre;
    private Ranking rank;
    private String descricao;

    public MusicArtist() {
        rank = new Ranking();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Ranking getRank() {
        return rank;
    }

    public void setRank(Ranking rank) {
        this.rank = rank;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
