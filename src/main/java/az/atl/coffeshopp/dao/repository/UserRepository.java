package az.atl.coffeshopp.dao.repository;

import az.atl.coffeshopp.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> getUserEntityByPhoneNumber(String phoneNumber);
}
