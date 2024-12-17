package se.distansakademin.events_platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.distansakademin.events_platform.models.Event;
import se.distansakademin.events_platform.repositories.EventRepository;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents(){
        return repository.findAll();
    }

    public void saveEvent(Event event){
        repository.save(event);
    }
}
