package com.g2b.projeto.controlller;

import com.g2b.projeto.model.TipoData;
import com.g2b.projeto.services.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipoData")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public TipoData createTipoData(@RequestBody TipoData tipoData){
        return tipoDataService.saveTipoData(tipoData);
    }

    @GetMapping("/{list}")
    public List<TipoData> getTipoDataList(){
        return tipoDataService.findAll();
    }

    @GetMapping("/{idTipoData}")
    public ResponseEntity<TipoData> getTipoDataByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
        return  ResponseEntity.ok(tipoDataService.getById(idTipoData).orElseThrow(() -> new NoSuchElementException("Pagina não encontrada!")));

    }

    @PutMapping
    public TipoData updateTipoData(@RequestBody TipoData tipoData){
        return tipoDataService.updateTipoData(tipoData);
    }

    @DeleteMapping("/{idTipoData}")
    public ResponseEntity<TipoData>  deleteByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
        try {
            tipoDataService.deleteTipoData(idTipoData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<TipoData>) ResponseEntity.ok();
    }
}
