package med.voli.api.domain.data.interfaces;

import med.voli.api.domain.data.model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {
    void Validar(Funcionario funcionario, BigDecimal aumento);
}
