package br.edu.ifpr.bsi.projetologmil.bean;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class NavigationBean implements Serializable {


    public String goToHome() {
        return "/pages/index.xhtml?faces-redirect=true";
    }

    public String goToRegisterMaterial() {
        return "/pages/cadMaterial.xhtml?faces-redirect=true";
    }

    public String goToStock() {
        return "/pages/estoque.xhtml?faces-redirect=true";
    }

    public String goToDeliverMaterial() {
        return "/pages/entregarMat.xhtml?faces-redirect=true";
    }

    public String goToReports() {
        return "/pages/gerarRel.xhtml?faces-redirect=true";
    }

}
