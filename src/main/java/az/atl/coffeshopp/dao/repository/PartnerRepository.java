package az.atl.coffeshopp.dao.repository;

import az.atl.coffeshopp.dao.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
    Optional<Partner> getPartnerByName(String name);

}
