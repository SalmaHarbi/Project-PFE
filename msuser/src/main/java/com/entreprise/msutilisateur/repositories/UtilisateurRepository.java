package com.entreprise.msutilisateur.repositories;

import com.entreprise.msutilisateur.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    @Query("SELECT c FROM Utilisateur c WHERE c.statut=:statut")
    List<Utilisateur> findAllUtilisateurByStatut(@Param("statut") Boolean statut);
}
