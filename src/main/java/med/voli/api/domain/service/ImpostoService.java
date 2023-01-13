package med.voli.api.domain.service;

import med.voli.api.domain.data.interfaces.Imposto;
import med.voli.api.domain.data.model.Orcamento;

import java.math.BigDecimal;

public class ImpostoService {
    public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
        return imposto.calcular(orcamento);
    }
}
