package med.voli.api;

import med.voli.api.domain.service.pedido.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class TestesPedidos {

    @Test
    void testeGeraPedido() {
        var geraPedido = new GeraPedido("Léo", new BigDecimal("600"), 4);
        var handler = new GeraPedidoHandler(List.of(
                new SalvarPedidoNoBancoDeDados(),
                new EnviarEmailPedido(),
                new LogDePedido()
        ));

        handler.execute(geraPedido);
    }
}
