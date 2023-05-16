package com.example.Dienynas3.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="mokiniai")
@Data
@Setter
@Getter
@AllArgsConstructor

public class Mokinys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="vardas")
    private  String vardas;
    @Column(name="pavarde")
    private String pavarde;
    @Column(name="dalykas")
    private String dalykas;
    @Column(name="ivertinimas")
    private int ivertinimas;
    @Column(name="pastabos", columnDefinition = "text")
    private String pastabos;
    @Column(name="vartotojas")

    private String vartotojas;

    public Mokinys() {
    }

    public Mokinys(String vardas, String pavarde, String dalykas, int ivertinimas, String pastabos, String vartotojas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.dalykas = dalykas;
        this.ivertinimas = ivertinimas;
        this.pastabos = pastabos;
        this.vartotojas = vartotojas;
    }
}

