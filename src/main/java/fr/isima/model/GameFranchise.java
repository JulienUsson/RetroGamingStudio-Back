package fr.isima.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class GameFranchise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Long id;

    @NotNull
    @Getter @Setter private String name;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="gameFranchise")
    @Getter @Setter private Set<Game> games = new LinkedHashSet<>();
}
