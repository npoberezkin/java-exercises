package streamapi.domain;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class City {
    private int id;
    private String name;
    private int population;
    private String countryCode;
}