package med.voli.api.domain.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Pedido {
    private String cliente;
    private LocalDateTime data;
    private Orcamento orcamento;
}
