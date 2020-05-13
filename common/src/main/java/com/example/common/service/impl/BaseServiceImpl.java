package com.example.common.service.impl;

import com.example.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseServiceImpl<R extends JpaRepository<T, ID>, T, ID> {

    @Autowired
    private R ownRepository;

    public <S extends T> S save(S entity) {
        return ownRepository.save(entity);
    }

    public <S extends T> List<S> saveAll(List<S> entities) {
        return ownRepository.saveAll(entities);
    }

    public Optional<T> findById(ID id) {
        return ownRepository.findById(id);
    }

    public boolean existsById(ID id) {
        return ownRepository.existsById(id);
    }

    public List<T> findAll() {
        return ownRepository.findAll();
    }

    public List<T> findAllById(List<ID> ids) {
        return ownRepository.findAllById(ids);
    }

    public long count() {
        return ownRepository.count();
    }

    public void deleteById(ID id) {
        ownRepository.deleteById(id);
    }

    public void delete(T entity) {
        ownRepository.delete(entity);
    }

    public void deleteAll(List<? extends T> entities) {
        ownRepository.deleteAll(entities);
    }

    public void deleteAll() {
        ownRepository.deleteAll();
    }

    public List<T> findAll(Sort sort) {
        return ownRepository.findAll(sort);
    }

    public Page<T> findAll(Pageable pageable) {
        return ownRepository.findAll(pageable);
    }

}
