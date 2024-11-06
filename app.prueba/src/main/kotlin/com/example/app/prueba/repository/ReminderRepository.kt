package com.example.app.prueba.repository

import com.example.app.prueba.entity.Reminder
import org.springframework.data.jpa.repository.JpaRepository

interface ReminderRepository : JpaRepository<Reminder, Long> {
    fun findByDescriptionContainingIgnoreCase(description: String): List<Reminder>?{

        return TODO("Provide the return value")
    }
}




