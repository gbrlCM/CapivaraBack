package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.Event
import com.capivaragamer.capivaraback.models.repositories.EventRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(val repository: EventRepository) {

    @GetMapping("/")
    fun findAll(): List<Event> {
        return repository.findAll()
    }
}