package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.Event
import com.capivaragamer.capivaraback.models.repositories.EventRepository
import org.springframework.web.bind.annotation.*

import java.util.*

@RestController
class EventController(val repository: EventRepository) {

    @GetMapping("/")
    fun findAll(): List<Event> {
        return repository.findAll()
    }

    @GetMapping("/User:{id}")
    fun findEventByUserId(@PathVariable id:UUID): List<Event>{
        return repository.findByCreatorId(id)
    }

    @RequestMapping(value = ["/Create"], method = [RequestMethod.POST])
    fun create(@RequestBody newEvent: Event): Event {
        return repository.save(newEvent)
    }
}