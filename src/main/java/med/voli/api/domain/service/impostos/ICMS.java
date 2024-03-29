package med.voli.api.domain.service.impostos;

import med.voli.api.domain.data.interfaces.Imposto;
import med.voli.api.domain.data.model.Orcamento;

import java.math.BigDecimal;

public class ICMS extends Imposto {
    public ICMS(Imposto outro) {
        super(outro);
    }

    @Override
    protected BigDecimal realizarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

}
