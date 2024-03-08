package br.edu.ufape.vinculos.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufape.vinculos.business.models.Vinculo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import br.edu.ufape.vinculos.application.dto.Vinculos.VinculosRequest;
import br.edu.ufape.vinculos.application.dto.Vinculos.VinculosResponse;
import br.edu.ufape.vinculos.application.dto.Vinculos.VinculosUpdateRequest;
import br.edu.ufape.vinculos.business.facade.Facade;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/vinculos")
@RequiredArgsConstructor
public class VinculosController {

    
	private final ModelMapper modelMapper;
    private final Facade vinculos;


    

    @PostMapping
    public ResponseEntity<VinculosResponse> registerVinculo(@Valid @RequestBody VinculosRequest entity) {
        VinculosResponse response = new VinculosResponse(vinculos.registerVinculo(entity.convertToEntity()));
        return new ResponseEntity<VinculosResponse>(response, HttpStatus.CREATED);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<VinculosResponse> updateVinculo(@PathVariable Long id, @Valid @RequestBody VinculosUpdateRequest entity) {
        try{
            Vinculo vinculo = vinculos.findVinculo(id);
            modelMapper.map(entity, vinculo);
            VinculosResponse response = new VinculosResponse(vinculos.registerVinculo(vinculo));
            return new ResponseEntity<VinculosResponse>(response, HttpStatus.OK);
        } catch(RuntimeException e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<VinculosResponse>(HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<VinculosResponse> findVinculo(@PathVariable Long id) {
        try{
            Vinculo vinculo = vinculos.findVinculo(id);
            return ResponseEntity.ok(new VinculosResponse(vinculo));
        } catch (RuntimeException e) {
            return new ResponseEntity<VinculosResponse>(HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping
    public List<VinculosResponse> findAllVinculos() {
        return vinculos.findAllVinculos().stream().map(VinculosResponse::new).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVinculo(@PathVariable Long id) {
        try{
            String response = vinculos.deleteVinculo(id);
            return ResponseEntity.ok().body(response);
        } catch (RuntimeException e) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }  
    }
    
    


    
}
