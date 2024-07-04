package net.quintoimpacto.ubuntuapi.repository;

import net.quintoimpacto.ubuntuapi.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Long> {
}
