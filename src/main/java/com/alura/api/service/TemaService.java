package com.alura.api.service;

import com.alura.api.model.Tema;
import java.util.List;

public interface TemaService {
    public List<Tema> obtenerTodo();
    public Tema guardar(Tema tema);
    public Tema obtenerPorId(long id);
    public void eliminar(long id);
}
