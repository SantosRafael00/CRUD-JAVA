package model;

import java.time.LocalDate;

public class Client {

	private int id;

	private String nome;
	
	private LocalDate dataNasc;

	private String login;

	private String senha;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int id, String nome, LocalDate dataNasc, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.login = login;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
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
	} }



	
	
	
