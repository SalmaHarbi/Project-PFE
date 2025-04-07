package com.entreprise.msnotedefrais.repositories;

import com.entreprise.msnotedefrais.entities.Enum.Statut;
import com.entreprise.msnotedefrais.entities.NoteDeFrais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDeFraisRepository extends JpaRepository<NoteDeFrais,Long> {

    @Query("SELECT c FROM NoteDeFrais c WHERE c.statutDisable=:statutDisable")
    List<NoteDeFrais> findAllNoteDeFraisByStatut(@Param("statutDisable") Boolean statutDisable);


}
