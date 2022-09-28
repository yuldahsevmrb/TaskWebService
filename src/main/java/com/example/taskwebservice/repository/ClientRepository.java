package com.example.taskwebservice.repository;

import com.example.taskwebservice.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
