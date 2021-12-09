package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.Event
import com.capivaragamer.capivaraback.models.entities.Game
import com.capivaragamer.capivaraback.models.entities.User
import com.capivaragamer.capivaraback.models.repositories.UserRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class UserController(val repository: UserRepository) {
    @GetMapping("/user")
    fun finAll():List<User>{
        return repository.findAll()
    }

    @RequestMapping(value = ["/user/create"], method = [RequestMethod.POST])
    fun create(@RequestBody newUser: User): User {
        return repository.save(newUser)
    }

    @PutMapping("/user/update")
    fun updateEvent(@RequestBody newUser: User): User {
        repository.save(newUser)
        return newUser;
    }

}