package com.example.cassa.entrainementprojettut.echecs.pion;
import com.example.cassa.entrainementprojettut.echecs.plateau.Case;

import java.util.ArrayList;
import java.util.List;

public class Fou extends Piece{

	public Fou(String couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Case> getPossibleMoves(int pos, Case[] board) {
		
		ArrayList<Case> possiblemoves = standardMoves(pos, board, DEPLACEMENTS_FOU);
		return possiblemoves;
		
	}

}
