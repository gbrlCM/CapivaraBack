package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.Game
import com.capivaragamer.capivaraback.models.repositories.GameRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(val repository: GameRepository){

    @GetMapping("/Game")
    fun finAll(): List<Game>{
        return repository.findAll()
    }
}