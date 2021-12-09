package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.Game
import com.capivaragamer.capivaraback.models.repositories.GameRepository
import org.springframework.web.bind.annotation.*

@RestController
class GameController(val repository: GameRepository){

    @GetMapping("/game")
    fun finAll(): List<Game>{
        return repository.findAll()
    }

    @RequestMapping(value = ["/game/create"], method = [RequestMethod.POST])
    fun create(@RequestBody newGame: Game ): Game{
        return repository.save(newGame)
    }

}