package br.com.projetomv.model;

public class Pessoa {

	public String nome;
	public String personalId;
	public String telefone;
	public String email;
	public String rg;
	public String sexo;
	public boolean tipo;

	public String getEmail() {
		return this.email;
	}

	public String getNome() {
		return this.nome;
	}

	public String getPersonalId() {
		return this.personalId;
	}

	public String getRg() {
		return this.rg;
	}

	public String getSexo() {
		return this.sexo;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public boolean isTipo() {
		return this.tipo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

}
