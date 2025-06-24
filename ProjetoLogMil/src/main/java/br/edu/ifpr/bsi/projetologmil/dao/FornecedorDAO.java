package br.edu.ifpr.bsi.projetologmil.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.ifpr.bsi.projetologmil.helpers.HibernateHelper;
import br.edu.ifpr.bsi.projetologmil.model.Fornecedor;


public class FornecedorDAO extends GenericDAO<Fornecedor> {

    @Override
    public Fornecedor mapearResultado(ResultSet rs) throws SQLException {
        return new Fornecedor(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("cnpj"),
                rs.getString("telefone")
        );
    }

    public void inserir(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (id, nome, cnpj, telefone) VALUES (?, ?, ?, ?)";
        super.inserir(sql, fornecedor.getId(), fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getTelefone());
    }

    public List<Fornecedor> listar() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        try {
            fornecedores = session.createQuery("FROM Fornecedor", Fornecedor.class).list();
        } finally {
            session.close();
        }
        return fornecedores;
    }

    public void atualizar(Fornecedor fornecedor) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(fornecedor);
            tx.commit();
            System.out.println("Atualizado com sucesso!");
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void deletar(Fornecedor fornecedor) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(fornecedor);
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
