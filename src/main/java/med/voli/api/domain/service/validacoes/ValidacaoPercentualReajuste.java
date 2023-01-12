package med.voli.api.domain.service.validacoes;

import med.voli.api.domain.data.model.Funcionario;
import med.voli.api.domain.data.interfaces.ValidacaoReajuste;
import med.voli.api.infra.exception.ValidacaoException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    public void Validar(Funcionario funcionario, BigDecimal aumento) {
        var salarioAtual = funcionario.getDadosPessoais().getSalario();
        var percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste não pode ser superior a 40% do salário");
        }
    }
}
