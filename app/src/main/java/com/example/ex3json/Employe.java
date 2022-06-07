package com.example.ex3json;

public class Employe {
    private String nom;
    private String matricule;
    private String genre;
    private String fonction;
    private String naissance;
    private Double salaire;

    public Employe() {
    }

    public Employe(String nom, String matricule, String genre, String fonction, String naissance, Double salaire) {
        this.nom = nom;
        this.matricule = matricule;
        this.genre = genre;
        this.fonction = fonction;
        this.naissance = naissance;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
}
