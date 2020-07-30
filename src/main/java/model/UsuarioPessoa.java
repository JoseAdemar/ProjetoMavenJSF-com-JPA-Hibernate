package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity // ESSA ANOTACAO FAZ COM QUE É GERADA A TABELA NO BANCO


@NamedQueries({ // ESSA ANOTACAO DE UMA QUERY PRONTA PRA SER CHAMADA
	
	
	@NamedQuery(name = "UsuarioPessoa.consultaTodos", query = "select u from UsuarioPessoa u"),
	@NamedQuery(name = "UsuarioPessoa.buscaPorNome", query = "select u from UsuarioPessoa u where u.nome = :nome")
	
	
	
})



public class UsuarioPessoa {
	

	@Id  // GERA O ID DA TABELA DO BANCO
	@GeneratedValue(strategy = GenerationType.AUTO)  // GERA O AUTOINCREMENT DOS ID AUTOMATICAMENTE
	private Long id;

	private String nome;
	private String sobrenome;
	private Integer idade;
	private String email;
	private String login;
	private String senha;
	
	

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade
				+ ", email=" + email + ", login=" + login + ", senha=" + senha + "]";
	}
	
	

}
