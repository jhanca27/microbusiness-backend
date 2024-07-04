package net.quintoimpacto.ubuntuapi.repository;

import net.quintoimpacto.ubuntuapi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Long> {
}
