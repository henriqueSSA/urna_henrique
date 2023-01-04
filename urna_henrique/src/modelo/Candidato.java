package modelo;

import java.awt.image.BufferedImage;

public class Candidato {
	private int votos;
	private String nome;
	private Integer numero;
	private BufferedImage img;
	public static int votosBranco=0,votosNulos=0;
	
	public Candidato() {
		this.votos=0;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos ++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
	

}
