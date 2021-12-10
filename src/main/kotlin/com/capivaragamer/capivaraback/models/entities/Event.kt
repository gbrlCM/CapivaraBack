package com.capivaragamer.capivaraback.models.entities

import java.sql.Date
import java.util.*
import javax.persistence.*

@Table(name = "event")
@Entity
class Event(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    val id: UUID?,

    @ManyToOne(optional = false)
    @JoinColumn(name = "creator_id", nullable = false)
    val creator: User,

    @ManyToMany
    @JoinTable(
        name = "EVENT_USER",
        joinColumns = [JoinColumn(name = "EVENT_id")],
        inverseJoinColumns = [JoinColumn(name = "USER_id")]
    )
    var participants: MutableList<User>,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "description", nullable = false)
    var description: String,

    @Column(name = "cover_url")
    var coverUrl: String,

    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    var game: Game,

    @Column(name = "event_type", nullable = false)
    var eventType: String,

    @Column(name = "tournament_type", nullable = false)
    var eventFormat: String,

    @Column(name = "match_format", nullable = false)
    var matchFormat: String,

    @Column(name = "tournament_capacity", nullable = false)
    var tournamentCapacity: Int,

    @Column(name = "creation_date", nullable = false)
    val creationDate: Date,

    @Column(name = "date", nullable = false)
    var date: Date,

    @Column(name = "lobby_entrance_date", nullable = false)
    var lobbyEntranceDate: Date,

    @Column(name = "event_start_date", nullable = false)
    val eventStartDate: Date,

    @Column(name = "type_event", nullable = false)
    val typeEvent: String,

    @Column(name = "link_contato", nullable = false)
    val linkContato: String?,

    @Column(name = "type_stream", nullable = true)
    val typeStream: String,

    @Column(name = "link_stream", nullable = true)
    val linkStream: String,

    @Column(name = "game_plataform", nullable = false)
    val gamePlataform: String,

    @Column(name = "time_size", nullable = false)
    var timeSize: Int,

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    var address: Address
    )