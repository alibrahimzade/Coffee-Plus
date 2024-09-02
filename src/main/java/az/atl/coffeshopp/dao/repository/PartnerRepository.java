package az.atl.coffeshopp.dao.repository;

import az.atl.coffeshopp.dao.entity.Partners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partners,Long> {
}
