package tgrzelak.mappers;

import org.springframework.stereotype.Component;
import tgrzelak.commons.Mapper;
import tgrzelak.models.Planet;
import tgrzelak.models.dtos.PlanetDto;

@Component
public class PlanetMapper implements Mapper<Planet, PlanetDto> {


    @Override
    public PlanetDto map(Planet f) {
        return PlanetDto
                .builder()
                .planetName(f.getPlanetName())
                .distanceFromSun(f.getDistanceFromSun())
                .oneWayLightTimeToTheSun(f.getOneWayLightTimeToTheSun())
                .lengthOfYear(f.getLengthOfYear())
                .planetType(f.getPlanetType())
                .planetInfo(f.getPlanetInfo())
                .planetImage(f.getPlanetImage())
                .build();
    }

    @Override
    public Planet reverseMap(PlanetDto t) {
        return Planet
                .builder()
                .planetName(t.getPlanetName())
                .distanceFromSun(t.getDistanceFromSun())
                .oneWayLightTimeToTheSun(t.getOneWayLightTimeToTheSun())
                .lengthOfYear(t.getLengthOfYear())
                .planetType(t.getPlanetType())
                .planetInfo(t.getPlanetInfo())
                .planetImage(t.getPlanetImage())
                .build();
    }
}
