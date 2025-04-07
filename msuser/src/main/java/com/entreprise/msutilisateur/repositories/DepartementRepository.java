package com.entreprise.msutilisateur.repositories;

import com.entreprise.msutilisateur.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {

}
