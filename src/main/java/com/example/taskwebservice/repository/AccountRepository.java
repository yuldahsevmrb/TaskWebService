package com.example.taskwebservice.repository;

import com.example.taskwebservice.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, Long>{

}
