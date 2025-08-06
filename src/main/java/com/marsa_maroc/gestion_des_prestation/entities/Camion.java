package com.marsa_maroc.gestion_des_prestation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "camions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camion {
    @Id
    @Column(name = "immatriculation", unique = true, nullable = false)
    private String immatriculation;

    @ManyToOne
    @JoinColumn(name = "cin_transporteur", nullable = false, referencedColumnName = "cin_Transporteur")
    private Transporteur transporteur;
}
