package med.voli.api.domain.data.model;

import med.voli.api.domain.data.interfaces.Reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Anuenio implements Reajuste {
    private BigDecimal valor;
    private LocalDate data;

    public Anuenio(BigDecimal valor) {
        this.valor = valor;
        this.data = LocalDate.now();
    }

    @Override
    public BigDecimal valor() {
        return this.valor;
    }

    @Override
    public LocalDate data() {
        return this.data;
    }

}
