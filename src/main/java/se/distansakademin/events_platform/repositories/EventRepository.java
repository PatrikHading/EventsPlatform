package se.distansakademin.events_platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.distansakademin.events_platform.models.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
