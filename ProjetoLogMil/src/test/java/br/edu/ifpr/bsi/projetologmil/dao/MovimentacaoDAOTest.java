package br.edu.ifpr.bsi.projetologmil.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.bsi.projetologmil.model.Movimentacao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class MovimentacaoDAOTest {

    @Test
    public void testInserir() {
        Date data = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Movimentacao mov = new Movimentacao(0L, 1L, 1L, 2L, 10, data);
        MovimentacaoDAO dao = new MovimentacaoDAO();
        assertDoesNotThrow(() -> dao.inserir(mov));
    }

    @Test
    public void testListar() {
        MovimentacaoDAO dao = new MovimentacaoDAO();
        List<Movimentacao> lista = dao.listar();
        lista.forEach(f -> System.out.println(f.getId() + " - " + f.getIdUnidadeDestino()));
        lista.forEach(f -> System.out.println(f.getId() + " - " + f.getIdUnidadeOrigem()));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testDeletar() {
        MovimentacaoDAO dao = new MovimentacaoDAO();
        Movimentacao movimentacao = dao.listar().get(0);
        assertDoesNotThrow(() -> dao.deletar(movimentacao));
    }
}
