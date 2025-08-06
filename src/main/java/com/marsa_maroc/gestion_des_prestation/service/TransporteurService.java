package com.marsa_maroc.gestion_des_prestation.service;

import com.marsa_maroc.gestion_des_prestation.entities.Transporteur;
import com.marsa_maroc.gestion_des_prestation.exeptions.ResourceNotFoundException;
import com.marsa_maroc.gestion_des_prestation.respositories.TransporteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TransporteurService {

    private final TransporteurRepository transporteurRepository;

    @Transactional(readOnly = true)
    public List<Transporteur> getAllTransporteurs() {
        return transporteurRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Transporteur getTransporteurById(String cin) {
        return transporteurRepository.findById(cin)
                .orElseThrow(() -> new ResourceNotFoundException("Transporteur non trouvé avec le CIN: " + cin));
    }

    @Transactional(readOnly = true)
    public List<Transporteur> searchTransporteursByNom(String nomTransporteur) {
        return transporteurRepository.findByNomTransporteurContaining(nomTransporteur);
    }

    public Transporteur createTransporteur(Transporteur transporteur) {
        return transporteurRepository.save(transporteur);
    }

    public Transporteur updateTransporteur(String cin, Transporteur transporteurDetails) {
        Transporteur transporteur = getTransporteurById(cin);

        transporteur.setNomTransporteur(transporteurDetails.getNomTransporteur());
        transporteur.setAdresse(transporteurDetails.getAdresse());
        transporteur.setTelephone(transporteurDetails.getTelephone());

        return transporteurRepository.save(transporteur);
    }

    public void deleteTransporteur(String cin) {
        Transporteur transporteur = getTransporteurById(cin);
        transporteurRepository.delete(transporteur);
    }
}
