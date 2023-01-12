package med.voli.api.domain.service.validacoes;

import med.voli.api.domain.data.model.Funcionario;
import med.voli.api.infra.exception.ValidacaoException;
import med.voli.api.domain.data.interfaces.ValidacaoReajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

    public void Validar(Funcionario funcionario, BigDecimal aumento) {
        var dataUltimoreajuste = funcionario.getDataUltimoReajuste();
        var dataAtual = LocalDate.now();

        var mesesUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoreajuste, dataAtual);
        if (mesesUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser de no minimo 6 meses");
        }
    }
}
