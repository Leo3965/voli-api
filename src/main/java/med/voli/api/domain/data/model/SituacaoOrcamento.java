package med.voli.api.domain.data.model;

import med.voli.api.infra.exception.OrcamentoException;

import java.math.BigDecimal;

public abstract class SituacaoOrcamento {

    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    public void aprovar(Orcamento orcamento) {
        throw new OrcamentoException("Orcamento não pode ser aprovado");
    }

    public void reprovado(Orcamento orcamento) {
        throw new OrcamentoException("Orcamento não pode ser reprovado");
    }

    public void finalizar(Orcamento orcamento) {
        throw new OrcamentoException("Orcamento não pode ser finalizado");
    }
}
