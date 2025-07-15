import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "activities")
class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @ManyToOne
    @JoinColumn(name = "lead_id", nullable = false)
    private val lead: Lead? = null

    @Column(nullable = false)
    private var description: String? = null

    @Column(name = "date_time", nullable = false)
    private var dateTime: LocalDateTime? = null // Getters and setters
}