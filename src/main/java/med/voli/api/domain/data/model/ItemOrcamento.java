package med.voli.api.domain.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import med.voli.api.domain.data.interfaces.Orcavel;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ItemOrcamento implements Orcavel {
    private BigDecimal valor;


}
