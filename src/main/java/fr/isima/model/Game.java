package fr.isima.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Antraxxx on 27/03/2017.
 */

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "GAME_FRANCHISE_ID")
    @JsonIgnore
    @Getter @Setter private  GameFranchise gameFranchise;

    @NotNull
    @Getter @Setter private String name;

    @NotNull
    @Getter @Setter private Long playability;

    @NotNull
    @Getter @Setter private Long Graphics;

    @NotNull
    @Getter @Setter private Long interest;
}
