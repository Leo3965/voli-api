package med.voli.api.domain.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voli.api.domain.data.enumerator.Cargo;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Funcionario {
    private DadosPessoais dadosPessoais;
    private LocalDate dataUltimoReajuste;

    public void atualizarSalario(BigDecimal salarioReajustado) {
        this.dadosPessoais.setSalario(salarioReajustado);
        this.dataUltimoReajuste = LocalDate.now();
    }

    public void promover(Cargo novoCargo) {
        this.dadosPessoais.setCargo(novoCargo);
    }
}
