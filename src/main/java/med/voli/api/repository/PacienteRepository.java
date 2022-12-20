package med.voli.api.repository;

import med.voli.api.domain.data.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByActiveTrue(Pageable pageable);
}
