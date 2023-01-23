package med.voli.api;

import med.voli.api.domain.data.model.ItemOrcamento;
import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.service.ImpostoService;
import med.voli.api.domain.service.impostos.ICMS;
import med.voli.api.domain.service.impostos.ISS;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteImpostos {

    @Test
    void impostodeveriaSerDeDezPorCento() {
        var orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        var imposto = new ImpostoService();
        assertEquals(new BigDecimal("10").setScale(1), imposto.calcular(orcamento, new ICMS(null)).setScale(1));
    }
}
