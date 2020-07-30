package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.SqlResultSetMapping;

import pacoteClasseHibernate.HibernateUtil;

public class DaoGenerico<E> {

	// AQUI COMEÇA OS METODOS PARA SALVAR DADOS NO BANCO DE DADOS
	private EntityManager entityManager = HibernateUtil.geEntityManager();

	public void salvar(E entidade) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();

		// AQUI TERMINA OS METODOS PARA SALVAR DADOS NO BANCO DE DADOS
	}

	
	// AQUI COMEÇA OS METODOS PARA PESQUISAR NO BANCO DE DADOS

		public E pesquisar(Long id , Class<E> entidade) {

			E e = (E) entityManager.find(entidade, id);
			return e;

			// AQUI TERMINA OS METODOS PARA PESQUISAR NO BANCO DE DADOS
		}

	  // METODO PARA REALIZAR UPDATE OU SALVAR NO BANCO DE DADOS 
	public E updateMerge(E entidade) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		
		return entidadeSalva;
		
		// FIM DO METODO PARA REALIZAR UPDATE OU SALVAR  NO BANCO DE DADOS 
	}
	
	
	// METODO PARA DELETAR DADOS DO BANCO DE DADOS
	
	
	public void deletarPoId(E entidade) {
		
	    Object id = HibernateUtil.getPrimaryKey(entidade);
	    
	    EntityTransaction transaction = entityManager.getTransaction();
	    
	    transaction.begin();
	    
	   
	    entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id = " + id).executeUpdate();
	    
	    
	    transaction.commit();
	}
	
	// FIM DO METODO PARA DELETAR DADOS DO BANCO DE DADOS
	
	
	// METODO PARA PESQUISAR TODOS
	
	
	public List<E> listar(Class<E> entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		
		transaction.commit();
		
		return lista;
		
		
	}
	
	
	// METODO PUBLICO GET DO ENTIMANAGER PARA PODER USALO DE OUTRAS CLASSES
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}










