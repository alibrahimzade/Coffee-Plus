package az.atl.coffeshopp.dao.repository;

import az.atl.coffeshopp.dao.entity.Feature;
import az.atl.coffeshopp.dao.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureRepository extends JpaRepository<Feature,Long> {
    Optional<Feature> getFeatureByName(String name);
}
