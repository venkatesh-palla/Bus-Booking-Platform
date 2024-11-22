package com.example.bus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusCancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cancellationId")
    private String cancellationId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "busName")
    private String busName;

    @Column(name = "status")
    private String status;
}
