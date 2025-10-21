package com.project.perfumes.services;

import com.project.perfumes.models.Perfume;
import com.project.perfumes.repositories.PerfumeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;

    public PerfumeService(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }
    public List<Perfume> getAll(){
        return perfumeRepository.findAll();
    }
    public Perfume getById(Long id){
        Optional<Perfume> perfume = perfumeRepository.findById(id);
        if(perfume.isEmpty()){
            throw new RuntimeException("Perfume não encotradp");
        }
        return perfume.get();
    }

    public Perfume save(Perfume perfume ) {
        return perfumeRepository.save(perfume);
    }

    public void delete(Long id){

        perfumeRepository.findById(id).orElseThrow();

        perfumeRepository.deleteById(id);
    }
    public Perfume update(Long id, Perfume perfume){
        Perfume perfumeExistente = perfumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado"));

        BeanUtils.copyProperties(perfume, perfumeExistente, "id");

        return perfumeRepository.save(perfumeExistente);
    }


}
