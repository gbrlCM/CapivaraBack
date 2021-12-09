package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.Game
import com.capivaragamer.capivaraback.models.repositories.GameRepository
import org.springframework.web.bind.annotation.*
import org.yaml.snakeyaml.events.Event

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

    @PostMapping("/game/createmany")
    fun createMany(@RequestBody newGames:List<Game>): List<Game>{
        newGames.forEach{
            repository.save(it)
        }
        return newGames
    }

    @PutMapping("/game/update")
    fun updateEvent(@RequestBody newGame: Game): Game {
        repository.save(newGame)
        return newGame;
    }

}