package br.edu.ifpr.bsi.projetologmil.dao;

import br.edu.ifpr.bsi.projetologmil.model.Material;

public class MaterialDAO extends GenericDAO<Material> {
    public MaterialDAO() {
        super(Material.class);
    }
}