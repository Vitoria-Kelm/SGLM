package br.edu.ifpr.bsi.projetologmil.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "solicitacao_transporte")
public class SolTransporte extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitacao_transporte")
    private Long idSolicitacaoT;

    @Column(name = "data_solicitacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "status", nullable = false)
    private String status; // Pending, Approved, Rejected

    // Many-to-one relationship with Usuario (who made the request)
    @ManyToOne
    @JoinColumn(name = "id_usuario_solicitante", nullable = false)
    private Usuario solicitante;

    // Getters and Setters
    public Long getIdSolicitacaoT() {
        return idSolicitacaoT;
    }

    public void setIdSolicitacaoT(Long idSolicitacaoT) {
        this.idSolicitacaoT = idSolicitacaoT;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }
}