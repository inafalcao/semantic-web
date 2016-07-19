/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.examples.model;



/**
 *
 * @author Narciso
 */
public class ElementoEvento {
    
    public ElementoLista musicartist;


    // Dados do evento
    public String data;
    public ElementoLista genre;
    public String local;
    public String ingresso;
    public double lat;
    public double longe;

    public String descricao;


    // Dados de ranking
    public int rank;
    public long numAcessos;
    public long visitantes;



    public void setVisitantes(long visitantes) {
        this.visitantes = visitantes;
    }

    public long getVisitantes() {
        return visitantes;
    }

    public ElementoLista getMusicartist() {
        return musicartist;
    }

    public void setMusicartist(ElementoLista musicartist) {
        this.musicartist = musicartist;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLonge() {
        return longe;
    }

    public void setLonge(double longe) {
        this.longe = longe;
    }

    public ElementoLista getGenre() {
        return genre;
    }

    public void setGenre(ElementoLista genre) {
        this.genre = genre;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getIngresso() {
        return ingresso;
    }

    public void setIngresso(String ingresso) {
        this.ingresso = ingresso;
    }


    public long getNumAcessos() {
        return numAcessos;
    }

    public void setNumAcessos(long numAcessos) {
        this.numAcessos = numAcessos;
    }

}
