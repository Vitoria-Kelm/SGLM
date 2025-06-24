package br.edu.ifpr.bsi.projetologmil.dao;

import br.edu.ifpr.bsi.projetologmil.model.ItemLogistico;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ItemLogisticoDAOTest {
    @Test
    public void testInserir() {
        ItemLogistico item = new ItemLogistico(0L, "Capacete", "Equipamento", 50, "Capacete térmico");
        ItemLogisticoDAO dao = new ItemLogisticoDAO();
        assertDoesNotThrow(() -> dao.inserir(item));
    }
    @Test
    public void testListar() {
        ItemLogisticoDAO dao = new ItemLogisticoDAO();
        List<ItemLogistico> lista = dao.listar();
        lista.forEach(f -> System.out.println(f.getId() + " - " + f.getNome()));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testAtualizar() {
        ItemLogisticoDAO dao = new ItemLogisticoDAO();
        ItemLogistico logistico = dao.listar().get(0);
        logistico.setNome("Asas Artigos Militares");
        assertDoesNotThrow(() -> dao.atualizar(logistico));
    }

    @Test
    public void testDeletar() {
        ItemLogisticoDAO dao = new ItemLogisticoDAO();
        ItemLogistico logistico = dao.listar().get(0);
        assertDoesNotThrow(() -> dao.deletar(logistico));
    }
}