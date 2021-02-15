package com.coursework.demo.repository;

import com.coursework.demo.entity.Ledger;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LedgerRepository extends PagingAndSortingRepository<Ledger, Long> {
}
