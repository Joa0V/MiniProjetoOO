package modelo;

/**
 * Classe VagaEmprego simula o comportamento de uma vaga de emprego
 */

public abstract class VagaEmprego {

	protected String funcao;
	protected String formacao;
	protected String empresa;
	protected Beneficio beneficio_ofertado;
	
	public VagaEmprego() {
		super();
	}

	/**
	 * Construtor da classe VagaEmprego
	 * @param funcao Funcao a ser exercida
	 * @param formacao Formacao necessaria
	 * @param empresa Empresa
	 * @param beneficio_ofertado Beneficio ofertado
	 */
	public VagaEmprego(String funcao, String formacao, String empresa, Beneficio beneficio_ofertado) {
		
		this.funcao = funcao;
		this.formacao = formacao;
		this.empresa = empresa;
		this.beneficio_ofertado = beneficio_ofertado;
	}
	
	public String getFuncao(){
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getFormacao(){
		return formacao;
	}
	
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public String getEmpresa(){
		return empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public Beneficio getBeneficioOfertado() {
		return beneficio_ofertado;
	}
	
	public void setBeneficioOfertado(Beneficio beneficio_ofertado) {
		this.beneficio_ofertado = beneficio_ofertado;
	}
	
	
	public String toString() {
		
		return "Funcao: " + this.getFuncao() + "\nFormacao: " + this.getFormacao() + "\nSalario: " + " reais\nContratante: " + this.getEmpresa();
	}
	
}
