package com.alura.api.service;

import com.alura.api.model.Tema;
import com.alura.api.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TemaServiceImplement implements TemaService{
    @Autowired
    TemaRepository temaRepository;
    @Override
    public List<Tema> obtenerTodo() {
        return temaRepository.findAll();
    }

    @Override
    public Tema guardar(Tema tema) {
        return temaRepository.save(tema);
    }

    @Override
    public Tema obtenerPorId(long id) {
        return temaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        temaRepository.deleteById(id);

    }
}
