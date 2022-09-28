package com.example.taskwebservice.domains;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Client client;

    @Column(nullable = false, length = 20)
    private String number;


    @Column(nullable = false)
    private BigDecimal balance;

    @Column
    @NotNull
    private boolean active;

    @CreationTimestamp
    @NotNull
    private Date date_created;

    public Account(String number, BigDecimal balance, boolean active) {
        this.number = number;
        this.balance = balance;
        this.active = active;
    }
}
