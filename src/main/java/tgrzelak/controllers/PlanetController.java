package tgrzelak.controllers;

import org.springframework.web.bind.annotation.*;
import tgrzelak.models.Planet;
import tgrzelak.models.dtos.PlanetDto;
import tgrzelak.services.PlanetService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/planets")
    public List<Planet> getPlanets() {
        return planetService.getPlanets();
    }

//    @GetMapping("/dto/planets")
//    public List<PlanetDto> getPlanetsDto() {
//        return planetService.getPlanetsDto();
//    }

    @PostMapping("/dto/planets")
    public Planet addPlanet(@RequestBody PlanetDto planetDto) {
        return planetService.addPlanet(planetDto);
    }

    @PutMapping("/dto/planets")
    public void updatePlanet(@RequestBody PlanetDto planetDto) {
        planetService.updatePlanet(planetDto);
    }

    @DeleteMapping("/dto/planet/{planetName}")
    public void deletePlanet(@PathVariable String planetName) {
        planetService.deletePlanet(planetName);
    }

    @GetMapping("/dto/planets")
    public List<PlanetDto> getPlanetsDto(@RequestParam(value = "distance", required = false) Long distance) {
        if (distance != null && distance > 0) {
            return planetService.getPlanetsByDistanceFromSun(distance);
        }
        return planetService.getPlanetsDto();
    }
}
