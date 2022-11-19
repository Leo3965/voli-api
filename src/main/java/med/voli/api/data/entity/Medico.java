package med.voli.api.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voli.api.data.dto.MedicoDTO;
import med.voli.api.data.enumerator.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.crm = dto.crm();
        this.especialidade = dto.especialidade();
        this.endereco = new Endereco(dto.endereco());
    }
}
