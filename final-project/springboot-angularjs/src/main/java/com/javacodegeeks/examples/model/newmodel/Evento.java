package com.javacodegeeks.examples.model.newmodel;

/**
 * Created by inafalcao on 7/19/16.
 */
public class Evento {

    private String nome;
    private String descricao;
    private String data;
    private String ingresso;
    private String local;
    private double lat;
    private double lng;

    private MusicArtist musicArtist;

    public Evento() {
        musicArtist = new MusicArtist();
    }


    public MusicArtist getMusicArtist() {
        return musicArtist;
    }

    public void setMusicArtist(MusicArtist musicArtist) {
        this.musicArtist = musicArtist;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIngresso() {
        return ingresso;
    }

    public void setIngresso(String ingresso) {
        this.ingresso = ingresso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
