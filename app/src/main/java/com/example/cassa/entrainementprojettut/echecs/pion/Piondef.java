package com.example.cassa.entrainementprojettut.echecs.pion;

public abstract class Piondef {
	private int posX;
	private int posy;
	private String nomPion;
	private  String couleur;
	private int  compteur=0;
	/*
	 * 
	 * gettters et setters
	 * 
	 * */
	
	public String getNomPion() {
		return nomPion;
	}
	public int getCompteur() {
		return compteur;
	}
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public void setNomPion(String nomPion) {
		this.nomPion = nomPion;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	public Piondef(int x, int y,String name) {
		this.posX=x;
		this.posy=y;
		this.nomPion=name;
		
		
	}
}

