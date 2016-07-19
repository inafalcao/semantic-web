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
public class ElementoLista {
    
    public String uri;
    public String descricao;
    
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ElementoLista(String uri, String descricao) {
        this.uri = uri;
        this.descricao = descricao;
    }

    public ElementoLista() {
    }

    
}
