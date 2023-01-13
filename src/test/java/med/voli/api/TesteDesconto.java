package med.voli.api;

import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.service.DescontoService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteDesconto {

    @Test
    void descontoDeveriaSerDeDezPorcento() {
        var orcamento = new Orcamento(new BigDecimal("200"), 6);
        var desconto = new DescontoService();
        assertEquals(new BigDecimal("20").setScale(1), desconto.calcular(orcamento).setScale(1));
    }

    @Test
    void descontoDeveriaSerDeCincoPorcento() {
        var orcamento = new Orcamento(new BigDecimal("600"), 4);
        var desconto = new DescontoService();
        assertEquals(new BigDecimal("30").setScale(1), desconto.calcular(orcamento).setScale(1));
    }

    @Test
    void descontoDeveriaSerDeZero() {
        var orcamento = new Orcamento(new BigDecimal("100"), 1);
        var desconto = new DescontoService();
        assertEquals(BigDecimal.ZERO, desconto.calcular(orcamento));
    }
}
