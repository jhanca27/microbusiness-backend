package net.quintoimpacto.ubuntuapi.repository;

import net.quintoimpacto.ubuntuapi.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Long> {
    //@Query("SELECT p FROM Province p WHERE p.country.id=:id")
    //List<Province> getByCountryId(Long id);

    List<Province> findByCountryId(Long id);
}
