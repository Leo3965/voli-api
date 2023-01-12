package med.voli.api.domain.service;

import med.voli.api.domain.data.model.Funcionario;
import med.voli.api.domain.data.enumerator.Cargo;
import med.voli.api.infra.exception.ValidacaoException;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida) {
        var cargoAtual = funcionario.getDadosPessoais().getCargo();
        if (Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerentes não podem ser promovidos");
        }

        if (metaBatida) {
            var novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionário não bateu a meta");
        }
    }
}
