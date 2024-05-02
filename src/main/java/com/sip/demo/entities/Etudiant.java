package com.sip.demo.entities; 
import jakarta.persistence.*; 

@Entity 
@Table(name = "etudiants") 
public class Etudiant { 
	    @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    private Integer id; 

	    @Column(length = 64, unique = true, nullable = false) 
	    private String nom; 

	    private Integer age; 

	    public Etudiant(String nom, Integer age) { 

	        this.nom = nom; 

	        this.age = age; 

	    } 

	    public Etudiant() { 

	    }  
	  

	    @Override 

	    public String toString() { 

	        return "Etudiant [id=" + id + ", nom=" + nom + ", age=" + age + "]"; 

	    } 

	 

	public Integer getId() { 

	return id; 

	} 

	 

	public void setId(Integer id) { 

	this.id = id; 

	} 

	 

	public String getNom() { 

	return nom; 

	} 

	 

	public void setNom(String nom) { 

	this.nom = nom; 

	} 

	 

	public Integer getAge() { 

	return age; 

	} 

	 

	public void setAge(Integer age) { 

	this.age = age; 

	}  

	}
