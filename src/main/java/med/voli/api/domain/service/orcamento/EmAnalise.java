package med.voli.api.domain.service.orcamento;

import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.data.model.SituacaoOrcamento;

import java.math.BigDecimal;

public class EmAnalise extends SituacaoOrcamento {
    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public void aprovar(Orcamento orcamento) {
        orcamento.setSituacao(new Aprovado());
    }

    @Override
    public void reprovado(Orcamento orcamento) {
        orcamento.setSituacao(new Reprovado());
    }
}
