package br.edu.ifpr.bsi.projetologmil.dao;

import br.edu.ifpr.bsi.projetologmil.helpers.HibernateHelper;
import br.edu.ifpr.bsi.projetologmil.model.ItemLogistico;
import br.edu.ifpr.bsi.projetologmil.model.Movimentacao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDAO extends GenericDAO<Movimentacao> {

    @Override
    public Movimentacao mapearResultado(ResultSet rs) throws SQLException {
        return new Movimentacao(
                rs.getLong("id"),
                rs.getLong("id_item"),
                rs.getLong("id_unidade_origem"),
                rs.getLong("id_unidade_destino"),
                rs.getInt("quantidade"),
                rs.getDate("data")
        );
    }

    public void inserir(Movimentacao mov) {
        String sql = "INSERT INTO movimentacao (id, id_item, id_unidade_origem, id_unidade_destino, quantidade, data) VALUES (?, ?, ?, ?, ?, ?)";
        super.inserir(sql,
                mov.getId(),
                mov.getIdItem(),
                mov.getIdUnidadeOrigem(),
                mov.getIdUnidadeDestino(),
                mov.getQuantidade(),
                new java.sql.Date(mov.getData().getTime())
        );
    }

    public List<Movimentacao> listar() {
        List<Movimentacao> movimentacaos = new ArrayList<>();
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        try {
            movimentacaos = session.createQuery("FROM Movimentacao ", Movimentacao.class).list();
        } finally {
            session.close();
        }
        return movimentacaos;
    }

    public void deletar(Movimentacao movimentacao) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(movimentacao);
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


