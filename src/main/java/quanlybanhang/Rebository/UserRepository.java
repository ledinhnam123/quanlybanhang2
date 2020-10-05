package quanlybanhang.Rebository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlybanhang.Entity.UserEntity;

public interface UserRepository  extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findById(int id);
}
