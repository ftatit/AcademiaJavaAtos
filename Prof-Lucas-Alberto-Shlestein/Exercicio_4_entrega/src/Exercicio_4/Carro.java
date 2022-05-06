package Exercicio_4;

public class Carro {
	
	public String fabricante = "Fiat";

	public String modelo = "Palio";
	
	public void configuraDados(String fabricanteCarro, String modeloCarro) {
		fabricante = fabricanteCarro;
		modelo = modeloCarro;
	}
	
	public void exibirDados() {
	
		System.out.println("Dados do carro: " + fabricante + " " + modelo);
	}


}
