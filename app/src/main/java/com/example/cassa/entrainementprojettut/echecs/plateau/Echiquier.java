package com.example.cassa.entrainementprojettut.echecs.plateau;

import com.example.cassa.entrainementprojettut.echecs.pion.Cavalier;
import com.example.cassa.entrainementprojettut.echecs.pion.Dame;
import com.example.cassa.entrainementprojettut.echecs.pion.Fou;
import com.example.cassa.entrainementprojettut.echecs.pion.Piece;
import com.example.cassa.entrainementprojettut.echecs.pion.Pion;
import com.example.cassa.entrainementprojettut.echecs.pion.Roi;
import com.example.cassa.entrainementprojettut.echecs.pion.Tour;

public class Echiquier {

	private Case[] board;
	
	private String colorTurn;
 
	
	private Case selectedCase;
	
	
	public Echiquier() {
		
		
		board = new Case[64];
		initialisationCases();
		initilisationPiece();
	}


	private void initialisationCases() {
		String[] coords = {
			       "a8","b8","c8","d8","e8","f8","g8","h8",
			       "a7","b7","c7","d7","e7","f7","g7","h7",
			       "a6","b6","c6","d6","e6","f6","g6","h6",
			       "a5","b5","c5","d5","e5","f5","g5","h5",
			       "a4","b4","c4","d4","e4","f4","g4","h4",
			       "a3","b3","c3","d3","e3","f3","g3","h3",
			       "a2","b2","c2","d2","e2","f2","g2","h2",
			       "a1","b1","c1","d1","e1","f1","g1","h1"
			};
			
			for(int i =0; i<64; i++) {
				board[i] = new Case(coords[i]);
			}
	}
	
	private void initilisationPiece() {
		
		board[0].setPiece(new Tour(Piece.BLACK_COLOR));
		board[1].setPiece(new Cavalier(Piece.BLACK_COLOR));
		board[2].setPiece(new Fou(Piece.BLACK_COLOR));
		board[3].setPiece(new Dame(Piece.BLACK_COLOR));
		board[4].setPiece(new Roi(Piece.BLACK_COLOR));
		board[5].setPiece(new Fou(Piece.BLACK_COLOR));
		board[6].setPiece(new Cavalier(Piece.BLACK_COLOR));
		board[7].setPiece(new Tour(Piece.BLACK_COLOR));
		
		for (int i = 8; i<16; i++) {
			board[i].setPiece(new Pion(Piece.BLACK_COLOR));
		}
		
		for (int i = 48; i<56; i++) {
			board[i].setPiece(new Pion(Piece.WHITE_COLOR));
		}
		
		board[56].setPiece(new Tour(Piece.WHITE_COLOR));
		board[57].setPiece(new Cavalier(Piece.WHITE_COLOR));
		board[58].setPiece(new Fou(Piece.WHITE_COLOR));
		board[59].setPiece(new Dame(Piece.WHITE_COLOR));
		board[60].setPiece(new Roi(Piece.WHITE_COLOR));
		board[61].setPiece(new Fou(Piece.WHITE_COLOR));
		board[62].setPiece(new Cavalier(Piece.WHITE_COLOR));
		board[63].setPiece(new Tour(Piece.WHITE_COLOR));
		
	}
	
	public void showPossibleMoves(int pos) {
		if(checkPosition(pos)) {
			
			Piece p = board[pos].getPiece();
			if(p != null) {
				selectedCase = board[pos];
				p.showPossibleMoves(pos, board);
			}
			
		}
	}
	
	public void resetPossibleMoves() {
		selectedCase = null;
	}
	
	public void moveSelectedPiece(int pos) {
		if(selectedCase != null && selectedCase.getPiece() != null && checkPosition(pos)) {
			Piece p = selectedCase.getPiece();
			selectedCase.setPiece(null);
			selectedCase.avertir();
			board[pos].setPiece(p);
			board[pos].avertir();
		}
	}
	
	private boolean checkPosition(int pos) {
		return pos >= 0 && pos < 64;
	}


	public Case[] getBoard() {
		// TODO Auto-generated method stub
		return board;
	}
}
