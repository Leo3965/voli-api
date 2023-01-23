package med.voli.api.domain.data.model;

import lombok.Getter;
import lombok.Setter;
import med.voli.api.domain.data.interfaces.Orcavel;
import med.voli.api.domain.service.orcamento.EmAnalise;
import med.voli.api.domain.service.orcamento.Finalizado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Orcamento implements Orcavel {

    private BigDecimal valor;
    private List<Orcavel> itens;
    private SituacaoOrcamento situacao;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.itens = new ArrayList<>();
        this.situacao = new EmAnalise();
    }

    public BigDecimal getValor() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.valor;
    }

    public void aplicarDescontoExtra() {
        var valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDoDescontoExtra);
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public void adicionarItem(Orcavel item) {
        this.valor = this.valor.add(item.getValor());
        this.itens.add(item);
    }

    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovado(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

    public boolean isFinalizado() {
        return situacao instanceof Finalizado;
    }
}
