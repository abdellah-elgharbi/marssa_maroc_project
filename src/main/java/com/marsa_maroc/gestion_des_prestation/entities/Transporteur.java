package com.marsa_maroc.gestion_des_prestation.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "transporteurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transporteur {
    @Id
    @Column(name = "cin_transporteur", unique = true, nullable = false)
    private String cinTransporteur;

    @Column(name = "nom_transporteur", nullable = false)
    private String nomTransporteur;

    @Column(name = "adresse", columnDefinition = "TEXT")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;
}