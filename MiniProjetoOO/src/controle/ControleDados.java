package controle;
import modelo.*;

/**
 * 
 * Classe com a finalidade de fazer a conexao entre view e modelo referente a classe Dados
 *
 */

public class ControleDados {

	private Dados d = new Dados();
	
	/**
	 * Construtor da classe ControleDados
	 */
	public ControleDados() {
		
		d.preencherOportunidades();
	}
	
	public ControleDados(Dados data) {
		
		data.preencherOportunidades();
	}
	
	public Dados getDados() {
		return d;
	}
	
	public void setDados(Dados d) {
		this.d = d;
	}
	
	public EmpregoFixo[] getEmpregoFixo() {
		
		return this.d.getEmpregos();
	}
	
	public Estagio[] getEstagios() {
		
		return this.d.getEstagios();
	}
	
	public int getQtdEstagios() {
		
		return this.d.getQtdEstagio();
	}
	
	public int getQtdEmpregos() {
		
		return this.d.getQtdEmpregoFixo();
	}
	
	public int getQtdBeneficio() {
		
		return this.getQtdBeneficio();
	}
	
	/**
	 * Metodo de busca de uma determinada vaga de estagio presente em uma instancia da classe Dados
	 * @param s Funcao buscada
	 * @return Estagio[]
	 */
	
	public Estagio[] buscarEstagioDados(String s) {
		
		return d.buscarEstagio(s);
		
	}
	
	/**
	 * Metodo de busca de uma determinada vaga de emprego presente em uma instancia da classe Dados
	 * @param s Funcao buscada
	 * @return EmpregoFixo[]
	 */
	
	public EmpregoFixo[] buscarEmpregoDados(String s) {
		
		return d.buscarEmpregoFixo(s);
	}
	
	/**
	 * Metodo que verifica se os dados foram corretamente inseridos. Se estiverem corretos, cria uma nova instancia da classe EmpregoFixo, a depender do valor de dadosEmpregoFixo[0] sera adicionado
	 * uma nova vaga de emprego ou editada uma ja existente
	 * True: foi cadastrado ou editado
	 * False: nao foi cadastrado ou editado
	 * @param  dadosEmpregoFixo Novos dados a serem salvos
	 * @return boolean
	 */
	
	public boolean inserirEditarEmprego(String[] dadosEmpregoFixo) {
		
		if(!dadosEmpregoFixo[3].matches("[0-9]+")) {
			return false;
		}
		
		else {
			
			EmpregoFixo e = new EmpregoFixo(dadosEmpregoFixo[1], dadosEmpregoFixo[2], Float.parseFloat(dadosEmpregoFixo[3]), dadosEmpregoFixo[4], new Beneficio(dadosEmpregoFixo[5], 10, false));
			d.inserirEditarEmprego(e, Integer.parseInt(dadosEmpregoFixo[0]));
			return true;
		}
	}
	
	/**
	 * Metodo que verifica se os dados foram corretamente inseridos. Se estiverem corretos, cria uma nova instancia da classe Estagio, a depender do valor de dadosEstagio[0] sera adicionado
	 * uma nova vaga de estagio ou editada uma ja existente
	 * True: foi cadastrado ou editado
	 * False: nao foi cadastrado ou editado
	 * @param  dadosEstagio Novos dados a serem salvos
	 * @return boolean
	 */
	
	public boolean inserirEditarEstagio(String[] dadosEstagio) {
		
		if(!dadosEstagio[5].matches("[0-9]+")) {
			return false;
		}
		
		else {
			
			Estagio e = new Estagio(dadosEstagio[1], dadosEstagio[2], dadosEstagio[3], new Beneficio(dadosEstagio[4], 10, false), Integer.parseInt(dadosEstagio[5]), dadosEstagio[6]);
			d.inserirEditarEstagio(e, Integer.parseInt(dadosEstagio[0]));
			return true;
		}
	}
	
	/**
	 * Metodo para criar um array de int que relacione os index de um array de busca de uma oportunidade de emprego com um array de todas as oportunidades de emprego de mesmo tipo.
	 * Caso seletor seja igual a 1, trata-se de dados de instancias da classe EmpregoFixo, senao, trata-se de dados de instancias de classe Estagio
	 * @param funcao Funcao buscada
	 * @param seletor Selecao do tipo de oportunidade de emprego. EmpregoFixo, caso seletor se igual a 1, Estagio, caso seja igual a 2
	 * @return int[] 
	 */
	public int[] getIndex(String funcao, int seletor) {
		
		int[] index;
		int tamanho = 0;
		int j = 0;
		
		//empregos
		if(seletor == 1) {
			
			for(int i = 0; i < d.getQtdEmpregoFixo(); i++) {
				
				if(funcao.equalsIgnoreCase(d.getEmpregos()[i].getFuncao()) == true) {
					
					tamanho++;
				}
			}
		}
		
		//estagios
		if(seletor == 2) {
			
			for(int i = 0; i < d.getQtdEstagio(); i++) {
				
				if(funcao.equalsIgnoreCase(d.getEstagios()[i].getFuncao()) == true) {
					
					tamanho++;
				}
			}
		}
		index = new int[tamanho];
		
		//empregos
		if(seletor == 1) {
					
			for(int i = 0; i < d.getQtdEmpregoFixo(); i++) {
						
				if(funcao.equalsIgnoreCase(d.getEmpregos()[i].getFuncao()) == true) {
							
					index[j] = i;
					j++;
				}
			}
		}
		//estagios
		if(seletor == 2) {
			
			for(int i = 0; i < d.getQtdEstagio(); i++) {
						
				if(funcao.equalsIgnoreCase(d.getEstagios()[i].getFuncao()) == true) {
							
					index[j] = i;
					j++;
				}
			}
		}
		return index;
	}
	
	/**
	 * Metodo para remover uma vaga de emprego cadastrada a partir de sua posicao em um array da classe EmpregoFixo. Altera a variavel qtdEmpregoFixo
	 * True: foi removida
	 * False: nao foi removida
	 * @param i Posicao em um array da Classe EmpregoFixo referente a oportunidade a ser excluida
	 * @return boolean
	 */
	
	public boolean removerEmprego(int i) {
		
		String empregoRemovido = d.getEmpregos()[i].getFuncao();
		
		if(i == d.getQtdEmpregoFixo() - 1) {
			
			d.setQtdEmpregoFixo(d.getQtdEmpregoFixo() - 1);
			d.getEmpregos()[d.getQtdEmpregoFixo()] = null;
			return true;
				
		}
		else {
			
			int cont = 0;
			
			while(d.getEmpregos()[cont].getFuncao().compareToIgnoreCase(empregoRemovido) != 0) {
				cont++;
			}
			
			for(int j = cont; j < d.getQtdEmpregoFixo() - 1; j++) {
				
				d.getEmpregos()[j] = null;
				d.getEmpregos()[j] = d.getEmpregos()[j+1];
			}
			
			d.getEmpregos()[d.getQtdEmpregoFixo()] = null;
			d.setQtdEmpregoFixo(d.getQtdEmpregoFixo() -1);
			return true;
		}
	}
	
	/**
	 * Metodo para remover uma vaga de estagio cadastrada a partir de sua posicao em um array da classe Estagio. Altera a variavel qtdEstagio
	 * True: foi removida
	 * False: nao foi removida
	 * @param i Posicao em um array da Classe Estagio referente a oportunidade a ser excluida
	 * @return boolean
	 */
	
	public boolean removerEstagio(int i) {
		
		String estagioRemovido = d.getEstagios()[i].getFuncao();
		
		if(i == d.getQtdEstagio() - 1) {
			
			d.setQtdEstagio(d.getQtdEstagio() - 1);
			d.getEstagios()[d.getQtdEstagio()] = null;
			return false;
				
		}
		else {
			
			int cont = 0;
			
			while(d.getEstagios()[cont].getFuncao().compareToIgnoreCase(estagioRemovido) != 0) {
				cont++;
			}
			
			for(int j = cont; j < d.getQtdEstagio() - 1; j++) {
				
				d.getEstagios()[j] = null;
				d.getEstagios()[j] = d.getEstagios()[j+1];
				System.out.println(d.getEstagios()[j].getFuncao());
			}
			
			System.out.println(d.getQtdEstagio() - 1);
			System.out.println(cont);
			
			d.getEstagios()[d.getQtdEstagio()] = null;
			d.setQtdEstagio(d.getQtdEstagio() -1);
			return true;
		}
	}
	
	/**
	 * Metodo para verificar se uma vaga pertence a um array da classe EmpregoFixo dada uma String s referente a funcao a ser exercida 
	 * True: ha vaga(s)
	 * False: nao ha vaga(s) 
	 * @param s Funcao buscada
	 * @return boolean
	 */
	
	public boolean verificarEmpregoControle(String s) {
		
		for(int i = 0; i < d.getQtdEmpregoFixo(); i++) {
			
			if(d.getEmpregos()[i].getFuncao().equalsIgnoreCase(s) == true) {
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Metodo para verificar se uma vaga pertence a um array da classe Estagio dada uma String referente a funcao a ser exercida 
	 * True: ha vaga(s)
	 * False: nao ha vaga(s) 
	 * @param s Funcao buscada
	 * @return boolean
	 */
	
	public boolean verificarEstagioControle(String s) {
		
		for(int i = 0; i < d.getEstagios().length; i++) {
			
			if(d.getEstagios()[i].getFuncao().equalsIgnoreCase(s) == true) {
				
				return true;
			}
		}
		
		return false;
	}
	/**
	 * Metodo que verifica se foi encontrado uma oportunidade de emprego com o atributo funcao igual a String s. 
	 * True: nao foi encontrado
	 * False: foi encontrado 
	 * @param s Funcao buscada
	 * @return boolean
	 */
	public boolean verificarNulidadeControle(String s) {
		
		if(d.buscarEmpregoFixo(s) == null && d.buscarEstagio(s) == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
}


