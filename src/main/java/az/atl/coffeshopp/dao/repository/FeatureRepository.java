package az.atl.coffeshopp.dao.repository;

import az.atl.coffeshopp.dao.entity.Features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Features,Long> {
}
