package fr.isima.request;

import lombok.Getter;
import lombok.Setter;

public class GameRequest {
    @Getter @Setter private String name;

    @Getter @Setter private String description;

    @Getter @Setter private int[] consoles;

    @Getter @Setter private Long playability;

    @Getter @Setter private Long graphics;

    @Getter @Setter private Long interest;

    @Getter @Setter private byte[] image;
}
