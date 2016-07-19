package com.javacodegeeks.examples.controller;

import com.javacodegeeks.examples.model.ElementoEvento;
import com.javacodegeeks.examples.model.ElementoLista;
import com.javacodegeeks.examples.model.MashupMusicEvents;
import com.javacodegeeks.examples.model.newmodel.Evento;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class MainController {

    /*@RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }*/

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public MashupMusicEvents getTest() throws ParseException {

        // TODO code application logic here
        MashupMusicEvents objMashup = new MashupMusicEvents();

        Set<ElementoLista> lista1 = new HashSet<ElementoLista>();
        lista1=objMashup.getListMusicArtist();
        for (Iterator<ElementoLista> iterator = lista1.iterator(); iterator.hasNext();) {
            ElementoLista next = iterator.next();
            System.out.println(next.descricao +""+next.uri);

        }

        Set<ElementoLista> lista3= new HashSet<ElementoLista>();
        lista3=objMashup.getListGenre();
        for (Iterator<ElementoLista> iterator = lista3.iterator(); iterator.hasNext();) {
            ElementoLista next = iterator.next();
            System.out.println(next.descricao +""+next.uri);

        }


       /* Set<ElementoEvento> lista2= new HashSet<ElementoEvento>();
        lista2 = objMashup.getListMusicEvents();
        for (Iterator<ElementoEvento> iterator = lista2.iterator(); iterator.hasNext();) {
            ElementoEvento next = iterator.next();
            System.out.println(next.musicartist.descricao +""+next.musicartist.uri);

        }*/
        return objMashup;
    }

    @RequestMapping(value="/events/range/{dateStart}/{dateEnd}/lat/{lat}/long/{lng}", method = RequestMethod.GET)
    public List<Evento> getEvents(@PathVariable("dateStart") String dateStart,
                                  @PathVariable("dateEnd") String dateEnd,
                                          @PathVariable("lat") String lat,
                                          @PathVariable("lng") String lng) throws ParseException {


        MashupMusicEvents objMashup = new MashupMusicEvents();
        List<Evento> lista2 = objMashup.getEventos();
        return lista2;
    }

}
