package modelo;

/**
 * Classe Dados simula o comportamento de um banco de dados
 */

public class Dados {

	private Estagio[] estagios = new Estagio[10];
	private EmpregoFixo[] empregos = new EmpregoFixo[10];
	private Beneficio[] beneficios = new Beneficio[20];
	private int qtdEstagio;
	private int qtdEmpregoFixo;
	private int qtdBeneficio;
	
	/**
	 * Construtor Dados
	 */
	public Dados() {
		super();
	}
	
	public int getQtdEstagio() {
		
		return qtdEstagio;
	}
	
	public void setQtdEstagio(int qtd) {
		
		this.qtdEstagio = qtd;
	}
	
	public int getQtdEmpregoFixo() {
		
		return qtdEmpregoFixo;
	}
	
	public void setQtdEmpregoFixo(int qtd) {
		
		this.qtdEmpregoFixo = qtd;
	}
	
	public int qtdBeneficio() {
		
		return qtdBeneficio;
	}
	
	public void qtdBeneficio(int qtd) {
		
		this.qtdBeneficio = qtd;
	}
	
	
	
	public Beneficio[] getBeneficio() {
		
		return beneficios;
	}
	
	public void setBeneficio(Beneficio[] c) {
		
		this.beneficios = c;
	}
	
	public Estagio[] getEstagios() {
		
		return estagios;
	}
	
	public void setEstagios(Estagio[] e) {
		
		this.estagios = e;
	}
	
	public EmpregoFixo[] getEmpregos() {
		
		return empregos;
	}
	
	public void setEmpregos(EmpregoFixo[] e) {
		
		this.empregos = e;
	}
	
	/**
	 * preenche uma instancia da classe Dados com informacoes refentes as oportunidades de emprego
	 */
	
	public void preencherOportunidades() {
		
		beneficios[0] = new Beneficio("Plano de saude0", 10, false);
		beneficios[1] = new Beneficio("Vale transporte0", 10, false);
		beneficios[2] = new Beneficio("Vale refeicao0", 10, false);
		beneficios[3] = new Beneficio("Plano odontologico0", 10, false);
		beneficios[4] = new Beneficio("Plano de saude1", 10, false);
		beneficios[5] = new Beneficio("Vale transporte1", 10, false);
		beneficios[6] = new Beneficio("Vale refeicao1", 10, false);
		beneficios[7] = new Beneficio("Plano odontologico1", 10, false);
		beneficios[8] = new Beneficio("Auxilio moradia0", 10, false);
		beneficios[9] = new Beneficio("Auxilio moradia1", 10, false);
		
		estagios[0] = new Estagio("Aux0", "Graduacao ensino superior", "DFTech", beneficios[9], 6, "CC");
		estagios[1] = new Estagio("Aux1", "GES", "empresa1", beneficios[2], 7, "Eng");
		estagios[2] = new Estagio("Aux2", "Cursando EM", "empresa2", beneficios[2], 7, "Eng");
		estagios[3] = new Estagio("Aux3", "GEM", "empresa3", beneficios[5], 8, "Enga");
		estagios[4] = new Estagio("Aux4", "GES", "empresa4", beneficios[6], 9, "Enf");
		
		empregos[0] = new EmpregoFixo("Supervisor", "Graduacao ensino superior", 3500, "AtoT", beneficios[0]);
		empregos[1] = new EmpregoFixo("Gerente", "Graduacao ensino superior", 9500, "AtoT", beneficios[9]);
		empregos[2] = new EmpregoFixo("Consultor vendas", "Graduacao ensino medio", 4500, "AltV", beneficios[4]);
		empregos[3] = new EmpregoFixo("Lead Desing", "Graduacao ensino superior", 7500, "DFTech", beneficios[8]);
		empregos[4] = new EmpregoFixo("Gerente", "Graduacao ensino medio", 3500, "AtoT", beneficios[3]);
		
		qtdEstagio = 5;
		qtdEmpregoFixo = 5;
		qtdBeneficio = 10;
		
	}
	
	/**
	 * Retorna uma string contendo as funcoes a serem exercidas em cada oportunidade de emprego 
	 * @return String
	 */

	public String listarOportunidades() { 
		
		String saida = "";
		
		for(int i = 0; i < 0; i++) {
			
			saida = saida + "\n" + estagios[i].getFuncao().toString();
		}
		
		for(int i = 0; i < 0; i++) {
					
			saida = saida + "\n" + empregos[i].getFuncao().toString();
		}
		
		return saida;
	}
	
	
	/**
	 * Retorna um array da classe Estagio, resultado de uma busca a partir de uma string. O parametro s é primeiro comparado com os atributos
	 * funcao de cada de oportunidade de estagio, entao e construido um array que comporta todas as instancias da classe Estagio as quais tem 
	 * o atributo igual ao parametro s.
	 * @param s
	 * @return Estagio[]
	 */
	
	public Estagio[] buscarEstagio(String s) {
		
		Estagio retorno[] = null;
		int size = 0;
		int j = 0;
				
		for(int i = 0; i < qtdEstagio; i++) {
			
			if(s.equalsIgnoreCase(estagios[i].getFuncao()) == true) {
				size++;
			}
		}

		if(size != 0) {
			
			retorno = new Estagio[size];
			
			for(int i = 0; i < qtdEstagio; i++) {
				
				if(s.equalsIgnoreCase(estagios[i].getFuncao()) == true) {
					retorno[j] = estagios[i];
					j++;
				}
			}
		}
		
		return retorno;
	}

	/**
	 * Retorna um array da classe EmpregoFixo, resultado de uma busca a partir de uma string. O parametro s é primeiro comparado com os 
	 * atributos funcao de cada de oportunidade de emprego, entao e construido um array que comporta todas as instancias da classe 
	 * EmpregoFixo as quais tem o atributo igual ao parametro s.
	 * @param s
	 * @return EmpregoFixo[]
	 */
	
	public EmpregoFixo[] buscarEmpregoFixo(String s) {
		
		EmpregoFixo[] retorno = null;
		int size = 0;
		int j = 0;
		
		for(int i = 0; i < qtdEmpregoFixo; i++) {
			
			if(s.equalsIgnoreCase(empregos[i].getFuncao()) == true) {
				size++;
			//	System.out.println(i + " " + size);
			}
		}		
		
		if(size != 0) {
			
			retorno = new EmpregoFixo[size];
			
			for(int i = 0; i < qtdEmpregoFixo; i++) {
				
				if(s.equalsIgnoreCase(empregos[i].getFuncao()) == true) {
					retorno[j] = empregos[i];
					j++;
				}
			}
		}
		//System.out.println(retorno[0].getFuncao());
		return retorno;
	}

/**
 * Metodo para inserir uma nova vaga de emprego ou editar um ja existente	
 * @param e
 * @param i
 */

	public void inserirEditarEmprego(EmpregoFixo e, int i) {
		
		this.empregos[i] = e;
		if(i == qtdEmpregoFixo) qtdEmpregoFixo++;
	}
	
/**
 * Metodo para inserir uma nova vaga de estagio ou editar um ja existente	
 * @param e
 * @param i
 */

	public void inserirEditarEstagio(Estagio e, int i) {
		
		this.estagios[i] = e;
		if(i == qtdEstagio) qtdEstagio++;
	}
	
	
}

