package tgrzelak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tgrzelak.models.Planet;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    @Query("select p from Planet p where p.planetName = ?1")
    Optional<Planet> findPlanetByPlanetName(String planetName);

    @Transactional
    @Modifying
    @Query("select p from Planet p where p.planetName = ?1")
    void deletePlanetByPlanetName(String planetName);

    @Query("select p from Planet p where p.distanceFromSun <= ?1")
    List<Planet> findPlanetsByDistanceFromSun(long distance);

}
