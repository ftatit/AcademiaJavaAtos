package com.ufnatos.copa2022.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

	
	@Entity
	public class Bolao {
		@Id
		@NotNull 
		@Size(max = 20, message = "usuário inválido")
		private String nomeUsuario;
		
		@CPF(message = "CPF inválido")
		private String cpf;
		
		@Email(message = "Email inválido")
		private String email;
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo1; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo2; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo3; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo4; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo5; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo6; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo7; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo8; 			
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo9; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo10; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo11; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo12; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo13; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo14; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo15; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo16; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo17; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo18; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo19; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo20; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo21; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo22; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo23; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo24; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo25; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo26; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo27; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo28; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo29; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo30; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo31; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo32; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo33; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo34; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo35; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo36; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo37; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo38; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo39; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo40; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo41; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo42; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo43; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo44; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo45; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado") 
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo46; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo47; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 3, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo48; 
		
		
	//SEGUNDA FASE - MATA A MATA:
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x3(2-5)'")
		private String bolaoJogo49; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo50; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x3(2-5)'")
		private String bolaoJogo51; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo52; 
		
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x3(2-5)'")
		private String bolaoJogo53; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo54; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x3(2-5)'")
		private String bolaoJogo55; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo56; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x3(2-5)'")
		private String bolaoJogo57; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo58; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x3(2-5)'")
		private String bolaoJogo59; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo60; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x3(2-5)'")
		private String bolaoJogo61; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo62; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x3(2-5)'")
		private String bolaoJogo63; 
		
		@NotEmpty(message = "O Resultado do jogo deve ser informado")
		@Size(min = 2,max = 8, message = "Insira o resultado no formato '3x1'")
		private String bolaoJogo64; 
							
		
		//GETTER AND SETTERS:		
		
		public String getNomeUsuario() {
			return nomeUsuario;
		}
		
		public void setNomeUsuario(String nomeUsuario) {
			this.nomeUsuario = nomeUsuario;
		}

		

		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}
				

		public String getBolaoJogo1() {
			return bolaoJogo1;
		}


		public void setBolaoJogo1(String bolaoJogo1) {
			this.bolaoJogo1 = bolaoJogo1;
		}


		public String getBolaoJogo2() {
			return bolaoJogo2;
		}


		public void setBolaoJogo2(String bolaoJogo2) {
			this.bolaoJogo2 = bolaoJogo2;
		}


		public String getBolaoJogo3() {
			return bolaoJogo3;
		}


		public void setBolaoJogo3(String bolaoJogo3) {
			this.bolaoJogo3 = bolaoJogo3;
		}


		public String getBolaoJogo4() {
			return bolaoJogo4;
		}


		public void setBolaoJogo4(String bolaoJogo4) {
			this.bolaoJogo4 = bolaoJogo4;
		}


		public String getBolaoJogo5() {
			return bolaoJogo5;
		}


		public void setBolaoJogo5(String bolaoJogo5) {
			this.bolaoJogo5 = bolaoJogo5;
		}


		public String getBolaoJogo6() {
			return bolaoJogo6;
		}


		public void setBolaoJogo6(String bolaoJogo6) {
			this.bolaoJogo6 = bolaoJogo6;
		}


		public String getBolaoJogo7() {
			return bolaoJogo7;
		}


		public void setBolaoJogo7(String bolaoJogo7) {
			this.bolaoJogo7 = bolaoJogo7;
		}


		public String getBolaoJogo8() {
			return bolaoJogo8;
		}


		public void setBolaoJogo8(String bolaoJogo8) {
			this.bolaoJogo8 = bolaoJogo8;
		}

		public String getBolaoJogo9() {
			return bolaoJogo9;
		}

		public void setBolaoJogo9(String bolaoJogo9) {
			this.bolaoJogo9 = bolaoJogo9;
		}

		public String getBolaoJogo10() {
			return bolaoJogo10;
		}

		public void setBolaoJogo10(String bolaoJogo10) {
			this.bolaoJogo10 = bolaoJogo10;
		}

		public String getBolaoJogo11() {
			return bolaoJogo11;
		}

		public void setBolaoJogo11(String bolaoJogo11) {
			this.bolaoJogo11 = bolaoJogo11;
		}

		public String getBolaoJogo12() {
			return bolaoJogo12;
		}

		public void setBolaoJogo12(String bolaoJogo12) {
			this.bolaoJogo12 = bolaoJogo12;
		}

		public String getBolaoJogo13() {
			return bolaoJogo13;
		}

		public void setBolaoJogo13(String bolaoJogo13) {
			this.bolaoJogo13 = bolaoJogo13;
		}

		public String getBolaoJogo14() {
			return bolaoJogo14;
		}

		public void setBolaoJogo14(String bolaoJogo14) {
			this.bolaoJogo14 = bolaoJogo14;
		}

		public String getBolaoJogo15() {
			return bolaoJogo15;
		}

		public void setBolaoJogo15(String bolaoJogo15) {
			this.bolaoJogo15 = bolaoJogo15;
		}

		public String getBolaoJogo16() {
			return bolaoJogo16;
		}

		public void setBolaoJogo16(String bolaoJogo16) {
			this.bolaoJogo16 = bolaoJogo16;
		}

		public String getBolaoJogo17() {
			return bolaoJogo17;
		}

		public void setBolaoJogo17(String bolaoJogo17) {
			this.bolaoJogo17 = bolaoJogo17;
		}

		public String getBolaoJogo18() {
			return bolaoJogo18;
		}

		public void setBolaoJogo18(String bolaoJogo18) {
			this.bolaoJogo18 = bolaoJogo18;
		}

		public String getBolaoJogo19() {
			return bolaoJogo19;
		}

		public void setBolaoJogo19(String bolaoJogo19) {
			this.bolaoJogo19 = bolaoJogo19;
		}

		public String getBolaoJogo20() {
			return bolaoJogo20;
		}

		public void setBolaoJogo20(String bolaoJogo20) {
			this.bolaoJogo20 = bolaoJogo20;
		}

		public String getBolaoJogo21() {
			return bolaoJogo21;
		}

		public void setBolaoJogo21(String bolaoJogo21) {
			this.bolaoJogo21 = bolaoJogo21;
		}

		public String getBolaoJogo22() {
			return bolaoJogo22;
		}

		public void setBolaoJogo22(String bolaoJogo22) {
			this.bolaoJogo22 = bolaoJogo22;
		}

		public String getBolaoJogo23() {
			return bolaoJogo23;
		}

		public void setBolaoJogo23(String bolaoJogo23) {
			this.bolaoJogo23 = bolaoJogo23;
		}

		public String getBolaoJogo24() {
			return bolaoJogo24;
		}

		public void setBolaoJogo24(String bolaoJogo24) {
			this.bolaoJogo24 = bolaoJogo24;
		}

		public String getBolaoJogo25() {
			return bolaoJogo25;
		}

		public void setBolaoJogo25(String bolaoJogo25) {
			this.bolaoJogo25 = bolaoJogo25;
		}

		public String getBolaoJogo26() {
			return bolaoJogo26;
		}

		public void setBolaoJogo26(String bolaoJogo26) {
			this.bolaoJogo26 = bolaoJogo26;
		}

		public String getBolaoJogo27() {
			return bolaoJogo27;
		}

		public void setBolaoJogo27(String bolaoJogo27) {
			this.bolaoJogo27 = bolaoJogo27;
		}

		public String getBolaoJogo28() {
			return bolaoJogo28;
		}

		public void setBolaoJogo28(String bolaoJogo28) {
			this.bolaoJogo28 = bolaoJogo28;
		}

		public String getBolaoJogo29() {
			return bolaoJogo29;
		}

		public void setBolaoJogo29(String bolaoJogo29) {
			this.bolaoJogo29 = bolaoJogo29;
		}

		public String getBolaoJogo30() {
			return bolaoJogo30;
		}

		public void setBolaoJogo30(String bolaoJogo30) {
			this.bolaoJogo30 = bolaoJogo30;
		}

		public String getBolaoJogo31() {
			return bolaoJogo31;
		}

		public void setBolaoJogo31(String bolaoJogo31) {
			this.bolaoJogo31 = bolaoJogo31;
		}

		public String getBolaoJogo32() {
			return bolaoJogo32;
		}

		public void setBolaoJogo32(String bolaoJogo32) {
			this.bolaoJogo32 = bolaoJogo32;
		}

		public String getBolaoJogo33() {
			return bolaoJogo33;
		}

		public void setBolaoJogo33(String bolaoJogo33) {
			this.bolaoJogo33 = bolaoJogo33;
		}

		public String getBolaoJogo34() {
			return bolaoJogo34;
		}

		public void setBolaoJogo34(String bolaoJogo34) {
			this.bolaoJogo34 = bolaoJogo34;
		}

		public String getBolaoJogo35() {
			return bolaoJogo35;
		}

		public void setBolaoJogo35(String bolaoJogo35) {
			this.bolaoJogo35 = bolaoJogo35;
		}

		public String getBolaoJogo36() {
			return bolaoJogo36;
		}

		public void setBolaoJogo36(String bolaoJogo36) {
			this.bolaoJogo36 = bolaoJogo36;
		}

		public String getBolaoJogo37() {
			return bolaoJogo37;
		}

		public void setBolaoJogo37(String bolaoJogo37) {
			this.bolaoJogo37 = bolaoJogo37;
		}

		public String getBolaoJogo38() {
			return bolaoJogo38;
		}

		public void setBolaoJogo38(String bolaoJogo38) {
			this.bolaoJogo38 = bolaoJogo38;
		}

		public String getBolaoJogo39() {
			return bolaoJogo39;
		}

		public void setBolaoJogo39(String bolaoJogo39) {
			this.bolaoJogo39 = bolaoJogo39;
		}

		public String getBolaoJogo40() {
			return bolaoJogo40;
		}

		public void setBolaoJogo40(String bolaoJogo40) {
			this.bolaoJogo40 = bolaoJogo40;
		}

		public String getBolaoJogo41() {
			return bolaoJogo41;
		}

		public void setBolaoJogo41(String bolaoJogo41) {
			this.bolaoJogo41 = bolaoJogo41;
		}

		public String getBolaoJogo42() {
			return bolaoJogo42;
		}

		public void setBolaoJogo42(String bolaoJogo42) {
			this.bolaoJogo42 = bolaoJogo42;
		}

		public String getBolaoJogo43() {
			return bolaoJogo43;
		}

		public void setBolaoJogo43(String bolaoJogo43) {
			this.bolaoJogo43 = bolaoJogo43;
		}

		public String getBolaoJogo44() {
			return bolaoJogo44;
		}

		public void setBolaoJogo44(String bolaoJogo44) {
			this.bolaoJogo44 = bolaoJogo44;
		}

		public String getBolaoJogo45() {
			return bolaoJogo45;
		}

		public void setBolaoJogo45(String bolaoJogo45) {
			this.bolaoJogo45 = bolaoJogo45;
		}

		public String getBolaoJogo46() {
			return bolaoJogo46;
		}

		public void setBolaoJogo46(String bolaoJogo46) {
			this.bolaoJogo46 = bolaoJogo46;
		}

		public String getBolaoJogo47() {
			return bolaoJogo47;
		}

		public void setBolaoJogo47(String bolaoJogo47) {
			this.bolaoJogo47 = bolaoJogo47;
		}

		public String getBolaoJogo48() {
			return bolaoJogo48;
		}

		public void setBolaoJogo48(String bolaoJogo48) {
			this.bolaoJogo48 = bolaoJogo48;
		}

		public String getBolaoJogo49() {
			return bolaoJogo49;
		}

		public void setBolaoJogo49(String bolaoJogo49) {
			this.bolaoJogo49 = bolaoJogo49;
		}

		public String getBolaoJogo50() {
			return bolaoJogo50;
		}

		public void setBolaoJogo50(String bolaoJogo50) {
			this.bolaoJogo50 = bolaoJogo50;
		}

		public String getBolaoJogo51() {
			return bolaoJogo51;
		}

		public void setBolaoJogo51(String bolaoJogo51) {
			this.bolaoJogo51 = bolaoJogo51;
		}

		public String getBolaoJogo52() {
			return bolaoJogo52;
		}

		public void setBolaoJogo52(String bolaoJogo52) {
			this.bolaoJogo52 = bolaoJogo52;
		}

		public String getBolaoJogo53() {
			return bolaoJogo53;
		}

		public void setBolaoJogo53(String bolaoJogo53) {
			this.bolaoJogo53 = bolaoJogo53;
		}

		public String getBolaoJogo54() {
			return bolaoJogo54;
		}

		public void setBolaoJogo54(String bolaoJogo54) {
			this.bolaoJogo54 = bolaoJogo54;
		}

		public String getBolaoJogo55() {
			return bolaoJogo55;
		}

		public void setBolaoJogo55(String bolaoJogo55) {
			this.bolaoJogo55 = bolaoJogo55;
		}

		public String getBolaoJogo56() {
			return bolaoJogo56;
		}

		public void setBolaoJogo56(String bolaoJogo56) {
			this.bolaoJogo56 = bolaoJogo56;
		}

		public String getBolaoJogo57() {
			return bolaoJogo57;
		}

		public void setBolaoJogo57(String bolaoJogo57) {
			this.bolaoJogo57 = bolaoJogo57;
		}

		public String getBolaoJogo58() {
			return bolaoJogo58;
		}

		public void setBolaoJogo58(String bolaoJogo58) {
			this.bolaoJogo58 = bolaoJogo58;
		}

		public String getBolaoJogo59() {
			return bolaoJogo59;
		}

		public void setBolaoJogo59(String bolaoJogo59) {
			this.bolaoJogo59 = bolaoJogo59;
		}

		public String getBolaoJogo60() {
			return bolaoJogo60;
		}

		public void setBolaoJogo60(String bolaoJogo60) {
			this.bolaoJogo60 = bolaoJogo60;
		}

		public String getBolaoJogo61() {
			return bolaoJogo61;
		}

		public void setBolaoJogo61(String bolaoJogo61) {
			this.bolaoJogo61 = bolaoJogo61;
		}

		public String getBolaoJogo62() {
			return bolaoJogo62;
		}

		public void setBolaoJogo62(String bolaoJogo62) {
			this.bolaoJogo62 = bolaoJogo62;
		}

		public String getBolaoJogo63() {
			return bolaoJogo63;
		}

		public void setBolaoJogo63(String bolaoJogo63) {
			this.bolaoJogo63 = bolaoJogo63;
		}

		public String getBolaoJogo64() {
			return bolaoJogo64;
		}

		public void setBolaoJogo64(String bolaoJogo64) {
			this.bolaoJogo64 = bolaoJogo64;
		}				
	
}
