package se.distansakademin.events_platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @GetMapping("/events")
    public String getEventsHome() {
        return "events";

    }
}
