package com.example.common.service.impl;

import com.example.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<R extends JpaRepository<T, ID>, T, ID> {
    private  Class<?> repositoryClass;
    private  Class<?> domainClass;
    private Class<?> idClass;

    public BaseServiceImpl() {
        super();
    }

    public BaseServiceImpl(Class<?> repositoryClass, Class<?> domainClass, Class<?> idClass) {
        super();
        this.repositoryClass = repositoryClass;
        this.domainClass = domainClass;
        this.idClass = idClass;
    }


}
