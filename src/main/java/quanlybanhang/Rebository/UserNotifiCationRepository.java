package quanlybanhang.Rebository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.UserNotifiCationEntity;

@Repository
public interface UserNotifiCationRepository extends JpaRepository<UserNotifiCationEntity, Integer>{

}
