package med.voli.api;

import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.service.ImpostoService;
import med.voli.api.domain.service.impostos.ICMS;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteImpostos {

    @Test
    void impostodeveriaSerDeDezPorCento() {
        var orcamento = new Orcamento(new BigDecimal("100"), 1);
        var imposto = new ImpostoService();
        assertEquals(new BigDecimal("10").setScale(1), imposto.calcular(orcamento, new ICMS()).setScale(1));
    }
}
