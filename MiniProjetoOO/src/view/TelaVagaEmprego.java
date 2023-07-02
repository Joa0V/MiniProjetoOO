package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

/**
 * Classe que implementa a tela de listagem das oportunidades de emprego disponiveis
 */

public class TelaVagaEmprego implements ActionListener, ListSelectionListener{

	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroEmprego; 
	private JButton refreshEmprego;
	private JButton cadastroEstagio; 
	private JButton refreshEstagio;
	private static ControleDados dados;
	private JList<String> listaEmpregosCadastrados;
	private JList<String> listaEstagiosCadastrados;
	private String[] listaFuncoes = new String[50];
	private int[] index;
	private boolean t = false;

	/**
	 * Metodo para definir a caracteristica da tela de listagem. A depender do parametro op, a lista sera destinada a empregos ou estagios
	 * @param d
	 * @param op
	 */
	
	public void mostrarDados(ControleDados d, int op){
		
		dados = d;

		switch (op) {
		case 1:// Mostrar dados de empregos cadastrados (JList)
			
			listaFuncoes = new ControleEmprego(dados).getFuncaoEmprego();
			listaEmpregosCadastrados = new JList<String>(listaFuncoes);
			janela = new JFrame("Empregos");
			titulo = new JLabel("Empregos Cadastrados");
			cadastroEmprego = new JButton("Cadastrar");
			refreshEmprego = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaEmpregosCadastrados.setBounds(20, 50, 350, 120);
			listaEmpregosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaEmpregosCadastrados.setVisibleRowCount(10);

			cadastroEmprego.setBounds(70, 177, 100, 30);
			refreshEmprego.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaEmpregosCadastrados);
			janela.add(cadastroEmprego);
			janela.add(refreshEmprego);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroEmprego.addActionListener(this);
			refreshEmprego.addActionListener(this);
			listaEmpregosCadastrados.addListSelectionListener(this);

			break;

		case 2:// Mostrar dados de estagios cadastrados (JList)
			
			listaFuncoes = new ControleEstagio(dados).getFuncaoEstagio();
			listaEstagiosCadastrados = new JList<String>(listaFuncoes);
			janela = new JFrame("Estagios");
			titulo = new JLabel("Estagios Cadastrados");
			cadastroEstagio = new JButton("Cadastrar");
			refreshEstagio = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaEstagiosCadastrados.setBounds(20, 50, 350, 120);
			listaEstagiosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaEstagiosCadastrados.setVisibleRowCount(10);


			cadastroEstagio.setBounds(70, 177, 100, 30);
			refreshEstagio.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaEstagiosCadastrados);
			janela.add(cadastroEstagio);
			janela.add(refreshEstagio);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroEstagio.addActionListener(this);
			refreshEstagio.addActionListener(this);
			listaEstagiosCadastrados.addListSelectionListener(this);
			break;

		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo para definir a caracteristica da tela de listagem. A depender do parametro op, a lista sera destinada a empregos ou estagios
	 * os quais tenham o atributo Funcao igual ao parametro s
	 * @param d
	 * @param op
	 * @param s
	 */
	
	public void mostrarDados(ControleDados d, int op, String s){
		
		dados = d;
		t = true;
		index = dados.getIndex(s, op);

		switch (op) {
		case 1:// Mostrar dados de empregos cadastrados (JList)
			
			ControleEmprego c_emprego = new ControleEmprego(d.buscarEmpregoDados(s));
			listaFuncoes = c_emprego.getFuncaoEmprego();
			listaEmpregosCadastrados = new JList<String>(listaFuncoes);
			
			janela = new JFrame("Empregos");
			titulo = new JLabel("Empregos Encontrados");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaEmpregosCadastrados.setBounds(20, 50, 350, 120);
			listaEmpregosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaEmpregosCadastrados.setVisibleRowCount(10);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaEmpregosCadastrados);

			janela.setSize(400, 250);
			janela.setVisible(true);

			listaEmpregosCadastrados.addListSelectionListener(this);

			break;

		case 2:// Mostrar dados de estagios cadastrados (JList)
			
			ControleEstagio c_estagio = new ControleEstagio(d.buscarEstagioDados(s));
			listaFuncoes = c_estagio.getFuncaoEstagio();
			listaEstagiosCadastrados = new JList<String>(listaFuncoes);
			
			janela = new JFrame("Estagios");
			titulo = new JLabel("Estagios Encontrados");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaEstagiosCadastrados.setBounds(20, 50, 350, 120);
			listaEstagiosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaEstagiosCadastrados.setVisibleRowCount(10);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaEstagiosCadastrados);

			janela.setSize(400, 250);
			janela.setVisible(true);

			listaEstagiosCadastrados.addListSelectionListener(this);
			break;

		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Captura eventos relacionados aos botões da interface. Aciona o metodo de cadastro de uma nova vaga
	 * ou refresh na JList
	 */
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		
		//Cadastro de novo aluno
		if(src == cadastroEmprego)
			new TelaDetalheVaga().inserirEditar(1, dados, this, 0);

		//Cadastro de novo professor
		if(src == cadastroEstagio)
			new TelaDetalheVaga().inserirEditar(2, dados, this, 0);

		// Atualiza a lista de nomes de empregos mostrada no JList
		if(src == refreshEmprego) {
			listaEmpregosCadastrados.setListData(new ControleEmprego(dados).getFuncaoEmprego());			
			listaEmpregosCadastrados.updateUI();
		}

		// Atualiza a lista de nomes de estagios mostrada no JList
		if(src == refreshEstagio) {
			listaEstagiosCadastrados.setListData(new ControleEstagio(dados).getFuncaoEstagio());
			listaEstagiosCadastrados.updateUI();
		}

	}

	/**
	 * Captura eventos relacionados ao JList. Aciona uma tela de detalhamento
	 */
	public void valueChanged(ListSelectionEvent e) {
		
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaEmpregosCadastrados && t == false) {
			new TelaDetalheVaga().inserirEditar(3, dados, this, 
					listaEmpregosCadastrados.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaEstagiosCadastrados && t == false) {
			new TelaDetalheVaga().inserirEditar(4, dados, this, 
					listaEstagiosCadastrados.getSelectedIndex());
		}
		
		if(e.getValueIsAdjusting() && src == listaEmpregosCadastrados && t == true) {
			
			int i = index[listaEmpregosCadastrados.getSelectedIndex()];
			
			new TelaDetalheVaga().inserirEditar(3, dados, this, i);
		}

		if(e.getValueIsAdjusting() && src == listaEstagiosCadastrados && t == true) {
			
			int i = index[listaEstagiosCadastrados.getSelectedIndex()];
			
			new TelaDetalheVaga().inserirEditar(4, dados, this, i);
		}
	}
	
}
