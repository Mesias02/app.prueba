package com.example.app.prueba.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "reminder")
class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var description: String? = null

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null

    @Column(nullable = false)
    var title: String = ""

    @Column(nullable = false)
    var dateTime: LocalDateTime? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: ReminderStatus = ReminderStatus.PENDING

    enum class ReminderStatus {
        PENDING, COMPLETED, MISSED
    }
}
