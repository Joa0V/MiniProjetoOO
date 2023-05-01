package entrega1.modelo;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Perfil conta = new Perfil();
		Beneficio beneficio = new Beneficio();
		VagaEmprego vaga = new VagaEmprego();
		Scanner leitor = new Scanner(System.in);
		
		conta.setNome("Maria");
		conta.setIdade(26);
		conta.setCpf("11122233344");
		conta.setEndereco("Brasilia");
		conta.setFormacao("Graduacao UnB");
		conta.setCargoDesejado("Gerente de projetos");
		conta.setSalario(10500);
		
		beneficio.setTipo("Plano de saude");
		beneficio.setPorcentagemSalario(10);
		beneficio.controlarCusto(beneficio.getPorcentagemSalario());
		
		vaga.setFuncao("Gerente de projetos");
		vaga.setSalario(10000);
		vaga.setFormacao("Graduacao ensino superior");
		vaga.setEmpresa("DFtech");
		vaga.setStatus(true);
		
		System.out.println(vaga.toString() + "\n" + beneficio.toString() + "\n\n" + conta.toString() + "\n");
		System.out.println("Gostaria de candidatar-se? (1 ou 0)\n");
		int resp = leitor.nextInt();
		
		if(resp == 1) {
			vaga.setStatus(false);
			System.out.println("\nVoce aplicou para a vaga!\n" + vaga.toString());
		}
		
		
		leitor.close();
	}
	
}
