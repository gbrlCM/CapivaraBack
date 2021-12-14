package com.capivaragamer.capivaraback.models.repositories

import com.capivaragamer.capivaraback.models.entities.Event
import com.capivaragamer.capivaraback.models.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface UserRepository: JpaRepository<User,UUID> {

    @Transactional
    @Modifying
    @Query("delete from Event e where e.creator.id = :id")
    fun deleteEventByUserId(@Param("id") id: UUID)
}