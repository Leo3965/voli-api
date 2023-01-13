package med.voli.api.domain.service.impostos;

import med.voli.api.domain.data.interfaces.Imposto;
import med.voli.api.domain.data.model.Orcamento;

import java.math.BigDecimal;

public class ICMS implements Imposto {
    public BigDecimal calcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
}
