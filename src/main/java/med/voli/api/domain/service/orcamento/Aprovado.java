package med.voli.api.domain.service.orcamento;

import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.data.model.SituacaoOrcamento;
import med.voli.api.infra.exception.OrcamentoException;

import java.math.BigDecimal;

public class Aprovado extends SituacaoOrcamento {
    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.02"));
    }

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }

}
