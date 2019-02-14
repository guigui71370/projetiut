package com.example.cassa.entrainementprojettut.echecs.pion;

import com.example.cassa.entrainementprojettut.echecs.plateau.Case;
import com.example.cassa.entrainementprojettut.echecs.plateau.MailBox;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
	
	public static final String WHITE_COLOR = "Blanc";
	public static final String BLACK_COLOR = "Noir";
	
	public static final int[] DEPLACEMENTS_TOUR = {-10,10,-1,1 } ;
	public static final int[] DEPLACEMENTS_FOU = { -11,-9,11,9 };
	public static final int[] DEPLACEMENTS_CAVALIER = { -12,-21,-19,-8,12,21,19,8};
	public static final int[] DEPLACEMENTS_ROI = { -11,-9,11,9, -10, 10, -1, 1 };
	
	
	
	protected String color;
	
	public Piece(String couleur) {
		color = couleur;
	}
	
	public String getColor() {
		return color;
	}
	
	public void showPossibleMoves(int pos, Case[] board){
		List<Case> list = getPossibleMoves(pos,board);
		for(int i = 0; i< list.size(); i++){
			list.get(i).avertir();
		}
	}
	
	/*return true if square is empty or piece is an opponent color */
	protected boolean isValide(Case[] board, int n) {
		return board[n].isEmpty() || board[n].getPiece().getColor() != this.getColor();
	}
	
	protected ArrayList<Case> standardMoves(int pos, Case[] board, int[] deplacements) {
		ArrayList<Case> possiblemoves = new ArrayList<Case>();
		
		for(int dep : deplacements){
			int j = 1;
			boolean end = false;
			int n;
			
			while(!end){
				n = MailBox.TAB120[MailBox.TAB64[pos] + (dep*j) ];
				System.out.println(n);
				if(n>=0){ 
					// as we are not out of the board
					if(n < board.length && isValide(board, n)){
						// notify the square 
						possiblemoves.add(board[n]);
					}
					else end = true;
				}
				// stop if outside of the board
				else end = true; 
				/* destination square is not empty (opponent or not) 
				then the bishop won't pass through */
				if(!end && !board[n].isEmpty()) end = true;

				j = j + 1;
			}
		}
		return possiblemoves;
	}

	public abstract int getValeur();

	public abstract List<Case> getPossibleMoves(int pos, Case[] board);

}
