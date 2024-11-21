import com.example.app.prueba.dto.LeadDto;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @GetMapping("/{id}")
    public ResponseEntity<LeadDto> getLeadById(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.getLeadById(id));
    }

    @GetMapping
    public ResponseEntity<List<LeadDto>> getAllLeads() {
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @PostMapping
    public ResponseEntity<LeadDto> createLead(@RequestBody LeadDto leadDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(leadService.createLead(leadDTO));
    }
}
