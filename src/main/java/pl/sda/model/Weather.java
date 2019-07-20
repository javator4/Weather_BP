package pl.sda.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Weather {

    private Location location;
    private Current current;
}
