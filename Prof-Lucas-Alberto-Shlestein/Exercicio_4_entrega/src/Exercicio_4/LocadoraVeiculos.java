package Exercicio_4;

public class LocadoraVeiculos {

	public static void main(String[] args) {
		
		System.out.println("Dados de locação de carros: ");
		System.out.println();
		
		// Instanciando a classe Carro:
		Carro carro = new Carro();

		carro.exibirDados();
		System.out.println();
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - -");
		
		System.out.println("Dados de locação de motos: ");
		System.out.println();
		
		Moto moto = new Moto();
		moto.exibirDados();

		System.out.println();

		Moto moto2 = new Moto();
		moto2.marca = "Yamaha";
		moto2.modelo = "Neo";
		moto2.cilindradas = "125cc";
		System.out.println("Dados da moto 2: Marca: " + moto2.marca + ", Modelo: " + moto2.modelo + ", Cilindrada: "
				+ moto2.cilindradas);
		System.out.println();

		Moto moto3 = new Moto();
		moto3.marca = "BMW";
		moto3.modelo = "G 450";
		moto3.cilindradas = "450cc";
		System.out.println("Dados da moto 3: Marca: " + moto3.marca + ", Modelo: " + moto3.modelo + ", Cilindrada: "
				+ moto3.cilindradas);
	

	}

}
