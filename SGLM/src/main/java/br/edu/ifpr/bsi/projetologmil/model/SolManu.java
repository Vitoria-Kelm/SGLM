package br.edu.ifpr.bsi.projetologmil.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "solicitacao_manutencao")
public class SolManu extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitacao_manu")
    private Long idSolicitacaoM;

    @Column(name = "data_solicitacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "status", nullable = false)
    private String status; // Pending, Approved, Rejected

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    // Many-to-one relationship with Usuario (who made the request)
    @ManyToOne
    @JoinColumn(name = "id_usuario_solicitante", nullable = false)
    private Usuario solicitante;

    // Many-to-one relationship with Material (which material needs maintenance)
    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;

    // Getters and Setters
    public Long getIdSolicitacaoM() {
        return idSolicitacaoM;
    }

    public void setIdSolicitacaoM(Long idSolicitacaoM) {
        this.idSolicitacaoM = idSolicitacaoM;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}