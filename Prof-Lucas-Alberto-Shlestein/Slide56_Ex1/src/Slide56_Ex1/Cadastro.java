package Slide56_Ex1;

import java.util.Scanner;

public class Cadastro {

	public static void main(String[] args) {
		
		String resposta = "";
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("Qual opção gostaria de seguir? 1ª Opção: Gostaria de informar o nome e a idade da pessoa; 2ª Opção: Gostaria de informar apenas a idade?");
		System.out.println("1ª Opção: Gostaria de informar o nome e a idade da pessoa");
		System.out.println("2ª Opção: Gostaria de informar apenas a idade?");
		System.out.println("Para a 1ª Opção, digite: '1' e para a 2ª Opção digite: '2'");
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
