package modelo;

/**
 * Classe EmpregoFixo simula o comportamento de uma vaga de emprego, herda da classe VagaEmprego
 */

public class EmpregoFixo extends VagaEmprego{

	private float salario;
	
	/**
	 * Construtor EmpregoFixo
	 */
	public EmpregoFixo() {
		
		super();
	}
	
	/**
	 * Construtor da classe EmpregoFixo	
	 * @param func
	 * @param form
	 * @param salario
	 * @param emp
	 * @param beneficio
	 */

	public EmpregoFixo(String func, String form, float salario, String emp, Beneficio beneficio) {
			
			funcao = func;
			formacao = form;
			this.salario = salario;
			empresa = emp;
			beneficio_ofertado = beneficio;
	}
	
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public String toString() {
		
		return "Funcao: " + this.getFuncao() + "\nFormacao: " + this.getFormacao() + "\nSalario: " + this.salario + " reais\nContratante: " + 
		this.getEmpresa() + "\nBeneficio: " + this.getBeneficioOfertado().getTipo();
	}


}