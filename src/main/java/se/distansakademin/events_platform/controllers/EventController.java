package se.distansakademin.events_platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.distansakademin.events_platform.models.Event;
import se.distansakademin.events_platform.services.EventService;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService service;


    @GetMapping("/events")
    public String getEventsHome(Model model) {
        List<Event> allEvents = service.getAllEvents();
        model.addAttribute("events", allEvents);
        return "event-list-view";
    }

    @PostMapping( "/seed-events")
    public String getSeedEvents() {
        service.seedInitialEvents();
        return "redirect:/events";
    }

    @PostMapping("/events")
    public String postSaveEvent(@ModelAttribute Event event){
        service.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/{id}")
    public String getEvent(@PathVariable Long id, Model model) {
        Event event = service.getEventById(id);
        model.addAttribute("event", event);
        return "event-detail";
    }

    @PostMapping("/events/delete")
    public String postDeleteEvent(@ModelAttribute Event event){
        service.deleteEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/update/{id}")
    public String getUpdateEvent(@PathVariable Long id, Model model) {
        Event event = service.getEventById(id);
        model.addAttribute("event", event);
        return "event-detail";
    }

    @PostMapping("/events/update")
    public String postUpdateEvent(@ModelAttribute Event event){
        service.saveEvent(event);
        return "redirect:/events";
    }


}
