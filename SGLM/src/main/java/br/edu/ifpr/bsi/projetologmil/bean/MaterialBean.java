package br.edu.ifpr.bsi.projetologmil.bean;

import br.edu.ifpr.bsi.projetologmil.dao.MaterialDAO;
import br.edu.ifpr.bsi.projetologmil.model.Material;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
public class MaterialBean implements Serializable {

    private Material material;
    private List<Material> materials;

    @Inject
    private MaterialDAO materialDAO;

    @PostConstruct
    public void init() {
        material = new Material();
        loadMaterials();
    }

    public void loadMaterials() {
        this.materials = materialDAO.findAll();
    }

    public void saveMaterial() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (material.getId() == null) {
                materialDAO.save(material);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Material salvo com sucesso!", null));
            } else {
                materialDAO.update(material);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Material atualizado com sucesso!", null));
            }
            material = new Material();
            loadMaterials();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar material: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    public void deleteMaterial(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            materialDAO.delete(id);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Material excluído com sucesso!", null));
            loadMaterials();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir material: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    public void editMaterial(Material materialToEdit) {
        this.material = materialToEdit;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}