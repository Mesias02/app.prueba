import jakarta.persistence.*

@Entity
@Table(name = "leads")
class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Column(nullable = false)
    private var name: String? = null

    @Column(nullable = false, unique = true)
    private var email: String? = null

    @Column(nullable = false)
    private var status: String? = null

    @OneToMany(mappedBy = "lead", cascade = [CascadeType.ALL], orphanRemoval = true)
    private val activities: List<Activity>? = null // Getters and setters
}