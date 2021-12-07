package com.capivaragamer.capivaraback.models.entities

import java.sql.Date
import java.util.*
import javax.persistence.*

@Table(name = "user_account")
@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    val id: UUID,
    @Column(name = "user_name", nullable = false)
    var userName: String,
    @Column(name = "avatar")
    var avatar: String?,
    @Column(name = "date_of_birth", nullable = false)
    var dateOfBirth: Date
)