package com.example.DWA.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnance;
    private String titre;
    @ManyToOne
    @JoinColumn(name = "categorie")
    private Categorie categorie;
    @Lob
    private String image;
    private String ville;
    private String addresse;
    private String description;
    private Date dateCreation;
    @ManyToOne
    @JoinColumn(name = "utilisateur")
    private Utilisateur utilisateur;

}
