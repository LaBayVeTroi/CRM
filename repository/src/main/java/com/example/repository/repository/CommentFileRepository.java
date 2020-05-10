package com.example.repository.repository;

import com.example.domain.CommentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentFileRepository extends JpaRepository<CommentFile,Integer> {
}
