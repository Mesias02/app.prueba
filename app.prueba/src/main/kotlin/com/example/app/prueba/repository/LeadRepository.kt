package com.example.app.prueba.repository

import Lead
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LeadRepository : JpaRepository<Lead, Long> {
    // Puedes añadir métodos personalizados aquí si lo necesitas
    // Ejemplo:
    // fun findByEmail(email: String): Lead?
}
