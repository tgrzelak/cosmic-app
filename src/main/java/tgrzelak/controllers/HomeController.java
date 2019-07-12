package tgrzelak.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tgrzelak.extras.CreatorXLS;
import tgrzelak.models.dtos.PlanetDto;
import tgrzelak.services.PlanetService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Controller
public class HomeController {

    private PlanetService planetService;

    public HomeController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("planets", planetService.getPlanetsDto());
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "You are logged in as " + context.getAuthentication().getName());
        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/planets")
    public String planetPage(Model model) {
        model.addAttribute("planets", planetService.getPlanetsDto());
        return "planets";
    }

    @GetMapping("/delete")
    public String deletePlanet(@RequestParam(value = "planet") String planetName) {
        planetService.deletePlanet(planetName);
        return "redirect:/planets";
    }

    @PostMapping("/add-planet")
    public String addPlanet(@ModelAttribute PlanetDto planet) {
        planetService.addPlanet(planet);
        return "redirect:/planets";
    }

    @GetMapping("/excel")
    public String createFile() throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException, IOException {
        CreatorXLS<PlanetDto> creatorXLS = new CreatorXLS<>(PlanetDto.class);
        creatorXLS.createFile(planetService.getPlanetsDto(), "src/main/resources", "planets");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
