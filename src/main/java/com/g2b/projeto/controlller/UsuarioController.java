package com.g2b.projeto.controlller;

import com.g2b.projeto.model.Usuario;
import com.g2b.projeto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping("/{list}")
    public List<Usuario> getUsuarioList(){
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        return  ResponseEntity.ok(usuarioService.getById(idUsuario).orElseThrow(() -> new NoSuchElementException("Pagina não encontrada!")));
    }

    @PutMapping
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Usuario>  deleteByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        try {
            usuarioService.deleteUsuario(idUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Usuario>) ResponseEntity.ok();
    }
}
