package fr.isima.request;

import lombok.Getter;
import lombok.Setter;

public class GameRequest {
    @Getter @Setter private String name;

    @Getter @Setter private String description;

    @Getter @Setter private Integer gameFranchise;

    @Getter @Setter private int[] consoles;

    @Getter @Setter private byte[] image;
}
