package med.voli.api.domain.service.impostos;

import med.voli.api.domain.data.interfaces.Imposto;
import med.voli.api.domain.data.model.Orcamento;

import java.math.BigDecimal;

public class ICMSComISS extends Imposto {
    public ICMSComISS(Imposto outro) {
        super(outro);
    }

    @Override
    protected BigDecimal realizarCalculo(Orcamento orcamento) {
        var icms = new ICMS(null).calcular(orcamento);
        var iss = new ISS(null).calcular(orcamento);
        return icms.add(iss);
    }

}
