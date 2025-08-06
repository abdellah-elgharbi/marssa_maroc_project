package com.marsa_maroc.gestion_des_prestation.respositories;



import com.marsa_maroc.gestion_des_prestation.entities.Transporteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransporteurRepository extends JpaRepository<Transporteur, String> {
    @Query("SELECT t FROM Transporteur t WHERE t.nomTransporteur LIKE %?1%")
    List<Transporteur> findByNomTransporteurContaining(String nomTransporteur);
}