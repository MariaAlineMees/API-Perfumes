package com.project.perfumes.controllers;

import com.project.perfumes.models.Perfume;
import com.project.perfumes.services.PerfumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfumes")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfumeController {
    private final PerfumeService perfumeService;

    public PerfumeController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @GetMapping
    public List<Perfume> getAll(){
        return perfumeService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id){
        try {
            return ResponseEntity.ok(perfumeService.getById(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Perfume> save(@RequestBody Perfume perfume){
        return ResponseEntity.ok(perfumeService.save(perfume));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            perfumeService.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Perfume perfume){
        try {
            return ResponseEntity.ok(perfumeService.update(id, perfume));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
