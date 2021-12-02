package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Persona;

import java.util.Optional;

public interface GenericoDAO<E> {
    public Optional<E> buscarPorID(Integer id);
    public E guardar(E entidad);
    public Iterable<E>buscarTodos();
    public void eliminarPorId(Integer id);
}
