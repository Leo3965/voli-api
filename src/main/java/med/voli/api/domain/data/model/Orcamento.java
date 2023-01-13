package med.voli.api.domain.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import med.voli.api.domain.service.orcamento.EmAnalise;

import java.math.BigDecimal;

@Getter
@Setter
public class Orcamento {

    private BigDecimal valor;
    private Integer quantidadeItens;
    private SituacaoOrcamento situacao;

    public Orcamento(BigDecimal valor, Integer quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
        this.situacao = new EmAnalise();
    }

    public void aplicarDescontoExtra() {
        var valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDoDescontoExtra);
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

}
