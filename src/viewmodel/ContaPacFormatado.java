package viewmodel;

import java.util.ArrayList;

import controller.CompanyExpense;
import model.CompanyExpenseDAO;

public class ContaPacFormatado {

	private int idContaPac;
	private int idCategoriaContaPac;
	private float valor;
	private String vencimento;
	private String paga;
	private String categoria;

	// Default constructor
	public ContaPacFormatado
	(
		int idContaPac,
		int idCategoriaContaPac,
		float valor,
		String vencimento,
		String paga,
		String categoria
	)
	{
		this.idContaPac = idContaPac;
		this.idCategoriaContaPac = idCategoriaContaPac;
		this.valor = valor;
		this.vencimento = vencimento;
		this.paga = paga;
		this.categoria = categoria;
	}
	// **************************************************
	public int getIdContaPac() {
		return idContaPac;
	}
	public void setIdContaPac(int idContaPac) {
		this.idContaPac = idContaPac;
	}
	public int getIdCategoriaContaPac() {
		return idCategoriaContaPac;
	}
	public void setIdCategoriaContaPac(int idCategoriaContaPac) {
		this.idCategoriaContaPac = idCategoriaContaPac;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getVencimento() {
		return vencimento;
	}
	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}
	public String getPaga() {
		return paga;
	}
	public void setPaga(String paga) {
		this.paga = paga;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
