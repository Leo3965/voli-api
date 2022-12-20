package med.voli.api.domain.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voli.api.domain.data.dto.PacienteDTO;
import med.voli.api.domain.data.dto.PacienteUpdateDTO;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    @Embedded
    private Endereco endereco;
    private Boolean active;

    public Paciente(PacienteDTO dto) {
        this.active = true;
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.cpf = dto.cpf();
        this.endereco = new Endereco(dto.endereco());
    }

    public void deactive() {
        this.active = false;
    }

    public void update(PacienteUpdateDTO dto) {
        if (dto.nome() != null)
            this.nome = dto.nome();

        if (dto.telefone() != null)
            this.telefone = dto.telefone();

        if (dto.endereco() != null)
            endereco.update(dto.endereco());
    }
}
