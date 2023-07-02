package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

/**
 * Classe que implementa a tela inicial da aplicacao
 *
 */

public class TelaInicial implements ActionListener{

	private static JFrame janela = new JFrame("Aplicacao");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton emprego = new JButton("Emprego");
	private static JButton estagio = new JButton("Estagio");
	private static JButton busca = new JButton("Busca");
	private static JTextField campoBusca = new JTextField(200);
	public static ControleDados dados = new ControleDados();

	/**
	 * Metodo para definir as caracteristicas de TelaInicial
	 */
	
	public TelaInicial() {
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 150, 30);		
		emprego.setBounds(140, 50, 100, 30);
		estagio.setBounds(140, 100, 100, 30);
		busca.setBounds(140, 150, 100, 30);
		campoBusca.setBounds(140, 200, 100, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(emprego);
		janela.add(estagio);
		janela.add(busca);
		janela.add(campoBusca);
		
		janela.setSize(400, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		TelaInicial menu = new TelaInicial();
		
		emprego.addActionListener(menu);
		estagio.addActionListener(menu);
		busca.addActionListener(menu);
	}
	
	/**
	 * Metodo que implementa o metodo actionPerformed da interface ActionListener. Tem a funcao de implementar as funcionalidades de interacao com os
	 * botoes da tela de inicio
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == emprego)
			new TelaVagaEmprego().mostrarDados(dados, 1);
		
		if(src == estagio)
			new TelaVagaEmprego().mostrarDados(dados, 2);
		
		if(src == busca) {
			
			//Apresenta a busca em vagas de emprego
			if(dados.verificarEmpregoControle(campoBusca.getText()) == true && dados.buscarEmpregoDados(campoBusca.getText()) != null) {
			
				new TelaVagaEmprego().mostrarDados(dados, 1, campoBusca.getText());
			}
			//Apresenta erro na busca (nao foram encontradas correspondencias na instancia de ControleDados
			if(dados.verificarNulidadeControle(campoBusca.getText()))
				mensagemErroBusca();
			else{
				//Apresenta a busca em vagas de estagio
				if(dados.verificarEstagioControle(campoBusca.getText()) == true && dados.buscarEstagioDados(campoBusca.getText()) != null) {
					
				new TelaVagaEmprego().mostrarDados(dados, 2, campoBusca.getText());
				}
			}
			
		}

	}
	/**
	 * Metodo para mensagem em caso de falha na busca
	 */
	public void mensagemErroBusca() {
		JOptionPane.showMessageDialog(null, "Vaga não encontrada!", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
}
