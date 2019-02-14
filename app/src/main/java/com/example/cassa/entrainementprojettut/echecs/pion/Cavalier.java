package com.example.cassa.entrainementprojettut.echecs.pion;
import com.example.cassa.entrainementprojettut.echecs.plateau.Case;
import com.example.cassa.entrainementprojettut.echecs.plateau.MailBox;

import java.util.ArrayList;
import java.util.List;

public class Cavalier extends Piece{

	public Cavalier(String couleur) {
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
		ArrayList<Case> possiblemoves = new ArrayList<Case>();
		int n;
		for(int dep : DEPLACEMENTS_CAVALIER){
			n = MailBox.TAB120[MailBox.TAB64[pos]+dep];
			System.out.println(n);
			if(n>= 0){
				if (n < board.length && isValide(board, n)){
					possiblemoves.add(board[n]);
				}
			}
		}
		
		return possiblemoves;
	}

}
