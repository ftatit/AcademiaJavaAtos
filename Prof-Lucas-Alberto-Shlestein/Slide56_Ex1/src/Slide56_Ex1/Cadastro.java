package Slide56_Ex1;

import java.util.Scanner;

public class Cadastro {

	public static void main(String[] args) {
		
		String resposta = "";
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("Qual op��o gostaria de seguir? 1� Op��o: Gostaria de informar o nome e a idade da pessoa; 2� Op��o: Gostaria de informar apenas a idade?");
		System.out.println("1� Op��o: Gostaria de informar o nome e a idade da pessoa");
		System.out.println("2� Op��o: Gostaria de informar apenas a idade?");
		System.out.println("Para a 1� Op��o, digite: '1' e para a 2� Op��o digite: '2'");
		resposta = leitura.nextLine();
		
				
		if(resposta.equals("1")) {
			
			Pessoa pessoa = new Pessoa();
			
			System.out.println("Insira o nome da pessoa: ");
			//Scanner leitura;
			pessoa.nome = leitura.nextLine();
			
			System.out.println("Insira a idade da pessoa: ");
			pessoa.idade = leitura.nextInt();
			
			pessoa.insereDados(pessoa.nome, pessoa.idade);
			pessoa.exibeDados();
			
		} else {
			Pessoa pessoa = new Pessoa();
			
			System.out.println("Insira apenas a idade da pessoa: ");
			pessoa.idade = leitura.nextInt();
			
			pessoa.insereDados(pessoa.idade);
			pessoa.exibeDados();
		}
		
		
	}

}
