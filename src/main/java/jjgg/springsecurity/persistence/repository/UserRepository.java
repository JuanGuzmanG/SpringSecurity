package jjgg.springsecurity.persistence.repository;

import jjgg.springsecurity.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntitiesByUsername(String username);

/*    @Query("SELECT u FROM UserEntity u WHERE u.username = ?")
    Optional<UserEntity> findUser();*/
}
