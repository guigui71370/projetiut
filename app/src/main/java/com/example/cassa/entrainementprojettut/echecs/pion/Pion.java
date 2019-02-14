package com.example.cassa.entrainementprojettut.echecs.pion;
import com.example.cassa.entrainementprojettut.echecs.plateau.Case;
import com.example.cassa.entrainementprojettut.echecs.plateau.MailBox;

import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece{

	public Pion(String couleur) {
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
		if (this.color==Piece.WHITE_COLOR) {
			whiteMoves(pos, board, possiblemoves);
		}
		else if(this.color==Piece.BLACK_COLOR) {
			blackMoves(pos, board, possiblemoves);
		}
		else {}

		return possiblemoves;

	}

	private void whiteMoves(int pos, Case[] board, ArrayList<Case> possiblemoves) {
		int n;
		// upper square
		n=MailBox.TAB120[MailBox.TAB64[pos]-10];
		if(n>=0) {
			// as we are not out of the board
			if(n < board.length && board[n].isEmpty()	){
				// notify the square 
				possiblemoves.add(board[n]);
			}

		}

		// 2nd square if PAWN is at starting square
		if (pos/8 == 6) {
			// If the 2 upper squares are empty
			if (board[pos-8].isEmpty() && board[pos-16].isEmpty()) {
				possiblemoves.add(board[pos-16]);
			}
		}

		// upper left square
		n=MailBox.TAB120[MailBox.TAB64[pos]-11];
		if(n>=0) {
			// as we are not out of the board
			if(n < board.length && isValide(board, n)	&& !board[n].isEmpty()){
				// notify the square 
				possiblemoves.add(board[n]);
			}
		}

		// upper right square
		n=MailBox.TAB120[MailBox.TAB64[pos]-9];
		if(n>=0) {
			// as we are not out of the board
			if(n < board.length && isValide(board, n) && !board[n].isEmpty()	){
				// notify the square 
				possiblemoves.add(board[n]);
			}
		}
	}
	
	private void blackMoves(int pos, Case[] board, ArrayList<Case> possiblemoves) {
		int n;
		// bottom square
		n=MailBox.TAB120[MailBox.TAB64[pos]+10];
		if(n>=0) {
			// as we are not out of the board
			if(n < board.length && board[n].isEmpty()	){
				// notify the square 
				possiblemoves.add(board[n]);
			}

		}

		// 2nd square if PAWN is at starting square
		if (pos/8 == 1) {
			// If the 2 upper squares are empty
			if (board[pos+8].isEmpty() && board[pos+16].isEmpty()) {
				possiblemoves.add(board[pos+16]);
			}
		}

		// bottom left square
		n=MailBox.TAB120[MailBox.TAB64[pos]+11];
		if(n>=0) {
			// as we are not out of the board
			if(n < board.length && isValide(board, n) && !board[n].isEmpty()	){
				// notify the square 
				possiblemoves.add(board[n]);
			}
		}

		// bottom right square
		n=MailBox.TAB120[MailBox.TAB64[pos]+9];
		if(n>=0) {
			// as we are not out of the board
			if(n < board.length && isValide(board, n)	&& !board[n].isEmpty()){
				// notify the square 
				possiblemoves.add(board[n]);
			}
		}
	}

}
