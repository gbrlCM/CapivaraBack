package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.User
import com.capivaragamer.capivaraback.models.repositories.UserRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController(val repository: UserRepository) {
    @GetMapping("/User")
    fun finAll():List<User>{
        return repository.findAll()
    }

}