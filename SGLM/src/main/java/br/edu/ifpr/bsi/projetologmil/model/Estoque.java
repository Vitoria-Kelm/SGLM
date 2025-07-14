package br.edu.ifpr.bsi.projetologmil.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estoque")
public class Estoque extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Long idEstoque;

    @Column(name = "localizacao", nullable = false)
    private String localizacao;

    public Long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}