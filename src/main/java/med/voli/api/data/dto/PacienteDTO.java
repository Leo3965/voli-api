package med.voli.api.data.dto;

public record PacienteDTO(
        String nome,
        String email,
        String telefone,
        String cpf,
        EnderecoDTO endereco
) {
}
