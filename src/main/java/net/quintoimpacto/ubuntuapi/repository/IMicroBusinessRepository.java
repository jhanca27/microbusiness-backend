package net.quintoimpacto.ubuntuapi.repository;

import java.util.List;
import java.util.Set;

import net.quintoimpacto.ubuntuapi.entity.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;

@Repository
public interface IMicroBusinessRepository extends JpaRepository<MicroBusiness,Long>{
    Set<MicroBusiness> findByNameContainingIgnoreCase(String name);
    List<MicroBusiness> findByCategory(Category category);
}
