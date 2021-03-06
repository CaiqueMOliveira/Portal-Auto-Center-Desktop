package viewmodel;

public class ParceiroSimplesFormatado {

	private int idParceiro;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private int idEndereco;
	private String ativo;
	private String socorrista;
	private String email;
	private String telefone;
	private String fotoPerfil;
	private String celular;
	private String logParceiro;
	private int idUsuario;
	private int idPlanoContratacao;
	private String plano;

    // Default constructor
	public ParceiroSimplesFormatado
	(
		int idParceiro,
		String nomeFantasia,
		String razaoSocial,
		String cnpj,
		int idEndereco,
		String ativo,
		String socorrista,
		String email,
		String telefone,
		String fotoPerfil,
		String celular,
		String logParceiro,
		int idUsuario,
		int idPlanoContratacao,
		String plano
	)
	{
		this.idParceiro = idParceiro;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.idEndereco = idEndereco;
		this.ativo = ativo;
		this.socorrista = socorrista;
		this.email = email;
		this.telefone = telefone;
		this.fotoPerfil = fotoPerfil;
		this.celular = celular;
		this.logParceiro = logParceiro;
		this.idUsuario = idUsuario;
		this.idPlanoContratacao = idPlanoContratacao;
		this.plano = plano;
	}

	public int getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(int idParceiro) {
		this.idParceiro = idParceiro;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getSocorrista() {
		return socorrista;
	}

	public void setSocorrista(String socorrista) {
		this.socorrista = socorrista;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getLogParceiro() {
		return logParceiro;
	}

	public void setLogParceiro(String logParceiro) {
		this.logParceiro = logParceiro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPlanoContratacao() {
		return idPlanoContratacao;
	}

	public void setIdPlanoContratacao(int idPlanoContratacao) {
		this.idPlanoContratacao = idPlanoContratacao;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

}
