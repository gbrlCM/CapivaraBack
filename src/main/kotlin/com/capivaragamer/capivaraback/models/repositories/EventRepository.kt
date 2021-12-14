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


@Query("select e from Event e left join e.participants participants where participants.id = :id or e.creator.id = :id")
fun findByCreatorId(@Param("id") id: UUID): List<Event>

fun findEventByEventType(@Param("event_type") eventType: String): List<Event>

fun findEventByGame_Id(@Param("game_id") game: UUID ): List<Event>

}