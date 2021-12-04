package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.respositories.PabellonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO{
    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Pabellon> buscarPorID(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Pabellon guardar(Pabellon entidad) {
        return repository.save(entidad);
    }

    @Override
    public Iterable<Pabellon> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
    repository.deleteById(id);
    }
}
