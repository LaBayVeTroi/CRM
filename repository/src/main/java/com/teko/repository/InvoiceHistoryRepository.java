package com.teko.repository;

import com.teko.domain.InvoiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceHistoryRepository extends JpaRepository<InvoiceHistory,Integer> {
}
