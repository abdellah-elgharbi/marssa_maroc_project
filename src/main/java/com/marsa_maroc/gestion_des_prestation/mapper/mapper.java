package com.marsa_maroc.gestion_des_prestation.mapper;

import com.marsa_maroc.gestion_des_prestation.dto.PeseDto;
import com.marsa_maroc.gestion_des_prestation.entities.Pesees;
import com.marsa_maroc.gestion_des_prestation.enums.TypePesage;
import com.marsa_maroc.gestion_des_prestation.service.PesageService;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class mapper {


    public Pesees fromPesseDtoToPesse(PeseDto peseDto) {

         Pesees pesees = new Pesees();
         pesees.setPrestation(peseDto.getPresation());
         pesees.setCamion(peseDto.getCamion());
         if(peseDto.getTypePesage().equals(TypePesage.TARE)){
             pesees.setDateTare(peseDto.getDateMesure());
             pesees.setPoidsTare(peseDto.getPoisMesurer());
             pesees.setHeureTare(peseDto.getHeureMesure());
         }else{
             pesees.setDateBrute(peseDto.getDateMesure());
             pesees.setPoidsBrut(peseDto.getPoisMesurer());
             pesees.setHeureBrute(peseDto.getHeureMesure());
         }
return pesees;
     }

}
