package com.capivaragamer.capivaraback.models.repositories;

import com.capivaragamer.capivaraback.models.entities.Event
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EventRepository : JpaRepository<Event, UUID> {


@Query("from Event e inner join fetch e.creator where e.creator.id = :id")
fun findByCreatorId(@Param("id") id: UUID): List<Event>



}