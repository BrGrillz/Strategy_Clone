package com.example.prelimbclone.db.inner.entity

import javax.persistence.*

@Entity
@Table(name = "regions")
class RegionsEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0,
    var regionCode: String = "",
    @Column(nullable = true)
    var regionCity: String = "",
    var result: Int = 0,
)