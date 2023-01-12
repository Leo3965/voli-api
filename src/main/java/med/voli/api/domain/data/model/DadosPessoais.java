package med.voli.api.domain.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voli.api.domain.data.enumerator.Cargo;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DadosPessoais {
    private String nome;
    private String cpf;
    private Cargo cargo;
    private BigDecimal salario;
}
