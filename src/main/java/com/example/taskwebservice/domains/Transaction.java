package com.example.taskwebservice.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 20)
    private String number;

    @Column(nullable = false)
    private BigDecimal amount;


    @CreationTimestamp
    @NotNull
    private Date date_created;

    public Transaction(String number, BigDecimal amount) {
        this.number = number;
        this.amount = amount;

    }
}
