package med.voli.api.domain.service;

import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.service.descontos.DescontoParaMaisDeCincoItens;
import med.voli.api.domain.service.descontos.DescontoParaMaisDeQuinhentosReais;
import med.voli.api.domain.service.descontos.SemDesconto;

import java.math.BigDecimal;

public class DescontoService {
    public BigDecimal calcular(Orcamento orcamento) {
        var cadeiaDeDescontos = new DescontoParaMaisDeCincoItens(
                new DescontoParaMaisDeQuinhentosReais(
                        new SemDesconto()
                )
        );

        return cadeiaDeDescontos.calcular(orcamento);
    }
}
