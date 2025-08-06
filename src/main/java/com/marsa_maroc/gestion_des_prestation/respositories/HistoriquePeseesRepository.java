package com.marsa_maroc.gestion_des_prestation.respositories;



import com.marsa_maroc.gestion_des_prestation.entities.Pesees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoriquePeseesRepository extends JpaRepository<Pesees, Integer> {
    List<Pesees> findByPrestationNumeroPrestation(String numeroPrestation);
    List<Pesees> findByCamionImmatriculation(String immatriculation);
    List<Pesees> findByDateTareBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT h FROM Pesees h WHERE h.prestation.numeroPrestation = ?1 ORDER BY h.dateTare DESC")
    List<Pesees> findByPrestationOrderByDateTareDesc(String numeroPrestation);
}
