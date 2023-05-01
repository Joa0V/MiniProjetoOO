package entrega1.modelo;

public class Perfil extends Pessoa{

	private String formacao;
	private String cargo_desejado;
	private float salario;
	


	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public String getCargoDesejado() {
		return cargo_desejado;
	}
	public void setCargoDesejado(String cargo_desejado) {
		this.cargo_desejado = cargo_desejado;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}	
	
	public String toString() {
		
		return "Nome: " + this.getNome() + "\nIdade: " + this.getIdade() + "\nCPF: " + this.getCpf() + "\nEndereco: " + this.getEndereco() + "\nFormacao: " + this.getFormacao() + 
				"\nCargo desejado: " + this.getCargoDesejado() + "\nObjetivo salarial: " + this.salario + " reais";
	}
}
