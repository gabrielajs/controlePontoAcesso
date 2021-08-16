package com.g2b.projeto.controlller;

import com.g2b.projeto.model.Localidade;
import com.g2b.projeto.services.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade createLocalidade(@RequestBody Localidade localidade){
        return localidadeService.saveLocalidade(localidade);
    }

    @GetMapping("/{list}")
    public List<Localidade> getLocalidadeList(){
        return localidadeService.findAll();
    }

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeByID(@PathVariable("idLocalidade") Long idLocalidade) throws Exception {
        return  ResponseEntity.ok(localidadeService.getById(idLocalidade).orElseThrow(() -> new NoSuchElementException("Pagina não encontrada!")));

    }

    @PutMapping
    public Localidade updateLocalidade(@RequestBody Localidade localidade){
        return localidadeService.updateLocalidade(localidade);
    }

    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity<Localidade>  deleteByID(@PathVariable("idLocalidade") Long idLocalidade) throws Exception {
        try {
            localidadeService.deleteLocalidade(idLocalidade);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Localidade>) ResponseEntity.ok();
    }
}
