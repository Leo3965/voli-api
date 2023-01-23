package med.voli.api.domain.service.orcamento;

import med.voli.api.domain.adapter.HttpAdapter;
import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.infra.exception.OrcamentoException;

import java.util.Map;

public class RegistroDeOrcamento {
    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) {
        if (!orcamento.isFinalizado()) {
            throw new OrcamentoException("Orcamento não finalizado");
        }
        var url = "http://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getQuantidadeItens()
        );
        http.post(url, dados);
    }
}
