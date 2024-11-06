package com.example.app.prueba.entity

import jakarta.persistence.*

@Entity
@Table(name = "user")
class User {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = false)
    var age: Int = 0

    @Column(nullable = false)
    var emergencyContact: String? = null
}
