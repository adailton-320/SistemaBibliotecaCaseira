package sistemaBiblioteca.daoGenerico;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import sistemaBiblioteca.hibernateConexao.HibernateUtil;

public class DaoGenerico<E> {
	
	private EntityManager manager= HibernateUtil.getEntityManager();
	
	public void salvar(E entidade) {
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		manager.persist(entidade);
		transaction.commit();
		manager.close();
		
	} 
	
	public void mergeSalvaEditar(E entidade) {
		EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		manager.merge(entidade);
		transaction.commit();
	}

}
