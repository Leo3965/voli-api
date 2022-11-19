package med.voli.api.data.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voli.api.data.dto.EnderecoDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(EnderecoDTO dto) {
        this.logradouro = dto.logradouro();
        this.bairro = dto.bairro();
        this.cep = dto.cep();
        this.cidade = dto.cidade();
        this.uf = dto.uf();
        this.complemento = dto.complemento();
        this.numero = dto.numero();
    }

    public void update(EnderecoDTO dto) {
        if (dto.logradouro() != null) {
            this.logradouro = dto.logradouro();
        }
        if (dto.bairro() != null) {
            this.bairro = dto.bairro();
        }
        if (dto.cep() != null) {
            this.cep = dto.cep();
        }
        if (dto.uf() != null) {
            this.uf = dto.uf();
        }
        if (dto.cidade() != null) {
            this.cidade = dto.cidade();
        }
        if (dto.numero() != null) {
            this.numero = dto.numero();
        }
        if (dto.complemento() != null) {
            this.complemento = dto.complemento();
        }
    }
}
