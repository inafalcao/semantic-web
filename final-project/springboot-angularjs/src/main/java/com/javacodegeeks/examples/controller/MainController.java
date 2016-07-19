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
