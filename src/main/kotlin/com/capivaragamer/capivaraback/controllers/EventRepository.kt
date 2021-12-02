package com.capivaragamer.capivaraback.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EventRepository {

    @GetMapping("/")
    fun findAll(): String = "<h1> FOFOCA EDIFICA! </h1>"
}