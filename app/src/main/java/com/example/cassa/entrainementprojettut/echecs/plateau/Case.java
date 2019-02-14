package com.example.cassa.entrainementprojettut.echecs.plateau;
import com.example.cassa.entrainementprojettut.echecs.pion.Piece;

import java.util.List;
import java.util.Observer;

public class Case {
	
	private String coord;
	
	private Piece piece;
	
	private List<Observer> observers;
	
	public Case(String nom) {
		coord = nom;
	}

	public String getCoord() {
		return coord;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public boolean isEmpty(){
		return this.piece == null;
	}
	
	public void addObserver() {
		//TODO
	}

	public void avertir() {
		// TODO Auto-generated method stub
		
	}

	public boolean isAttacked() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
