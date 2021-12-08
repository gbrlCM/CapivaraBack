package com.capivaragamer.capivaraback.models.repositories

import com.capivaragamer.capivaraback.models.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User,UUID> {
}