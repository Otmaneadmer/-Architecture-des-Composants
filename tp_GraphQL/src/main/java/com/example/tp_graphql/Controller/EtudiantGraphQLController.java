package com.example.tp_graphql.Controller;

import com.example.tp_graphql.DTO.EtudiantDTO;
import com.example.tp_graphql.Model.Centre;
import com.example.tp_graphql.Model.Etudiant;
import com.example.tp_graphql.Repository.CentreRepository;
import com.example.tp_graphql.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EtudiantGraphQLController {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    CentreRepository centreRepository;


    @QueryMapping
    private List<Etudiant> ListEtudiants(){
        return etudiantRepository.findAll();
    }
    @QueryMapping
    private Etudiant GetEtudiantById(@Argument Long id){
        return etudiantRepository.findById(id).orElseThrow(()
                ->new RuntimeException(String.format("err"))
        );
    }
    @MutationMapping
    public Etudiant AddEtudiant(@Argument EtudiantDTO etudiantDTO){
        Centre centre=centreRepository.findById(etudiantDTO.centreId()).orElse(null);
        Etudiant et=new Etudiant();
        et.setNom(etudiantDTO.nom());
        et.setPrenom(etudiantDTO.prenom());
        et.setGenre(etudiantDTO.genre());
        et.setCentre(centre);
        return etudiantRepository.save(et);
    }


}
