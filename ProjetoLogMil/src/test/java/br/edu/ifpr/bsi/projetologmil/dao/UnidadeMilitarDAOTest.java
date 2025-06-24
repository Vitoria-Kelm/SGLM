package br.edu.ifpr.bsi.projetologmil.dao;

import br.edu.ifpr.bsi.projetologmil.model.UnidadeMilitar;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UnidadeMilitarDAOTest {
    @Test
    public void testInserir() {
        UnidadeMilitar unidade = new UnidadeMilitar(0L, "2ª CIA", "Curitiba");
        UnidadeMilitarDAO dao = new UnidadeMilitarDAO();
        assertDoesNotThrow(() -> dao.inserir(unidade));
    }

    @Test
    public void testListar() {
        UnidadeMilitarDAO dao = new UnidadeMilitarDAO();
        List<UnidadeMilitar> lista = dao.listar();
        lista.forEach(f -> System.out.println(f.getId() + " - " + f.getNome()));
        lista.forEach(f -> System.out.println(f.getId() + " - " + f.getLocalizacao()));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testAtualizar() {
        UnidadeMilitarDAO dao = new UnidadeMilitarDAO();
        UnidadeMilitar unidademilitar = dao.listar().get(0);
        unidademilitar.setNome("15º de Combate Mecanizado");
        assertDoesNotThrow(() -> dao.atualizar(unidademilitar));
    }

    @Test
    public void testDeletar() {
        UnidadeMilitarDAO dao = new UnidadeMilitarDAO();
        UnidadeMilitar unidademilitar = dao.listar().get(0);
        assertDoesNotThrow(() -> dao.deletar(unidademilitar));
    }
}