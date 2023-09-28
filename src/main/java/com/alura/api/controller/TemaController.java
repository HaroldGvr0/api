package com.alura.api.controller;

import com.alura.api.model.Tema;
import com.alura.api.service.TemaServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TemaController {
    @Autowired
    TemaServiceImplement temaservicio;
    @GetMapping("/temas")
    public List<Tema> obetenerTema(){
    return temaservicio.obtenerTodo();
    }
    @PostMapping("/guardar")
    public ResponseEntity<Tema> guardarTema(@RequestBody Tema tema){
        Tema nuevo_tema = temaservicio.guardar(tema);
        return new ResponseEntity<>(nuevo_tema, HttpStatus.CREATED);
    }
    @GetMapping("/tema/{id}")
    public ResponseEntity<Tema> obtenerTemaId(@PathVariable long id){
        Tema temaPorId = temaservicio.obtenerPorId(id);
        return ResponseEntity.ok(temaPorId);
    }
    @PutMapping("/tema/{id}")
    public ResponseEntity<Tema> actualizar(@PathVariable long id, @RequestBody Tema tema){
        Tema temaPorId = temaservicio.obtenerPorId(id);
        temaPorId.setNombre(tema.getNombre());
        temaPorId.setDescripcion(tema.getDescripcion());

        Tema tema_actualizado = temaservicio.guardar(temaPorId);
        return new ResponseEntity<>(tema_actualizado, HttpStatus.CREATED);
    }
    @DeleteMapping("/tema/{id}")
    public ResponseEntity<HashMap<String, Boolean>> elimar (@PathVariable long id ){
        this.temaservicio.eliminar(id);

        HashMap<String, Boolean> estadoTemaEliminado = new HashMap<>();
        estadoTemaEliminado.put("Eliminado", true);

        return ResponseEntity.ok(estadoTemaEliminado);

    }
}
