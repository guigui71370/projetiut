package com.example.cassa.entrainementprojettut.echecs.pion;
import com.example.cassa.entrainementprojettut.echecs.plateau.Case;

import java.util.List;

public class Dame extends Piece{

	public Dame(String couleur) {
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
		return standardMoves(pos, board, DEPLACEMENTS_ROI);
		
	}

}
