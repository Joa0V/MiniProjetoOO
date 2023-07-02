package controle;
import modelo.*;

/**
 * 
 * Classe com a finalidade de fazer a conexao entre view e modelo referente a classe Estagio
 *
 */

public class ControleEstagio {

	private Estagio[] estg;
	private int qtdEstagios;
	
	/**
	 * Construtor de ControleEstagio
	 * @param data
	 */
	public ControleEstagio(ControleDados data) {
		
		estg = data.getEstagios();
		qtdEstagios = data.getQtdEstagios();
	}
	
	/**
	 * Construtor de ControleEstagio
	 * @param array
	 */
	public ControleEstagio(Estagio[] array) {
		
		estg = array;
		qtdEstagios= array.length;
	}
	
	public Estagio[] getEstagios() {
		
		return estg;
	}
	
	public String[] getFuncaoEstagio() {
		
		String[] a = new String[qtdEstagios];
		
			for(int i = 0; i < qtdEstagios; i++) {
				
				a[i] = estg[i].getFuncao();
			}
			
		return a;
	}
	
	public int getQtdEstagio() {
		return qtdEstagios;
	}

	public void setQtdEstagio(int qtd) {
		this.qtdEstagios = qtd;
	}
	
	public String getFuncao(int i) {
		
		return estg[i].getFuncao();
	}
	
	public String getFormacao(int i) {
		
		return estg[i].getFormacao();
	}
	
	public String getEmpresa(int i) {
		
		return estg[i].getEmpresa();
	}
	
	public int getTempoVinculo(int i) {
		
		return estg[i].getTempoVinculo();
	}
	
	public String getCursosAceitos(int i) {
		
		return estg[i].getCursosAceitos(); 
	}
		
}