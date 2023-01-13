package med.voli.api.domain.service.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class GeraPedido {
    private String cliente;
    private BigDecimal valorOrcamento;
    private int quantidadeDeItens;

}
