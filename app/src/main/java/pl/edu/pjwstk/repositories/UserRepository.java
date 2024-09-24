package pl.edu.pjwstk.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();

    @Override
    <S extends User> S save(S entity);

    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findByUsername(String username);
    @Override
    void deleteById(Long aLong);

    @Override
    void delete(User entity);

    @Override
    List<User> findAll(Sort sort);
}
