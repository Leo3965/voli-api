package med.voli.api.domain.service.pedido;

import med.voli.api.domain.data.interfaces.AcaoAposGerarPedido;
import med.voli.api.domain.data.model.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Enviando email com dados do pedido");
    }
}
