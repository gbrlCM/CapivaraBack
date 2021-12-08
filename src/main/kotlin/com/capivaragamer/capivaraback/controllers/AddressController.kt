package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.Address
import com.capivaragamer.capivaraback.models.repositories.AdressRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AddressController(val repository: AdressRepository) {
    @GetMapping("/Address")
    fun finAll(): List<Address>{
        return repository.findAll()
    }
}