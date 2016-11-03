package model;

public class Rank {

	Integer posicao;
	String site;

	public Rank() {
		// TODO Auto-generated constructor stub
	}

	public Rank(Integer posicao, String site) {
		super();
		this.posicao = posicao;
		this.site = site;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	
}
