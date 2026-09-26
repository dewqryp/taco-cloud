package org.dewqryp.tacocloud.controllers;

import org.dewqryp.tacocloud.data.Taco;
import org.dewqryp.tacocloud.data.TacoOrder;
import org.dewqryp.tacocloud.repositories.TacoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoController {

    private final TacoRepository tacoRepository;

    public TacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(params = "recent")
    public List<Taco> recentTacos() {
        PageRequest page = PageRequest.of(0, 10, Sort.by("createdAt").descending());
        return tacoRepository.findAll(page).getContent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Taco> getTacoById(@PathVariable("id") long id) {
        Optional<Taco> taco = tacoRepository.findById(id);
        if (taco.isPresent()) {
            return new ResponseEntity<>(taco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Taco> createTaco(@RequestBody Taco taco) {
        return new ResponseEntity<>(tacoRepository.save(taco), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTacoById(@PathVariable long id) {
        tacoRepository.deleteById(id);
    }
}
