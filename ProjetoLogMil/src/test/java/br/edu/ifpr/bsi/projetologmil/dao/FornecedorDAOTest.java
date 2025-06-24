package br.edu.ifpr.bsi.projetologmil.dao;

import java.util.List;
import br.edu.ifpr.bsi.projetologmil.model.Fornecedor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FornecedorDAOTest {
    @Test
    public void testInserir() {
        Fornecedor forn = new Fornecedor(2L, "asa artigos militares", "165418948691981", "(41)99999-9999");
        FornecedorDAO dao = new FornecedorDAO();
        assertDoesNotThrow(() -> dao.inserir(forn));
    }
    @Test
    public void testListar() {
        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> lista = dao.listar();
        lista.forEach(f -> System.out.println(f.getId() + " - " + f.getNome()));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testAtualizar() {
        FornecedorDAO dao = new FornecedorDAO();
        Fornecedor fornecedor = dao.listar().get(1);
        fornecedor.setNome("Asas Artigos Militares");
        assertDoesNotThrow(() -> dao.atualizar(fornecedor));
    }

    @Test
    public void testDeletar() {
        FornecedorDAO dao = new FornecedorDAO();
        Fornecedor fornecedor = dao.listar().get(1);
        assertDoesNotThrow(() -> dao.deletar(fornecedor));
    }
}