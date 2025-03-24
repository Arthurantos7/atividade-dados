package com.atividade.aula2.controller;


import com.atividade.aula2.Repository.UsuarioRepository;
import com.atividade.aula2.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getId())) {
            usuarioRepository.save(usuario);
        }
        return ResponseEntity.ok().body(usuario);
    }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> excluir ( @PathVariable long id){
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    }












