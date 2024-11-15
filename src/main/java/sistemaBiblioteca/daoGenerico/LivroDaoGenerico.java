package sistemaBiblioteca.daoGenerico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistemaBiblioteca.hibernateConexao.HibernateUtil;
import sistemaBiblioteca.model.Livro;

public class LivroDaoGenerico<E> extends DaoGenerico<Livro> {
	
	private EntityManager entityManager= HibernateUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	public List<Livro> pesquisar(String campoPesquisa) {
		
		Query query= entityManager.createQuery("FROM Livro s WHERE LOWER (s.titulo) LIKE LOWER (:campoPesquisa) OR LOWER (s.isbn) LIKE LOWER (:campoPesquisa)");
		query.setParameter("campoPesquisa", "%" + campoPesquisa.toLowerCase() + "%");
		
		return query.getResultList();
	}
	
	

}
