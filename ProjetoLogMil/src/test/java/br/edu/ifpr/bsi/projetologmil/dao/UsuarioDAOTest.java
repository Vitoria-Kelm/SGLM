package br.edu.ifpr.bsi.projetologmil.dao;

import br.edu.ifpr.bsi.projetologmil.model.Usuario;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioDAOTest {
    @Test
    public void testInserir() {
        Usuario user = new Usuario(1L, "Maria", "maria@gmail.com", "1234");
        UsuarioDAO dao = new UsuarioDAO();
        assertDoesNotThrow(() -> dao.inserir(user));
    }

    @Test
    public void testListar() {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> lista = dao.listar();
        lista.forEach(f -> System.out.println(f.getId() + " - " + f.getNome()));
        lista.forEach(f -> System.out.println(f.getId() + " - " + f.getEmail()));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testAtualizar() {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.listar().get(0);
        usuario.setEmail("mariabiluzinha@gmail.com");
        assertDoesNotThrow(() -> dao.atualizar(usuario));
    }

    @Test
    public void testDeletar() {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.listar().get(0);
        assertDoesNotThrow(() -> dao.deletar(usuario));
    }
}