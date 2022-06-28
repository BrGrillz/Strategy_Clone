package com.example.prelimbclone.domain

import javax.persistence.*

@Entity
class Regions (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0,
    var regionCode: String = "",
    @Column(nullable = true)
    var regionCity: String = "",
    var result: Int = 0,
)