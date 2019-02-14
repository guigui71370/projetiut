package com.example.cassa.entrainementprojettut.echecs.pion;

import com.example.cassa.entrainementprojettut.echecs.plateau.Case;
import com.example.cassa.entrainementprojettut.echecs.plateau.MailBox;

import java.util.ArrayList;
import java.util.List;

public class Roi extends Piece{

	private boolean roque;

	public Roi(String couleur) {
		super(couleur);
		roque = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean canRoque(){
		return roque;
	}

	@Override
	public List<Case> getPossibleMoves(int pos, Case[] board) {

		ArrayList<Case> possiblemoves = new ArrayList<Case>();
		
		

		for(int dep : DEPLACEMENTS_ROI){
			int n;
			n = MailBox.TAB120[MailBox.TAB64[pos] + dep ];
			if(n>=0){ 
				// as we are not out of the board
				if(n < board.length && isValide(board, n) && !board[n].isAttacked()){
					// add the square 
					possiblemoves.add(board[n]);
				}
			}
		}
		
		//TODO ROQUE ****
		
		removeAttackedCases(possiblemoves);
		
		return possiblemoves;

	}

	private void removeAttackedCases(ArrayList<Case> possiblemoves) {
		// TODO
		
	}
	
}
