package br.edu.ifpr.bsi.projetologmil.dao;

import br.edu.ifpr.bsi.projetologmil.helpers.HibernateHelper;
import br.edu.ifpr.bsi.projetologmil.model.ItemLogistico;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemLogisticoDAO extends GenericDAO<ItemLogistico> {

    @Override
    public ItemLogistico mapearResultado(ResultSet rs) throws SQLException {
        return new ItemLogistico(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("tipo"),
                rs.getInt("quantidade"),
                rs.getString("descricao")
        );
    }

    public void inserir(ItemLogistico item) {
        String sql = "INSERT INTO item_logistico (id, nome, tipo, quantidade, descricao) VALUES (?, ?, ?, ?, ?)";
        super.inserir(sql, item.getId(), item.getNome(), item.getTipo(), item.getQuantidade(), item.getDescricao());
    }

    public List<ItemLogistico> listar() {
        List<ItemLogistico> itemLogisticos = new ArrayList<>();
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        try {
            itemLogisticos = session.createQuery("FROM ItemLogistico ", ItemLogistico.class).list();
        } finally {
            session.close();
        }
        return itemLogisticos;
    }

    public void atualizar(ItemLogistico itemLogistico) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(itemLogistico);
            tx.commit();
            System.out.println("Atualizado com sucesso!");
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void deletar(ItemLogistico itemLogistico) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(itemLogistico);
            tx.commit();
            System.out.println("Deletado com sucesso!");
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}

