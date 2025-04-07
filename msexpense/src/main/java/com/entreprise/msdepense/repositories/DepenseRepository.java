package com.entreprise.msdepense.repositories;

import com.entreprise.msdepense.entities.Depense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepenseRepository extends JpaRepository<Depense,Long> {

    @Query("SELECT c FROM Depense c WHERE c.statut=:statut")
    List<Depense> findAllDepenseByStatut(@Param("statut") Boolean statut);

}
