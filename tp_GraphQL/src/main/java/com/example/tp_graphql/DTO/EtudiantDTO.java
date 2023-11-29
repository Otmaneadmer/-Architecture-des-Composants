package com.example.tp_graphql.DTO;

import com.example.tp_graphql.enums.Genre;

public record EtudiantDTO(String nom,
                          String prenom,
                          Genre genre,
                          long centreId
                          ) { }
