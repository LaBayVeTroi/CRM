package com.example.repository.repository;

import com.example.domain.InvoiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceHistoryRepository extends JpaRepository<InvoiceHistory,Integer> {
}
