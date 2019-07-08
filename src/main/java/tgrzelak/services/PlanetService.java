package tgrzelak.services;

import org.springframework.stereotype.Service;
import tgrzelak.mappers.PlanetMapper;
import tgrzelak.models.Planet;
import tgrzelak.models.dtos.PlanetDto;
import tgrzelak.repositories.PlanetRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    private PlanetRepository planetRepository;
    private PlanetMapper planetMapper;

    public PlanetService(PlanetRepository planetRepository, PlanetMapper planetMapper) {
        this.planetRepository = planetRepository;
        this.planetMapper = planetMapper;
    }

    public List<Planet> getPlanets() {
        return planetRepository.findAll();
    }

    public List<PlanetDto> getPlanetsByDistanceFromSun(long distance) {
        return planetRepository.findPlanetsByDistanceFromSun(distance)
                .stream()
                .map(planetMapper::map)
                .collect(Collectors.toList());
    }

    public List<PlanetDto> getPlanetsDto() {
        return planetRepository
                .findAll()
                .stream()
                .map(planetMapper::map)
                .collect(Collectors.toList());
    }

    public Planet addPlanet(PlanetDto planetDto) {
        return planetRepository.save(planetMapper.reverseMap(planetDto));
    }

    public void updatePlanet(PlanetDto planetDto) {
        planetRepository
                .findPlanetByPlanetName(planetDto.getPlanetName())
                .ifPresent(p -> {
                    p.setDistanceFromSun(planetDto.getDistanceFromSun());
                    p.setOneWayLightTimeToTheSun(planetDto.getOneWayLightTimeToTheSun());
                    p.setLengthOfYear(planetDto.getLengthOfYear());
                    p.setPlanetType(planetDto.getPlanetType());
                    p.setPlanetImage(planetDto.getPlanetImage());
                    p.setPlanetInfo(planetDto.getPlanetInfo());
                    p.setPlanetName(planetDto.getPlanetName());

                    planetRepository.save(p);
                });
    }

    public void deletePlanet(String planetName) {
        planetRepository.deletePlanetByPlanetName(planetName);
    }
}
