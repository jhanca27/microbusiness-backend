package net.quintoimpacto.ubuntuapi.repository;

import net.quintoimpacto.ubuntuapi.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> findAllByDeletedFalse();
    User findByEmail(String email);
}
