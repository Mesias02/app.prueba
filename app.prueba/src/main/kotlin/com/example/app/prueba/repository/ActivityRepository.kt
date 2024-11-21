
import com.example.app.prueba.entity.Activity
import org.springframework.data.jpa.repository.JpaRepository

interface ActivityRepository : JpaRepository<Activity?, Long?> {
    fun findByLeadId(leadId: Long?): List<Activity?>?
}