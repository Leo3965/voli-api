package med.voli.api.domain.data.interfaces;

import med.voli.api.domain.data.model.Orcamento;

import java.math.BigDecimal;

public abstract class Imposto {

    private Imposto outro;

    public Imposto(Imposto outro) {
        this.outro = outro;
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento) {
        var valorImposto = realizarCalculo(orcamento);
        var valorDoOutroImposto = BigDecimal.ZERO;

        if (outro != null) {
            valorDoOutroImposto = outro.realizarCalculo(orcamento);
        }

        return valorImposto.add(valorDoOutroImposto);
    }
}
