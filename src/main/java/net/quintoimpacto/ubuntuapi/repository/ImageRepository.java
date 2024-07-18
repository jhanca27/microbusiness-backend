package net.quintoimpacto.ubuntuapi.repository;

import net.quintoimpacto.ubuntuapi.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByPublicId(String publicId);
}