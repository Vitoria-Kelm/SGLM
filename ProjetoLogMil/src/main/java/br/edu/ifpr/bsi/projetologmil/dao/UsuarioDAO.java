package br.edu.ifpr.bsi.projetologmil.dao;

import br.edu.ifpr.bsi.projetologmil.helpers.HibernateHelper;
import br.edu.ifpr.bsi.projetologmil.model.Movimentacao;
import br.edu.ifpr.bsi.projetologmil.model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends GenericDAO<Usuario> {

    @Override
    public Usuario mapearResultado(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("senha")
        );
    }

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario (id, nome, email, senha) VALUES (?, ?, ?, ?)";
        super.inserir(sql, usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        try {
            usuarios = session.createQuery("FROM Usuario ", Usuario.class).list();
        } finally {
            session.close();
        }
        return usuarios;
    }

    public void atualizar(Usuario usuario) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(usuario);
            tx.commit();
            System.out.println("Atualizado com sucesso!");
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void deletar(Usuario usuario) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(usuario);
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
