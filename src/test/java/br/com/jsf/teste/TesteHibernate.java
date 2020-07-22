package br.com.jsf.teste;

import org.junit.jupiter.api.Test;

import pacoteClasseHibernate.HibernateUtil;

public class TesteHibernate {

	
	@Test
	public void testeHibernateUtil() {
		
		HibernateUtil.geEntityManager();
	}

}


