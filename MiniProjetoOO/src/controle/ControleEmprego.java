package controle;
import modelo.*;

/**
 * 
 * Classe com a finalidade de fazer a conexao entre view e modelo referente a classe EmpregoFixo
 *
 */

public class ControleEmprego {

	private EmpregoFixo[] ef;
	private int qtdEmprego;
	
	/**
	 * Construtor da classe ControleEmprego
	 * @param data
	 */
	
	public ControleEmprego(ControleDados data) {
		
		ef = data.getEmpregoFixo();
		qtdEmprego = data.getQtdEmpregos();
	}
	
	/**
	 * Construtor da classe ControleEmprego
	 * @param array
	 */
	public ControleEmprego(EmpregoFixo[] array) {
		
		ef = array;
		qtdEmprego= array.length;
	}
	
	public EmpregoFixo[] getEmpregos() {
		
		return ef;
	}
	
	public String[] getFuncaoEmprego() {
		
		String[] a = new String[qtdEmprego];
		
			for(int i = 0; i < qtdEmprego; i++) {
				
				a[i] = ef[i].getFuncao();
			}
			
		return a;
	}
	
	public int getQtdEmprego() {
		return qtdEmprego;
	}

	public void setQtdEmprego(int qtd) {
		this.qtdEmprego = qtd;
	}
	
	public String getFuncao(int i) {
		
		return ef[i].getFuncao();
	}
	
	public String getFormacao(int i) {
		
		return ef[i].getFormacao();
	}
	
	public String getEmpresa(int i) {
		
		return ef[i].getEmpresa();
	}
	
	public float getSalario(int i) {
		
		return ef[i].getSalario();
	}
}