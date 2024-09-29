package sistemaBiblioteca.daoGenerico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistemaBiblioteca.hibernateConexao.HibernateUtil;
import sistemaBiblioteca.model.Solicitante;

public class SolicitanteDaoGenerico<E> extends DaoGenerico<Solicitante>{
	
	private EntityManager manager = HibernateUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	public List<Solicitante> pesquisar(String campoPesquisa) {
		
		Query query= manager.createQuery("FROM Solicitante s WHERE s.telefone LIKE :telefone ");
		
		query.setParameter("telefone", "%" + campoPesquisa + "%");
		
		return query.getResultList();
	}

}
