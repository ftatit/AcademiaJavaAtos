package com.ufnatos.copa2022.modelo;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

	@Entity
	public class Jogos {
		@Id 
		@NotNull ( message = "Id de jogo inválido")
		private Long idJogo;
		
		@NotNull 
		@Size(max = 20, message = "Grupo inválido")
		private String grupo;
		
		@NotNull 
		@Size(min = 3,max = 50, message = "O nome do time deve ter entre 3-50 carateres")
		private String time1; 
		
		@Size(max = 3, message = "o numero de gols esta incorreto")
		private String golsT1;
		
		private String x;	
		
		@Size(max = 3, message = "o numero de gols esta incorreto")
		private String golsT2;
		
		@NotNull 
		@Size(min = 3,max = 50, message = "O nome do time deve ter entre 3-50 carateres")
		private String time2; 
		
		@Basic
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		private Date dataJogo;
		
		@NotNull (message = "Preencha o horário do jogo no formato 00:00:00")
		private Time hora;
		
		@NotNull (message = "Preencha com o local do jogo")
		@Size(max = 40, message = "O nome do estádio deve ter no máximo 40 carateres")
		private String estadio;

		
		//GETTER AND SETTERS:		
		
		public Long getIdJogo() {
			return idJogo;
		}

		public void setIdJogo(Long idJogo) {
			this.idJogo = idJogo;
		}
		

		public String getGrupo() {
			return grupo;
		}

		
		public void setGrupo(String grupo) {
			this.grupo = grupo;
		}

		public String getTime1() {
			return time1;
		}

		public void setTime1(String time1) {
			this.time1 = time1;
		}

		public String getGolsT1() {
			return golsT1;
		}

		public void setGolsT1(String golsT1) {
			this.golsT1 = golsT1;
		}
		

		public String getX() {
			return x;
		}

		public void setX(String x) {
			this.x = x;
		}

		public String getGolsT2() {
			return golsT2;
		}

		public void setGolsT2(String golsT2) {
			this.golsT2 = golsT2;
		}


		public String getTime2() {
			return time2;
		}

		public void setTime2(String time2) {
			this.time2 = time2;
		}

		public Date getDataJogo() {
			return dataJogo;
		}

		public void setDataJogo(Date dataJogo) {
			this.dataJogo = dataJogo;
		}

		public Time getHora() {
			return hora;
		}

		public void setHora(Time hora) {
			this.hora = hora;
		}

		public String getEstadio() {
			return estadio;
		}

		public void setEstadio(String estadio) {
			this.estadio = estadio;
		}				
	
}
