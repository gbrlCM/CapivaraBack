package com.capivaragamer.capivaraback.models.repositories;

import com.capivaragamer.capivaraback.models.entities.Event
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EventRepository : JpaRepository<Event, UUID> {
}