package com.capivaragamer.capivaraback.models.entities

import java.util.*
import javax.persistence.*

@Table(name = "game")
@Entity
class Game(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", updatable = false, unique = true, nullable = false)
        val id: UUID,
        @Column(name = "name", nullable = false, unique = true)
        var name: String,
        @Column(name = "team_capacity", nullable = false)
        var teamCapacity: Int,
        @Column(name = "icon")
        var icon: String?,
        @Column(name = "cover")
        open var cover: String?
)