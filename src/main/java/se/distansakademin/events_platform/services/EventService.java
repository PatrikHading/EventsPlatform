package se.distansakademin.events_platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.distansakademin.events_platform.models.Event;
import se.distansakademin.events_platform.repositories.EventRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents(){
        return repository.findAll();
    }

    public void saveEvent(Event event){
        repository.save(event);
    }
    public void deleteEvent(Event event){
        repository.delete(event);
    }
    public Event getEventById(Long id){
        return repository.findById(id).orElse(null);
    }

    public void seedInitialEvents(){


        long count = eventRepository.count();

        if(count == 0){
            List<Event> initialEvents = Arrays.asList(
                    new Event("Lucia ", "2024-12-13"),
                    new Event("Christmas", "2024-12-24"),
                    new Event("New Year", "2024-12-31")
            );
            eventRepository.saveAll(initialEvents);
        }
    }
}
