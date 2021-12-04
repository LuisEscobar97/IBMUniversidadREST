package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.respositories.AulaRepository;
import com.ibm.academia.apirest.respositories.CarreraRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO{

    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Aula> findAulaByPizarron(Pizarron pizarron) {
        return repository.findAulaByPizarron(pizarron);
    }

    @Override
    public Optional<Aula> buscarPorID(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Aula guardar(Aula entidad) {
        return repository.save(entidad);
    }

    @Override
    public Iterable<Aula> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }
}
