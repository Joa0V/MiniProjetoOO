package entrega1.modelo;

public class VagaEmprego {

	private String funcao;
	private String formacao;
	private float salario;
	private String empresa;
	private boolean status;
	private Beneficio beneficio_ofertado;
	
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
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Beneficio getBeneficioOfertado() {
		return beneficio_ofertado;
	}
	
	public void setBeneficioOfertado(Beneficio beneficio_ofertado) {
		this.beneficio_ofertado = beneficio_ofertado;
	}
	
	public String toString() {
		
		String status_vaga = getStatus() ? "aberta" : "aplicada";
		
		return "Funcao: " + this.getFuncao() + "\nFormacao: " + this.getFormacao() + "\nSalario: " + this.salario + " reais\nContratante: " + this.getEmpresa() + "\nInscricao: " + status_vaga;
	}
}
