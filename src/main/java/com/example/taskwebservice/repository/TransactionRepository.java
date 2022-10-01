package com.example.taskwebservice.repository;

import com.example.taskwebservice.domains.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
