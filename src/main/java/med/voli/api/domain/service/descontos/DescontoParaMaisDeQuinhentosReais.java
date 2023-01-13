package med.voli.api.domain.service.descontos;

import med.voli.api.domain.data.model.Orcamento;

import java.math.BigDecimal;

public class DescontoParaMaisDeQuinhentosReais extends Desconto {
    public DescontoParaMaisDeQuinhentosReais(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
    }
}
