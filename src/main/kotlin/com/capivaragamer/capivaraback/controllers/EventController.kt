package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.Event
import com.capivaragamer.capivaraback.models.entities.User
import com.capivaragamer.capivaraback.models.repositories.EventRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.util.*

@RestController
class EventController(val repository: EventRepository) {

    @GetMapping("/event")
    fun findAll(): List<Event> {
        return repository.findAll()
    }

    @GetMapping("/event/user/{id}")
    fun findEventByUserId(@PathVariable id: UUID): List<Event>{
        return repository.findByCreatorId(id)
    }

    @PostMapping("/event/create")
    fun create(@RequestBody newEvent: Event): Event {
        return repository.save(newEvent)
    }

    @PutMapping("/event/update")
    fun updateEvent(@RequestBody newEvent: Event,): Event{
            repository.save(newEvent)
            return newEvent;
    }

    @PostMapping("/event/{id}/addparticipant")
    fun addParticipant(@RequestBody user: User, @PathVariable id:UUID): Optional<Event>  {
        var event = repository.findById(id)

        event.map {
            it.participants.add(user)
            repository.save(it)
        }

        return repository.findById(id)
    }
}

