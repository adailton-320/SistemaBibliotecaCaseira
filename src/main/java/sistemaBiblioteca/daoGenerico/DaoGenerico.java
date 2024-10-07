package sistemaBiblioteca.daoGenerico;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import antlr.collections.List;
import sistemaBiblioteca.hibernateConexao.HibernateUtil;

public class DaoGenerico<E>{

	private EntityManager manager = HibernateUtil.getEntityManager();

	public void salvar(E entidade) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entidade);
		transaction.commit();
		

	}

	public E mergeSalvaEditar(E entidade) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		E entidadeSalva = manager.merge(entidade);
		transaction.commit();

		return entidadeSalva;

	}

	public E pesquisar(E entidade) {

		Object buscaId = HibernateUtil.getPrimaryKey(entidade);
		E entidadeId = (E) manager.find(entidade.getClass(), buscaId);

		return entidadeId;

	}
	
	public E pesquisar(Long id, Class<E> entidade) {
		E entidadeId = (E) manager.find(entidade, id);

		return entidadeId;

	}
	
	public java.util.List<E> listar(Class<E> entidade){
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		
		java.util.List<E> lista= manager.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();
		
		return lista;
		
	}

	public void deletarId(E entidade) {

		Object buscaId = HibernateUtil.getPrimaryKey(entidade);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.createNativeQuery(
				"delete from " + entidade.getClass().getSimpleName().toLowerCase() + 
				" where id =" + buscaId).executeUpdate();
		transaction.commit();

	}

}
