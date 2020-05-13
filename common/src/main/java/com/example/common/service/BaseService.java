package com.example.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BaseService<R extends JpaRepository<T, ID>, T, ID> {
    <S extends T> S update(S entity);

    <S extends T> S save(S entity);

    <S extends T> List<S> saveAll(List<S> entities);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    List<T> findAllById(List<ID> ids);

    long count();

    void deleteById(ID id);

    void delete(T entity);

    void deleteAll(List<? extends T> entities);

    void deleteAll();

    List<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

}
