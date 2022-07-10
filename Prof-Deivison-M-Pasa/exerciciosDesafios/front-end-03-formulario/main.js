function salvarDados(nome, sobrenome, email, login, senha, cep, endereco, complemento, bairro, cidade, estado, github, academia, professor, termosLegais, informativo ) {
    pessoas = document.getElementById("dados");    
    var qtdlLinhas = pessoas.rows.length;
    var linha = pessoas.insertRow(qtdlLinhas);
    var linhaParam;

    var cellNome = linha.insertCell(0);
    var cellSobrenome = linha.insertCell(1);
    var cellEmail = linha.insertCell(2);
    var cellLogin = linha.insertCell(3);
    var cellSenha = linha.insertCell(4);
    var cellCep = linha.insertCell(5);
    var cellEndereco = linha.insertCell(6);
    var cellComplemento = linha.insertCell(7);
    var cellBairro = linha.insertCell(8);
    var cellCidade = linha.insertCell(9);
    var cellEstado = linha.insertCell(10);
    var cellGithub = linha.insertCell(11);
    var cellAcademia = linha.insertCell(12);
    var cellProfessor = linha.insertCell(13);
    var cellTermosleagais = linha.insertCell(14);
    var cellInformativo = linha.insertCell(15);
  

   // cellNome.innerHTML = qtdlLinhas;
    cellNome.innerHTML = nome;
    cellSobrenome.innerHTML = sobrenome;
    cellEmail.innerHTML = email;
    cellLogin.innerHTML = login;
    cellSenha.innerHTML = senha;
    cellCep.innerHTML = cep; 
    cellEndereco.innerHTML =  endereco;
    cellComplemento.innerHTML = complemento;
    cellBairro.innerHTML = bairro;
    cellCidade.innerHTML = cidade;
    cellEstado.innerHTML = estado;
    cellGithub.innerHTML = github;
    cellAcademia.innerHTML = academia;
    cellProfessor.innerHTML = professor;
    cellTermosleagais.innerHTML = termosLegais;
    cellInformativo.innerHTML = informativo;
    


    preencheCamposForm();

}