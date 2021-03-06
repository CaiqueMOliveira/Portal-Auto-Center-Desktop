package controller;

import model.AddressDAO;

public class Address {

	private int idEndereco;
	private String logradouro;
	private String numero;
	private String cidade;
	private int idEstado;
	private String cep;
	private String bairro;
	private String complemento;
	
	// Default constructor
	public Address
	(
		int idEndereco,
		String logradouro,
		String numero,
		String cidade,
		int idEstado,
		String cep,
		String bairro,
		String complemento
	)
	{
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.idEstado = idEstado;
		this.cep = cep;
		this.bairro = bairro;
		this.complemento = complemento;
	}
	
	// No idEndereco
	public Address
	(
		String logradouro,
		String numero,
		String cidade,
		int idEstado,
		String cep,
		String bairro,
		String complemento
	)
	{
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.idEstado = idEstado;
		this.cep = cep;
		this.bairro = bairro;
		this.complemento = complemento;
	}
	// **********************************************

	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Insert a new address into DB
	 * @param addressObj Object that will inserted into DB
	 * @return long Last record's ID
	 * @return long -1 Fail in try to get last record's ID from database
	 */
	public long insertAddress(Address addressObj)
	{
		AddressDAO addressDAO = new AddressDAO();
		return addressDAO.insertAddress(addressObj);
	}
	
	/**
	 * Update the address in DB
	 * @param addressObj Address that will be updated into DB
	 * @return true Address was updated with successful
	 * @return false Fail on attempt to updated the address from DB
	 */
	public boolean updateAddress(Address addressObj)
	{
		AddressDAO addressDAO = new AddressDAO();
		return addressDAO.updateAddress(addressObj);
	}
}
