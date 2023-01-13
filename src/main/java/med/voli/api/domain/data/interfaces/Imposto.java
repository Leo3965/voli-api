package med.voli.api.domain.data.interfaces;

import med.voli.api.domain.data.model.Orcamento;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
