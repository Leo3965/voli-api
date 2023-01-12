package med.voli.api.domain.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Terceirizado {
    private DadosPessoais dadosPessoais;
    private String empresa;
}
