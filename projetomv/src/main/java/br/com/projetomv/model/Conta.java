package br.com.projetomv.model;


public class Conta {

	public String banco;
	public String dataConta;
	public double saldo;

	public String getBanco() {
		return this.banco;
	}

	public String getDataConta() {
		return this.dataConta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}


	public void setDataConta(String dataConta) {
		this.dataConta = dataConta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
