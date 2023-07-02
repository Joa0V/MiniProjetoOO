package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;

/**
 * Classe que implementa a tela de detalhamento de certa portunidade de emprego
 *
 */

public class TelaDetalheVaga implements ActionListener {

	private JFrame janela;
	private JLabel labelFuncao = new JLabel("Funcao: ");
	private JTextField valorFuncao;
	private JLabel labelFormacao = new JLabel("Formacao: ");
	private JTextField valorFormacao;
	private JLabel labelEmpresa = new JLabel("Empresa: ");
	private JTextField valorEmpresa;
	private JLabel labelBeneficio = new JLabel("Beneficios: ");
	private JTextField valorBeneficio;
	private JLabel labelSalario = new JLabel("Salario: ");
	private JTextField valorSalario;
	private JLabel labelCursosAceitos = new JLabel("Cursos aceitos: ");
	private JTextField valorCursosAceitos;
	private JLabel labelTempoVinculo = new JLabel("Tempo de vinculo: ");
	private JTextField valorTempoVinculo;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Metodo que definir as caracteristicas da tela de detalhamento. A depender do parametro op sera destinada a uma tela de 
	 * cadastro ou edicao de uma determinada oportunidade de emprego, a qual pode ser uma vaga de emprego ou estagio 
	 * @param op Seletor da acao a ser feita
	 * @param d Instancia de ControleDados que contem as oportunidades de emprego
	 * @param p Referente a tela anterior (tela de detalhamento)
	 * @param pos Posicao da oportunidade de emprego selecionada
	 */
	
	public void inserirEditar(int op, ControleDados d, 
			TelaVagaEmprego p, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro de Emprego";
		if (op == 2) s = "Cadastro de Estagio";
		if (op == 3) s = "Detalhe de Emprego";
		if (op == 4) s = "Detalhe de Estagio";

		janela = new JFrame(s);

		//Preenche dados com dados do emprego clicado
		if (op == 3) {
			valorFuncao = new JTextField(dados.getEmpregoFixo()[pos].getFuncao(), 200);
			valorEmpresa = new JTextField(dados.getEmpregoFixo()[pos].getEmpresa(),200);
			valorFormacao =  new JTextField(dados.getEmpregoFixo()[pos].getFormacao(),200);
			valorBeneficio = new JTextField(dados.getEmpregoFixo()[pos].getBeneficioOfertado().getTipo(), 200);
			valorSalario = new JTextField(String.valueOf(dados.getEmpregoFixo()[pos].getSalario()), 200);

		} else if (op == 4) { //Preenche dados com dados do estagio clicado 
			valorFuncao = new JTextField(dados.getEstagios()[pos].getFuncao(), 200);
			valorFormacao = new JTextField(dados.getEstagios()[pos].getFormacao(),200);
			valorEmpresa = new JTextField(dados.getEstagios()[pos].getEmpresa(),200);
			valorBeneficio = new JTextField(dados.getEstagios()[pos].getBeneficioOfertado().getTipo(), 200);
			valorCursosAceitos = new JTextField(dados.getEstagios()[pos].getCursosAceitos(), 200);
			valorTempoVinculo = new JTextField(String.valueOf(dados.getEstagios()[pos].getTempoVinculo()), 200);

		} else { //Não preenche com dados

			valorFuncao = new JTextField(200);
			valorEmpresa = new JTextField(200);
			valorFormacao = new JTextField(200);
			valorBeneficio = new JTextField(200);
			valorSalario = new JTextField(200);
			valorCursosAceitos = new JTextField(200);
			valorTempoVinculo = new JTextField(200);

			botaoSalvar.setBounds(245, 175, 115, 30);
		}

		labelFuncao.setBounds(30, 20, 150, 25);
		valorFuncao.setBounds(180, 20, 180, 25);
		labelFormacao.setBounds(30, 50, 150, 25);
		valorFormacao.setBounds(180, 50, 180, 25);
		labelEmpresa.setBounds(30, 80, 150, 25);
		valorEmpresa.setBounds(180, 80, 180, 25);
		labelBeneficio.setBounds(30, 110, 150, 25);
		valorBeneficio.setBounds(180, 110, 180, 25);
		
		if (op == 1 || op == 3 ) {
			labelSalario.setBounds(30, 140, 150, 25);
			valorSalario.setBounds(180, 140, 180, 25);

		}
		
		if (op == 2 || op == 4) {

			labelCursosAceitos.setBounds(30, 140, 150, 25);
			valorCursosAceitos.setBounds(180, 140, 180, 25);
			labelTempoVinculo.setBounds(30, 170, 150, 25);
			valorTempoVinculo.setBounds(180, 170, 180, 25);
		}
		

		//Coloca os campos relacionados a endereco se emprego
		if (op == 1 || op == 3 ) {
			this.janela.add(labelSalario);
			this.janela.add(valorSalario);

		}

		//Coloca campos relacionados a exclusivamente a estagio
		if (op == 2 || op == 4) {

			this.janela.add(labelCursosAceitos);
			this.janela.add(valorCursosAceitos);
			this.janela.add(labelTempoVinculo);
			this.janela.add(valorTempoVinculo);
		}

		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(120, 210, 115, 30);
			botaoExcluir.setBounds(245, 210, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelFuncao);
		this.janela.add(valorFuncao);
		this.janela.add(labelFormacao);
		this.janela.add(valorFormacao);
		this.janela.add(labelEmpresa);
		this.janela.add(valorEmpresa);
		this.janela.add(labelBeneficio);
		this.janela.add(valorBeneficio);

		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 300);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}

	/**
	 * Captura eventos relacionados aos botões da interface. Aciona o metodo de salvar alteracoes
	 * em uma vaga ou exclui-la
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) //cadastro de novo emprego
					novoDado[0] = Integer.toString(dados.getQtdEmpregos());
				else if (opcao == 2) // cadastro de novo estagio
					novoDado[0] = Integer.toString(dados.getQtdEstagios());
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);

				if (opcao == 1 || opcao == 3) {
					novoDado[1] =  valorFuncao.getText();
					novoDado[2] =  valorFormacao.getText();
					novoDado[3] =  valorSalario.getText();
					novoDado[4] =  valorEmpresa.getText();
					novoDado[5] =  valorBeneficio.getText();
					res = dados.inserirEditarEmprego(novoDado);
				} else {
					novoDado[1] =  valorFuncao.getText();
					novoDado[2] =  valorFormacao.getText();
					novoDado[3] =  valorEmpresa.getText();
					novoDado[4] =  valorBeneficio.getText();
					novoDado[5] = valorTempoVinculo.getText();
					novoDado[6] =  valorCursosAceitos.getText();
					
					res = dados.inserirEditarEstagio(novoDado);
				}

				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}

		if(src == botaoExcluir) {
			boolean res = false;

			if (opcao == 3) {//exclui emprego
				res = dados.removerEmprego(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoEmprego(); 
			}
				
			if (opcao == 4){ //exclui estagio
				res = dados.removerEstagio(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoEstagio(); 
			}
			
		}
	}

	
	/**
	 * Metodo para mensagem em caso de exito na exclusao
	 */
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * Metodo para mensagem em caso de exito no cadastro
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * Metodo para mensagem em caso de falha no cadastro
	 */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido o seguinte erro:  \n"
				+ "Campos numericos não contém apenas números", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Metodo para mensagem em caso de falha na exclusao de uma vaga de emprego
	 */
	public void mensagemErroExclusaoEmprego() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Metodo para mensagem em caso de falha na exclusao de uma vaga de estagio
	 */
	public void mensagemErroExclusaoEstagio() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	
}