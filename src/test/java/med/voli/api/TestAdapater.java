package med.voli.api;

import med.voli.api.domain.adapter.HttpAdapter;
import med.voli.api.domain.adapter.HttpClient;
import med.voli.api.domain.data.model.ItemOrcamento;
import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.service.orcamento.RegistroDeOrcamento;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TestAdapater {

    HttpAdapter adapter = new HttpClient();
    @Test
    void deveriaEnviaOrcamentoViaHttp() {
        var orcamamento = new Orcamento();
        orcamamento.adicionarItem(new ItemOrcamento(BigDecimal.TEN));
        var registro = new RegistroDeOrcamento(adapter);

        orcamamento.aprovar();
        orcamamento.finalizar();

        registro.registrar(orcamamento);
    }
}
