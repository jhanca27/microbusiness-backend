package net.quintoimpacto.ubuntuapi.repository;

import net.quintoimpacto.ubuntuapi.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Long> {
    Set<Province> findByNameContainingIgnoreCase(String name);
}
