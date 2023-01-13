package med.voli.api.domain.service.orcamento;

import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.data.model.SituacaoOrcamento;

public class Reprovado extends SituacaoOrcamento {
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
