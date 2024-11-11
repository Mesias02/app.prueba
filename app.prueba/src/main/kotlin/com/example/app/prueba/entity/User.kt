package com.example.app.prueba.entity

import jakarta.persistence.*

@Entity
@Table(name = "user")
class User {
    lateinit var email: String

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = false)
    var age: Int = 0

}
