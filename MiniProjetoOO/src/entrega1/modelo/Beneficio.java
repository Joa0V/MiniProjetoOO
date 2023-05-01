package entrega1.modelo;

public class Beneficio implements PadraoBeneficio{
	
	private String tipo;
	private float porcentagem_salario;
	private boolean status;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public float getPorcentagemSalario() {
		return porcentagem_salario;
	}
	public void setPorcentagemSalario(float porcentagem_salario) {
		this.porcentagem_salario = porcentagem_salario;
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void controlarCusto(float porcentagem_salario) {
		
		if (porcentagem_salario <= 20) {
			this.status = true;
		}
		else {
			this.status = false;
		}
	}
	
	
	public String toString() {
		
		String status = getStatus() ? "validado" : "invalidado";
		
		return "Tipo de beneficio: " + this.getTipo() +"\nPorcentagem do salario: " + this.getPorcentagemSalario() +"%\nStatus: " + status;
	}
}
