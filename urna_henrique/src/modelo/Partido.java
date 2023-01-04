package modelo;

import java.util.ArrayList;

public class Partido {
	private String nome;
	private ArrayList<Candidato> candidatos;
	
	public Partido() {
		this.candidatos = new ArrayList<Candidato>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}
	
	public void adicionarCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}

}
