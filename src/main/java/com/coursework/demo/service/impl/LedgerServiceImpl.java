package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Ledger;
import com.coursework.demo.repository.LedgerRepository;
import com.coursework.demo.service.LedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LedgerServiceImpl implements LedgerService {

    LedgerRepository ledgerRepository;

    @Autowired
    public LedgerServiceImpl(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }

    @Override
    public Ledger getById(Long id) {
        return ledgerRepository.findById(id).get();
    }

    @Override
    public List<Ledger> getAll(Pageable pageable) {
        return ledgerRepository.findAll(pageable).getContent();
    }

    @Override
    public Ledger update(Ledger object) {
        return ledgerRepository.save(object);
    }

    @Override
    public Ledger save(Ledger object) {
        return ledgerRepository.save(object);
    }

    @Override
    public Ledger delete(Ledger object) {
        ledgerRepository.delete(object);
        return object;
    }
}
