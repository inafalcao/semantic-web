/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.examples.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.javacodegeeks.examples.model.newmodel.Evento;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;



/**
 *
 * @author Narciso
 */
public class MashupMusicEvents {

    String listMusicEvents;

    public Set<ElementoLista> getListMusicArtist() {
        String queryString = "PREFIX dbo: <http://dbpedia.org/ontology/> " +
                              "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                              "SELECT DISTINCT ?s ?label WHERE {" +
                              "?s a dbo:MusicalArtist . "+
                              "?s rdfs:label ?label ."+
                              "} LIMIT 20";
        Set<ElementoLista> lista;
        lista = new HashSet<ElementoLista>();

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://pt.dbpedia.org/sparql", query); //http://dbpedia.org/sparql
        try
          {
            ResultSet results = qexec.execSelect();
            while(results.hasNext()){

                ElementoLista elemento=new ElementoLista();
                QuerySolution soln = results.nextSolution();
                elemento.setDescricao(soln.get("s").toString());
                elemento.setDescricao(soln.getLiteral("label").getValue().toString());
                lista.add(elemento);
            }
          }
        finally{
              qexec.close();
          }
        return lista;
    }

    public Set<ElementoLista> getListGenre() {

        String queryString = "PREFIX dbo: <http://dbpedia.org/ontology/> " +
                              "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                              "SELECT DISTINCT ?s ?label WHERE {" +
                              "?s a dbo:MusicGenre . "+
                              "?s rdfs:label ?label ."+
                              "} LIMIT 20";

        Set<ElementoLista> lista;
        lista = new HashSet<ElementoLista>();

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://pt.dbpedia.org/sparql", query); //http://dbpedia.org/sparql
        try
          {
            ResultSet results = qexec.execSelect();
            while(results.hasNext()){

                ElementoLista elemento=new ElementoLista();
                QuerySolution soln = results.nextSolution();
                elemento.setDescricao(soln.get("s").toString());
                elemento.setDescricao(soln.getLiteral("label").getValue().toString());
                lista.add(elemento);
            }
          }
        finally{
              qexec.close();
          }

        return lista;
    }

    public List<ElementoEvento> getListMusicEvents() throws ParseException {

        List<ElementoEvento> lista;
        lista = new ArrayList<ElementoEvento>();
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");

        ElementoEvento elemento=new ElementoEvento();
        elemento.setMusicartist(new ElementoLista("Avioes do Forro","Aviões do Forró é uma banda brasileira de forró eletrônico formada em Fortaleza no dia 4 de agosto de 2002 por Zeca Aristides, André Camurça, Matheus Guedes de Moura, Antônio Isaías, Carlos Aristides e Cláudio Melo"));
        elemento.setGenre(new ElementoLista("Forro",""));
        elemento.setData("18/07/2016");
        elemento.setLat(-3.78845);
        elemento.setLonge(-38.4761);
        elemento.setLocal("ArenaPDD");
        elemento.setRank(10);
        elemento.setIngresso("Ingresso Rápido R$ 24");
        elemento.setNumAcessos(123123);
        elemento.setVisitantes(12313);

        lista.add(elemento);


        elemento=new ElementoEvento();
        elemento.setMusicartist(new ElementoLista("http://pt.dbpedia.org/page/Nando_Reis","Nando Reis"));
        elemento.setGenre(new ElementoLista("http://pt.dbpedia.org/resource/MPB","MPB"));
        elemento.setData("18/07/2016");
        elemento.setLat(-4.520419);
        elemento.setLonge(-37.70894);
        elemento.setLocal("Barraca_Chega_Mais");
        elemento.setRank(20);
        elemento.setIngresso(" Ingresso Rápido R$ 30");
        elemento.setNumAcessos(456456456);
        elemento.setVisitantes(234234);

        lista.add(elemento);


        return lista;
    }

    public List<Evento> getEventos() {

        List<Evento> eventos = new ArrayList<Evento>();

        Evento evento = new Evento();
        evento.setNome("Nando Reis em Canoa");
        evento.setDescricao("O Luau mais top do Brasil, desembarca em Canoa Quebrada, dia 16 de julho na barraca Chega Mais Beach - Lounge e Restaurante");
        evento.setData("18-07-2016");
        evento.setIngresso("Inteira R$ 25,00");
        evento.setLocal("Barraca_Chega_Mais");
        evento.setLat(-4.520419);
        evento.setLng(-37.70894);
        evento.getMusicArtist().setGenre("MPB");
        evento.getMusicArtist().setHomePage("www.nandoreis.com");
        evento.getMusicArtist().setName("Nando Reis");
        evento.getMusicArtist().setDescricao("José Fernando Gomes dos Reis, conhecido artisticamente como Nando Reis é um baixista, cantor, violonista e compositor brasileiro. Ex-baixista da banda de rock Titãs, atualmente segue em carreira solo, acompanhado pela banda Os Infernais.");

        evento.getMusicArtist().getRank().setRank(12);
        evento.getMusicArtist().getRank().setVisitantes(12123);
        evento.getMusicArtist().getRank().setNumAcessos(12123345);

        eventos.add(evento);


        Evento evento2 = new Evento();
        evento2.setNome("Aviões do Forró");
        evento2.setDescricao("O Luau mais top do Brasil, desembarca em Canoa Quebrada, dia 16 de julho na barraca Chega Mais Beach - Lounge e Restaurante");
        evento2.setData("18-07-2016");
        evento2.setIngresso("Inteira R$ 30,00");
        evento2.setLocal("ArenaPDD");
        evento2.setLat(-3.78845);
        evento2.setLng(-38.4761);
        evento2.getMusicArtist().setGenre("Forro");
        evento2.getMusicArtist().setHomePage("www.avioesdoforro.com");
        evento2.getMusicArtist().setName("Aviões do Forró");
        evento2.getMusicArtist().setDescricao("Aviões do Forró é uma banda brasileira de forró eletrônico formada em Fortaleza no dia 4 de agosto de 2002 por Zeca Aristides, André Camurça, Matheus Guedes de Moura, Antônio Isaías, Carlos Aristides e Cláudio Melo.");

        evento2.getMusicArtist().getRank().setRank(12);
        evento2.getMusicArtist().getRank().setVisitantes(12123);
        evento2.getMusicArtist().getRank().setNumAcessos(12123345);

        eventos.add(evento2);



        return eventos;
    }

}
