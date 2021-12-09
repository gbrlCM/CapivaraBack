package com.capivaragamer.capivaraback.models.entities

import java.util.*
import javax.persistence.*

@Table(name = "address")
@Entity
class Address (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID?,
    @Column(name = "address_type")
    var type: String,
    @Column(name = "city")
    var city: String?,
    @Column(name = "code")
    var code: String?,
    @Column(name = "street")
    var street: String?,
    @Column(name = "number")
    var number: Int?
)