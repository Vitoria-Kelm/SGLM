package br.edu.ifpr.bsi.projetologmil.bean;

import br.edu.ifpr.bsi.projetologmil.dao.UsuarioDAO;
import br.edu.ifpr.bsi.projetologmil.model.Usuario;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String cmi;
    private String senha;
    private Usuario usuarioLogado;

    @Inject
    private UsuarioDAO usuarioDAO;

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            usuarioLogado = usuarioDAO.findByCmiAndSenha(Integer.valueOf(cmi), senha);
        } catch (NumberFormatException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CMI deve ser um número válido.", null));
            return null;
        }


        if (usuarioLogado != null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login bem-sucedido!", null));
            return "/pages/index.xhtml?faces-redirect=true";
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CMI ou senha inválidos.", null));
            return null;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/pages/login.xhtml?faces-redirect=true";
    }

    public String getCmi() {
        return cmi;
    }

    public void setCmi(String cmi) {
        this.cmi = cmi;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean isLogado() {
        return usuarioLogado != null;
    }
}