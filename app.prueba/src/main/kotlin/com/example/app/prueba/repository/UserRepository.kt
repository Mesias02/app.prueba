package com.example.app.prueba.repository

import com.example.app.prueba.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface UserRepository : JpaRepository<User?, Long?> {
    // Método personalizado para buscar un usuario por su nombre
    fun findByName(name: String?): Optional<User?>?
}
