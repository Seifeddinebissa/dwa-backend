package com.example.DWA.repositorys;

import com.example.DWA.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
}
