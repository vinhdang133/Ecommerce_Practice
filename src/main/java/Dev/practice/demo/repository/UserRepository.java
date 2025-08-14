package Dev.practice.demo.repository;

import Dev.practice.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

        boolean existsByUsername(String username);
}
