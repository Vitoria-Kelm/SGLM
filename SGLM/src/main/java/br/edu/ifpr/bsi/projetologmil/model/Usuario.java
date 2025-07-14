package br.edu.ifpr.bsi.projetologmil.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED) // Or SINGLE_TABLE, TABLE_PER_CLASS
public class Usuario extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "nome_user", nullable = false)
    private String nomeUser;

    @Column(name = "posto_user", nullable = false)
    private String postoUser;

    @Column(name = "cmi_user", unique = true, nullable = false)
    private Integer cmiUser; // CMI seems like a unique identifier

    @Column(name = "senha_user", nullable = false)
    private String senhaUser;

    // Getters and Setters
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getPostoUser() {
        return postoUser;
    }

    public void setPostoUser(String postoUser) {
        this.postoUser = postoUser;
    }

    public Integer getCmiUser() {
        return cmiUser;
    }

    public void setCmiUser(Integer cmiUser) {
        this.cmiUser = cmiUser;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }
}