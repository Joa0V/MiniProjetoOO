package modelo;

/**
 * Classe Estagio simula o comportamento de uma vaga de estagio, herda da classe VagaEmprego
 */

public class Estagio extends VagaEmprego{

	private int tempo_vinculo;
	private String cursos_aceitos;
	
	/**
	 * Construtor da classe Estagio
	 */ 
	public Estagio() {
			
			super();
		}

	/**
	 * Construtor da classe Estagio
	 * @param func
	 * @param form
	 * @param emp
	 * @param beneficio
	 * @param t
	 * @param cursos
	 */
	
	public Estagio(String func, String form, String emp, Beneficio beneficio, int t, String cursos) {
				
			funcao = func;
			formacao = form;
			empresa = emp;
			beneficio_ofertado = beneficio;
			this.tempo_vinculo = t;
			this.cursos_aceitos = cursos;
	}
		
	public int getTempoVinculo() {
		
		return tempo_vinculo;
	}
	
	public void setTempoVinculo(int t) {
		
		this.tempo_vinculo = t;
	}

	
	public String getCursosAceitos() {
		
		return cursos_aceitos;
	}
	
	public void getCursosAceitos(String c) {
		
		this.cursos_aceitos = c;
	}
	
	public String toString() {
		
		return "Funcao: " + this.getFuncao() + "\nFormacao: " + this.getFormacao() + " reais\nContratante: " + this.getEmpresa() 
				+ "\nBeneficio: " + this.getBeneficioOfertado().getTipo() + "\nCursos aceitos: " + this.getCursosAceitos() + "\nTempo de vinculo: " 
				+ this.getTempoVinculo();
	}

}