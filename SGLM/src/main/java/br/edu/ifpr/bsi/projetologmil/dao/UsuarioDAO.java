package br.edu.ifpr.bsi.projetologmil.dao;

import br.edu.ifpr.bsi.projetologmil.model.Usuario;
import br.edu.ifpr.bsi.projetologmil.helpers.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UsuarioDAO extends GenericDAO<Usuario> {
    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario findByCmiAndSenha(Integer cmi, String senha) {
        EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.cmiUser = :cmi AND u.senhaUser = :senha", Usuario.class);
            query.setParameter("cmi", cmi);
            query.setParameter("senha", senha);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}