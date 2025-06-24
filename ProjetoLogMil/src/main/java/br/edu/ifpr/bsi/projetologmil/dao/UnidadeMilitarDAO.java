package br.edu.ifpr.bsi.projetologmil.dao;

import br.edu.ifpr.bsi.projetologmil.helpers.HibernateHelper;
import br.edu.ifpr.bsi.projetologmil.model.Movimentacao;
import br.edu.ifpr.bsi.projetologmil.model.UnidadeMilitar;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnidadeMilitarDAO extends GenericDAO<UnidadeMilitar> {

    @Override
    public UnidadeMilitar mapearResultado(ResultSet rs) throws SQLException {
        return new UnidadeMilitar(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("localizacao")
        );
    }

    public void inserir(UnidadeMilitar unidademilitar) {
        String sql = "INSERT INTO unidade_militar (id, nome, localizacao) VALUES (?, ?, ?)";
        super.inserir(sql, unidademilitar.getId(), unidademilitar.getNome(), unidademilitar.getLocalizacao());
    }

    public List<UnidadeMilitar> listar() {
        List<UnidadeMilitar> unidademilitar = new ArrayList<>();
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        try {
            unidademilitar = session.createQuery("FROM UnidadeMilitar ", UnidadeMilitar.class).list();
        } finally {
            session.close();
        }
        return unidademilitar;
    }

    public void atualizar(UnidadeMilitar unidademilitar) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(unidademilitar);
            tx.commit();
            System.out.println("Atualizado com sucesso!");
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void deletar(UnidadeMilitar unidademilitar) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(unidademilitar);
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
