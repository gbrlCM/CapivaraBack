package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.User
import com.capivaragamer.capivaraback.models.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
        repository.save(newUser)
        return repository.findByAppleId(newUser.appleId)
    }

    @PutMapping("/user/update")
    fun updateEvent(@RequestBody newUser: User): User {
        repository.save(newUser)
        return newUser;
    }

    @GetMapping("/user/login")
    fun loginUser(@RequestBody user: User): User{

        return user
    }

    @DeleteMapping("/user/{id}/delete")
    fun deleteUser(@PathVariable id: UUID): ResponseEntity<User>{
        var user = repository.findById(id)
        return if(user.isPresent){
            repository.deleteEventByUserId(id)
            repository.deleteById(id)
            ResponseEntity<User>(HttpStatus.OK)
        } else{
            ResponseEntity<User>(HttpStatus.NOT_FOUND)
        }

    }

    @GetMapping("/user/AppleId/{AppleId}")
    fun getByAppleID(@PathVariable AppleId:String): User {
        return repository.findByAppleId(AppleId)
    }
}