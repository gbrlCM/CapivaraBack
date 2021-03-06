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
        var list = repository.findByCreatorId(id)
        return list.distinct()
    }

    @GetMapping("/event/user/{id}/current")
    fun findByCreatorIdOrderByDateAndOnlyCurrent(@PathVariable id:UUID):List<Event>{
        return repository.findByCreatorIdOrderByDateAndOnlyCurrent(id)
    }

    @PostMapping("/event/create")
    fun create(@RequestBody newEvent: Event): Event {
        return repository.save(newEvent)
    }

    @PutMapping("/event/update")
    fun updateEvent(@RequestBody newEvent: Event): Event{
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

    @GetMapping("/event/type/{tp}")
    fun findEventByType(@PathVariable tp:String): List<Event>{
        return  repository.findEventByEventType(tp)
    }

    @GetMapping("/event/game/{GameId}")
    fun findEventByGame(@PathVariable GameId:UUID): List<Event>{
        return  repository.findEventByGame_Id(GameId)
    }

}

