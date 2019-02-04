package com.example.cassa.entrainementprojettut.echecs.plateau;


import com.example.cassa.entrainementprojettut.echecs.pion.Piondef;

public  class Case {

	private int idx;
	private int idy;
	private Piondef pionDessus=null;
	private String couleurCase;
	
	
	public Piondef getPionDessus() {
		return pionDessus;
	}
	public void setPionDessus(Piondef pionDessus) {
		this.pionDessus = pionDessus;
	}
	
	
	public int getIdx() {
		return idx;
	}
	public int getIdy() {
		return idy;
	}
	public String getCouleurCase() {
		return couleurCase;
	}

	public Case(int idx, int idy, Piondef pionDessus,boolean defcolor ) {
		
		this.idx = idx;
		this.idy = idy;
		this.pionDessus = pionDessus;
		if(defcolor) {
			this.couleurCase="wh";
		}else {
			this.couleurCase="bl";
		}
	}
	@Override
	public String toString() {
		if(this.pionDessus==null)	
		return this.couleurCase;
		else
		return this.getPionDessus().getNomPion()+this.getPionDessus().getCouleur().charAt(0) ;
	}
	
	
	
	
}
