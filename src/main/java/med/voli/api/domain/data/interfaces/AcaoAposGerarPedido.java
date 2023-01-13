package med.voli.api.domain.data.interfaces;

import med.voli.api.domain.data.model.Pedido;

public interface AcaoAposGerarPedido {
    void executarAcao(Pedido pedido);
}
