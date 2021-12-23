package service;

import model.Clasz;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IClaszRepository;

import java.util.Optional;

public class ClaszService implements IClaszService {

    @Autowired
    private IClaszRepository iClaszRepository;

    @Override
    public Iterable<Clasz> findAll() {
        return iClaszRepository.findAll();
    }

    @Override
    public Optional<Clasz> findById(Long id) {
        return iClaszRepository.findById(id);
    }

    @Override
    public void save(Clasz clasz) {
        iClaszRepository.save(clasz);
    }

    @Override
    public void remove(Long id) {
        iClaszRepository.deleteById(id);
    }
}
