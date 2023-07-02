package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.*;

/**
 * Classe destinada ao teste dos metodos da classe ControleDados
 *
 */

class TesteControleDados {

	ControleDados d = new ControleDados();
	
	/**
	 * Metodo para testar o metodo verificarEmpregoControle.
	 * Retorno esperado: true
	 */
	
	@Test
	void deveRetornarTrueVerificar() {
		
		String[] s = {"Supervisor", "Gerente", "Consultor vendas", "Lead Desing", "Gerente"};
		
		assertEquals(true, d.verificarEmpregoControle(s[0]));
		assertEquals(true, d.verificarEmpregoControle(s[1]));
		assertEquals(true, d.verificarEmpregoControle(s[2]));
		assertEquals(true, d.verificarEmpregoControle(s[3]));
		assertEquals(true, d.verificarEmpregoControle(s[4]));
	}
	
	/**
	 * Metodo para testar o metodo verificarEmpregoControle.
	 * Retorno esperado: false
	 */
	
	@Test
	void deveRetornarFalseVerificar() {
		
		String[] s = {"Mecanico", "Dentista"};
		
		assertEquals(false, d.verificarEmpregoControle(s[0]));
		assertEquals(false, d.verificarEmpregoControle(s[1]));
	}
	
	/**
	 * Metodo para testar o metodo getIndex
	 * Retorno esperado: 2, 1, 4
	 */
	
	@Test
	void deveRetornarArrayInt() {
		
		assertEquals(2, d.getIndex("gerente", 1).length);
		assertEquals(1, d.getIndex("gerente", 1)[0]);
		assertEquals(4, d.getIndex("gerente", 1)[1]);
	}
	
	/**
	 * Metodo para testar o metodo removerEmprego
	 * Retorno esperado: true
	 */
	
	@Test
	void deveRetornarTrueRemover() {
		
		assertEquals(true, d.removerEmprego(1));
		assertEquals(true, d.removerEmprego(2));
	}
	
	/**
	 * Metodo para testar o metodo inserirEditarEmprego
	 * Retorno esperado: true
	 */
	
	@Test
	void deveRetornarTrueInserirEditar() {
		
		String[] s = {"0", "Supervisor", "Graduacao ensino superior", "4500", "AtoT", "Plano de saude0"};
		
		assertEquals(true, d.inserirEditarEmprego(s));
	}
	
	/**
	 * Metodo para testar o metodo inserirEditarEmprego
	 * Retorno esperado: false
	*/ 
	
	@Test
	void deveRetornarFalseInserirEditar() {
		
		String[] s = {"0", "Supervisor", "Graduacao ensino superior", "quatro mil e quinhentos", "AtoT", "Plano de saude0"};
		
		assertEquals(false, d.inserirEditarEmprego(s));
	}
}
