package com.sip.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;

import com.sip.demo.entities.Etudiant;

import com.sip.demo.repositories.EtudiantRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class TestDemoDataController {

	@Autowired
	private EtudiantRepository repo;

	@Test
	@Rollback(false)
	@Order(1)
	public void testCreateEtudiant() {

		Etudiant savedEtudiant = repo.save(new Etudiant("Olivia", 23));

		assertThat(savedEtudiant.getId()).isGreaterThan(0);
		assertThat(savedEtudiant.getNom()).isEqualTo("Olivia");

	}

	@Test
	@Order(2)
	public void testFindEtudiantByNom() {
		Etudiant etudiant = repo.findByNom("Olivia");
		assertThat(etudiant.getNom()).isEqualTo("Olivia");
	}

	@Test
	@Order(3)
	public void testListEtudiants() {
		List<Etudiant> etudiants = (List<Etudiant>) repo.findAll();
		assertThat(etudiants).size().isGreaterThan(0);
	}

	@Test
	@Rollback(true)
	@Order(4)
	public void testUpdateEtudiant() {
		Etudiant etudiant = repo.findByNom("Olivia");
		etudiant.setAge(24);

		repo.save(etudiant);

		Etudiant updatedEtudiant = repo.findByNom("Olivia");

		assertThat(updatedEtudiant.getAge()).isEqualTo(24);

	}

	@Test
	@Rollback(false)
	@Order(5)
	public void testDeleteEtudiant() {

		Etudiant etudiant = repo.findByNom("Olivia");

		repo.deleteById(etudiant.getId());

		Etudiant deletedEtudiant = repo.findByNom("Olivia");

		assertThat(deletedEtudiant).isNull();

	}

}