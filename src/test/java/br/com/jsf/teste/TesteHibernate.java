package br.com.jsf.teste;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.DaoGenerico;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() { // METODO PARA SALVAR OS DADOS PASSADO NO BANCO DE DADOS

		DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa.setIdade(30);
		pessoa.setNome("José Santos");
		pessoa.setSobrenome("de Oliveira Junior");
		pessoa.setEmail("jose@teste.com");
		pessoa.setLogin("admin");
		pessoa.setSenha("123");

		daoGenerico.salvar(pessoa);

	}

	@Test

	public void testeBuscar() { // METODO PARA CONSULTAR DADOS DO BANCO DE DADOS

		DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();

		UsuarioPessoa pessoa = daoGenerico.pesquisar(18L, UsuarioPessoa.class);

		System.out.println(pessoa);
	}

	@Test
	public void testeUpdate() { // METODO PARA REALIZAR UPDADE

		DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();

		UsuarioPessoa pessoa = daoGenerico.pesquisar(6L, UsuarioPessoa.class);

		pessoa.setIdade(24);
		pessoa.setNome("Monica");

		pessoa = daoGenerico.updateMerge(pessoa);

		System.out.println(pessoa);
	}

	@Test

	public void testeDelete() { // METODO PARA REALIZAR DELETE

		DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();

		UsuarioPessoa pessoa = daoGenerico.pesquisar(18L, UsuarioPessoa.class);

		daoGenerico.deletarPoId(pessoa);

	}

	@Test
	public void testeConsultar() { // METODO PARA REALIZAR CONSULTA DE TODOS

		DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();

		List<UsuarioPessoa> list = daoGenerico.listar(UsuarioPessoa.class);

		for (UsuarioPessoa usuarioPessoa : list) {

			System.out.println(usuarioPessoa);
			System.out.println("-------------------------------------------------------");

		}

	}

	@Test
	public void testeQueryConsultar() { // METODO PARA REALIZAR TESTE DECONSULTA DE TODOS A PARTIR DO METODO GET DO
										// EntityManager NO DAO GENERICO

		DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();

		List<UsuarioPessoa> list = daoGenerico.getEntityManager().createQuery("from UsuarioPessoa").getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {

			System.out.println(usuarioPessoa);
			System.out.println("-------------------------------------------------------");

		}
	}
	
	
	//METODO PARA REALIZAR TESTE DE CONSULTA EXIBINDO APENAS UMA
	// QUANTIDADE ESPECIFICA
	// DE DADOS A PARTIR DO METODO GET DO
    // EntityManager NO DAO GENERICO

	@Test
	public void testeQueryConsultarMaxResultado() { 

		DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();

		List<UsuarioPessoa> list = daoGenerico.getEntityManager().createQuery("from UsuarioPessoa order by nome").setMaxResults(4).getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {

			System.out.println(usuarioPessoa);
			System.out.println("-------------------------------------------------------");

		}
	}
	
	
	// METODO PARA LISTAR POR PARAMENTROS
	
	@Test
	public void testeQueryListParameter() {
		
		DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGenerico.
				getEntityManager().createQuery("from UsuarioPessoa where nome = :nome").setParameter("nome", "Monica").getResultList();
		
		 for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	// METODO PARA SOMAR AS IDADES DAS PESSOAS NO BANCO
	@Test
	public void testeQuerySomaIdade() {
		
		DaoGenerico<UsuarioPessoa> daoGenerico = new  DaoGenerico<UsuarioPessoa>();
		
		Long somaIdade = (Long) daoGenerico.getEntityManager().createQuery("select sum(u.idade) from UsuarioPessoa u ").getSingleResult();
		
		System.out.println("A soma de todas as idades é: " + somaIdade);
	}
	
	
	// METODO PARA TESTAR O NAMEQUERY DA MINHA CLASSE USUARIOPESSOA CONSULTATODOS
	
	@Test
	
	public void testeNameQueryConsultaTodos() {
		
		DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGenerico.getEntityManager().createNamedQuery("UsuarioPessoa.consultaTodos").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
			System.out.println("---------------------------");
		}
		
	}
	
	
	// METODO PARA TESTAR O NAMEQUERY DA MINHA CLASSE USUARIOPESSOA BUSCAPORNOME
	
		@Test
		
		public void testeNameQueryBuscaPorNome() {
			
			DaoGenerico<UsuarioPessoa> daoGenerico = new DaoGenerico<UsuarioPessoa>();
			
			List<UsuarioPessoa> list = daoGenerico.getEntityManager().
					createNamedQuery("UsuarioPessoa.buscaPorNome").setParameter("nome", "Monica").getResultList();
			
			for (UsuarioPessoa usuarioPessoa : list) {
				
				System.out.println(usuarioPessoa);
				System.out.println("---------------------------");
			}
			
		}
}











