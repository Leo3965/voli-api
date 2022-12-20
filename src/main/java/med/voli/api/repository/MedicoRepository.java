package med.voli.api.repository;

import med.voli.api.domain.data.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByActiveTrue(Pageable pageable);
}
