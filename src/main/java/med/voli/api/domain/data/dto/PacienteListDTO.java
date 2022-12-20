package med.voli.api.domain.data.dto;

import med.voli.api.domain.data.entity.Paciente;

public record PacienteListDTO(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone
) {
    public PacienteListDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
}
