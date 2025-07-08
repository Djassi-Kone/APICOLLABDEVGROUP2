package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Contributions;
import gorupe2.apicollabdevg2.service.ContributionsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/Contributions")
public class ContributionsController {


    private final ContributionsServiceImpl contributionService;

    @PostMapping
    public ResponseEntity<Contributions> create(@RequestBody Contributions contributions) {
        return ResponseEntity.ok(contributionService.createContribution(contributions));
    }

    @GetMapping
    public List<Contributions> getAll() {
        return contributionService.getAllContributions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contributions> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contributionService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contributionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
