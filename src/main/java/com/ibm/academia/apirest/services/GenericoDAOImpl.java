package com.ibm.academia.apirest.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericoDAOImpl<E,R extends CrudRepository<E,Integer>> implements  GenericoDAO<E>{

    protected final R repository;

    public GenericoDAOImpl(R repository){
        this.repository=repository;
    }
    @Override
    @Transactional()
    public Optional<E> buscarPorID(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional()
    public E guardar(E entidad) {
        return repository.save(entidad);
    }

    @Override
    @Transactional()
    public Iterable<E> buscarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional()
    public void eliminarPorId(Integer id) {
            repository.deleteById(id);
    }
}
