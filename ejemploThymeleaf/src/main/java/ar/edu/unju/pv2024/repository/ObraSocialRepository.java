package ar.edu.unju.pv2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.pv2024.model.ObraSocial;

@Repository
public interface ObraSocialRepository extends JpaRepository<ObraSocial, Integer> {

}
