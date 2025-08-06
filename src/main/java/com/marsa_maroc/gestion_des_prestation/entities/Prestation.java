package com.marsa_maroc.gestion_des_prestation.entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marsa_maroc.gestion_des_prestation.enums.Statut;
import com.marsa_maroc.gestion_des_prestation.enums.TypeOperation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "prestations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prestation {
    @Id
    @Column(name = "numero_prestation", unique = true, nullable = false)
    private String numeroPrestation;

    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "navire_id", nullable = false)
    private Navire navire;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false)
    private Statut statut;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_operation", nullable = false)
    private TypeOperation typeOperation;

    @Column(name = "poids_declare", precision = 12, scale = 3)
    private BigDecimal poidsDeclare;

    @Column(name = "date_arrivee")
    private LocalDate dateArrivee;

    @Column(name = "date_depart")
    private LocalDate dateDepart;

    @Column(name = "bulletin_prestation")
    private String bulletinPrestation;

    @Column(name = "type_marchandise")
    private String typeMarchandise;

    @Column(name = "connaissement")
    private String connaissement;
}