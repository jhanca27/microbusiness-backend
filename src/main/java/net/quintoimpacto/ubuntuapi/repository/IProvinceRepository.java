package net.quintoimpacto.ubuntuapi.repository;

import net.quintoimpacto.ubuntuapi.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProvinceRepository extends JpaRepository<Province, Long> {
    List<Province> findByNameContainingIgnoreCase(String name);
    List<Province> findByCountryId(Long countryId);
}