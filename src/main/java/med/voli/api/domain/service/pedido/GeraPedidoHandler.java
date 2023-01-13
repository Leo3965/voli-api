package med.voli.api.domain.service.pedido;

import med.voli.api.domain.data.interfaces.AcaoAposGerarPedido;
import med.voli.api.domain.data.model.Orcamento;
import med.voli.api.domain.data.model.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public class GeraPedidoHandler {
    private List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void execute(GeraPedido dados) {
        var orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeDeItens());
        var pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

        acoes.forEach(a -> a.executarAcao(pedido));
    }
}
