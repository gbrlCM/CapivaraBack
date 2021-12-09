package com.capivaragamer.capivaraback.controllers

import com.capivaragamer.capivaraback.models.entities.Address
import com.capivaragamer.capivaraback.models.entities.Game
import com.capivaragamer.capivaraback.models.entities.User
import com.capivaragamer.capivaraback.models.repositories.AdressRepository
import org.springframework.web.bind.annotation.*

@RestController
class AddressController(val repository: AdressRepository) {
    @GetMapping("/address")
    fun finAll(): List<Address>{
        return repository.findAll()
    }

    @RequestMapping(value = ["/address/create"], method = [RequestMethod.POST])
    fun create(@RequestBody newAddress: Address): Address {
        return repository.save(newAddress)
    }

    @PutMapping("/address/update")
    fun updateEvent(@RequestBody newAddress: Address): Address {
        repository.save(newAddress)
        return newAddress;
    }
}