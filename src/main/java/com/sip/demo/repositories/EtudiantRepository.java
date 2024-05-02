package com.sip.demo.repositories; 

import org.springframework.data.repository.CrudRepository;

import com.sip.demo.entities.Etudiant; 
 
public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> { 

    public Etudiant findByNom(String nom);

}