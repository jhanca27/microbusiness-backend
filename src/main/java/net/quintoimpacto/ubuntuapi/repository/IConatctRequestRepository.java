package net.quintoimpacto.ubuntuapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.quintoimpacto.ubuntuapi.entity.ContactRequest;

@Repository
public interface IConatctRequestRepository extends JpaRepository<ContactRequest,Long> {
    List<ContactRequest> findByMicroBusinessId(Long idMicrobussiness);
    List<ContactRequest> findByStateRequestTrue();
    List<ContactRequest> findByStateRequestFalse();
}
