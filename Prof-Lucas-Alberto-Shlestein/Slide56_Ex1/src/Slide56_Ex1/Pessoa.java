package Slide56_Ex1;

public class Pessoa {
	public String nome = "";
	public int idade;
	
	//1º Construtor (recebendo nome e idade da pessoa):
	public void insereDados(String nomePessoa, int idadePessoa) {
		this.nome = nomePessoa;
		this.idade = idadePessoa;
	}
	
	//2º Construtor (recebendo apenas a idade da pessoa):
	public void insereDados(int idadePessoa) {
		this.idade = idadePessoa;
	}
	
	public void exibeDados() {
		if(!nome.isEmpty()) {
			System.out.println("O nome da pessoa é : "+ nome +", e a sua idade é de: "+ idade + " anos.");
		} else {
			System.out.println("A idade da pessoa é: "+ idade + " anos.");
		}
	}
}
