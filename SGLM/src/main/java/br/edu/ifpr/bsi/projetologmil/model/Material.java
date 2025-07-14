package br.edu.ifpr.bsi.projetologmil.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "material")
public class Material extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Long id;

    @Column(name = "nome_mat", nullable = false)
    private String nomeMat;

    @Column(name = "tipo_mat", nullable = false)
    private String tipoMat;

    @Column(name = "quant_mat", nullable = false)
    private Long quantMat;

    @Column(name = "descricao_mat", columnDefinition = "TEXT")
    private String descricaoMat;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMat() {
        return nomeMat;
    }

    public void setNomeMat(String nomeMat) {
        this.nomeMat = nomeMat;
    }

    public String getTipoMat() {
        return tipoMat;
    }

    public void setTipoMat(String tipoMat) {
        this.tipoMat = tipoMat;
    }

    public Long getQuantMat() {
        return quantMat;
    }

    public void setQuantMat(Long quantMat) {
        this.quantMat = quantMat;
    }

    public String getDescricaoMat() {
        return descricaoMat;
    }

    public void setDescricaoMat(String descricaoMat) {
        this.descricaoMat = descricaoMat;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", nomeMat='" + nomeMat + '\'' +
                ", tipoMat='" + tipoMat + '\'' +
                ", quantMat=" + quantMat +
                ", descricaoMat='" + descricaoMat + '\'' +
                '}';
    }
}