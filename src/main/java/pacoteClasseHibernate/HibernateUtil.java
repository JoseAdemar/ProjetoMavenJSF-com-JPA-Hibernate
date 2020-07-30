package pacoteClasseHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	public static EntityManagerFactory factory = null;

	static {

		init();
	}

	private static void init() {

		try {

			if (factory == null) {

				factory = Persistence.createEntityManagerFactory("ProjetoMavenJSF");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManager geEntityManager() { // PROVER A PARTE DE PERSISTÊNCIA
		return factory.createEntityManager();

	}

	public static Object getPrimaryKey(Object entity) {   // RETORNA A CHAVE PRIMARIA
		return factory.getPersistenceUnitUtil().getIdentifier(entity);

	}

}
