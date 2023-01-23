package med.voli.api;

import med.voli.api.domain.data.model.ItemOrcamento;
import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.service.DescontoService;
import med.voli.api.domain.service.orcamento.OrcamentoProxy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteDesconto {

    @Test
    void descontoDeveriaSerDeDezPorcento() {
        var orcamento = new Orcamento();
        var item = new ItemOrcamento(new BigDecimal("33.33"));

        orcamento.adicionarItem(item);
        orcamento.adicionarItem(item);
        orcamento.adicionarItem(item);
        orcamento.adicionarItem(item);
        orcamento.adicionarItem(item);
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("33.35")));

        var desconto = new DescontoService();
        assertEquals(new BigDecimal("20").setScale(1), desconto.calcular(orcamento).setScale(1));
    }

    @Test
    void descontoDeveriaSerDeCincoPorcento() {
        var orcamento = new Orcamento();
        var item = new ItemOrcamento(new BigDecimal("150"));

        orcamento.adicionarItem(item);
        orcamento.adicionarItem(item);
        orcamento.adicionarItem(item);
        orcamento.adicionarItem(item);

        var desconto = new DescontoService();
        assertEquals(new BigDecimal("30").setScale(1), desconto.calcular(orcamento).setScale(1));
    }

    @Test
    void descontoDeveriaSerDeZero() {
        var orcamento = new Orcamento();
        var item = new ItemOrcamento(new BigDecimal("150"));
        var desconto = new DescontoService();
        assertEquals(BigDecimal.ZERO, desconto.calcular(orcamento));
    }

    @Test
    void composicaoDeveriaFuncionar() {
        var antigo = new Orcamento();
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.reprovar();

        var novo = new Orcamento();
        novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        novo.adicionarItem(antigo);

        var proxy = new OrcamentoProxy(novo);

        assertEquals(new BigDecimal("700").setScale(1), proxy.getValor().setScale(1));
    }
}
