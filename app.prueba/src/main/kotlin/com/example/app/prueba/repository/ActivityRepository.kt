package com.example.app.prueba.repository

import Activity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityRepository : JpaRepository<Activity, Long> {
    fun findByLeadId(leadId: Long): List<Activity>
}