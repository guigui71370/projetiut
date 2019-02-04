package com.example.cassa.entrainementprojettut.echecs.plateau;

import com.example.cassa.entrainementprojettut.echecs.pion.*;

import java.util.ArrayList;
import java.util.Scanner;

public   class  PlateauDef  {
	private Case plateau[][];
	private ArrayList<Piondef> pionJoueurNoir;
	private ArrayList<Piondef> pionJoueurBlanc;


	public PlateauDef() {
		this.plateau = new Case [8][8];

		for(int x=0;x<this.plateau.length;x++) {
			for(int y=0;y<this.plateau[x].length;y++) {

				if(x%2==0) {
					if(y%2==0) {
						this.plateau[x][y]=new Case(x,y,null,true);
					}else {
						this.plateau[x][y]=new Case(x,y,null,false);
					}
				}else {
					if(y%2==0) {
						this.plateau[x][y]=new Case(x,y,null,false);
					}else {
						this.plateau[x][y]=new Case(x,y,null,true);
					}
				}

			}
		}



		for(int y=0;y<this.plateau[1].length;y++) {
			this.plateau[1][y].setPionDessus(new Pion(1,y,"black"));		
		}

		this.plateau[0][0].setPionDessus(new Tour(0,0,"black"));
		this.plateau[0][1].setPionDessus(new Cavalier(0,1,"black"));
		this.plateau[0][2].setPionDessus(new Fou(0,2,"black"));
		this.plateau[0][3].setPionDessus(new Reine(0,3,"black"));
		this.plateau[0][4].setPionDessus(new Roi(0,4,"black"));
		this.plateau[0][5].setPionDessus(new Fou(0,5,"black"));
		this.plateau[0][6].setPionDessus(new Cavalier(0,6,"black"));
		this.plateau[0][7].setPionDessus(new Tour(0,7,"black"));




		for(int y=0;y<this.plateau[6].length;y++) {
			this.plateau[6][y].setPionDessus(new Pion(6,y,"white"));

		}




		this.plateau[7][0].setPionDessus(new Tour(7,0,"white"));
		this.plateau[7][1].setPionDessus(new Cavalier(7,1,"white"));
		this.plateau[7][2].setPionDessus(new Fou(7,2,"white"));
		this.plateau[7][3].setPionDessus(new Reine(7,3,"white"));
		this.plateau[7][4].setPionDessus(new Roi(7,4,"white"));
		this.plateau[7][5].setPionDessus(new Fou(7,5,"white"));
		this.plateau[7][6].setPionDessus(new Cavalier(7,6,"white"));
		this.plateau[7][7].setPionDessus(new Tour(7,7,"white"));



		this.pionJoueurBlanc=new ArrayList<Piondef>();
		this.pionJoueurNoir=new ArrayList<Piondef>();
		for(int x=0;x<this.plateau.length;x++) {
			for(int y=0;y<this.plateau[x].length;y++) {
				if(this.plateau[x][y].getPionDessus()!=null && this.plateau[x][y].getPionDessus().getCouleur().equals("black")) {

					this.pionJoueurNoir.add(this.plateau[x][y].getPionDessus());
				}
				else if(this.plateau[x][y].getPionDessus()!=null && this.plateau[x][y].getPionDessus().getCouleur().equals("white")) {

					this.pionJoueurBlanc.add(this.plateau[x][y].getPionDessus());
				}
			}
		}
	}



	@Override
	public String toString() {
		String t="  a  b  c  d  e  f  g  h \n";
		for(int x=0;x<this.plateau.length;x++) {
			t+=this.plateau.length-x+" ";
			for(int y=0;y<this.plateau[x].length;y++) {
				t+=this.plateau[x][y].toString()+" ";
			}
			t+=this.plateau.length-x+" ";
			t+="\n";
		}
		t+="  a  b  c  d  e  f  g  h \n";
		/*for(int x=0;x<this.plateau.length;x++) {
			for(int y=0;y<this.plateau[x].length;y++) {
				t+=this.plateau[x][y].getCouleurCase();
			}
			t+="\n";
		}*/
		t+="\n "+this.pionJoueurBlanc.size();
		t+="\n "+this.pionJoueurNoir.size();
		return t;
	}





	Scanner sc=new Scanner(System.in);




	public void deplacementtest() {
		String f=sc.nextLine();
		String d=sc.nextLine();
		int i[]=traducteur(Integer.parseInt(d),f.charAt(0));
		System.out.println(i[0]+" "+i[1]);

		String f2=sc.nextLine();
		String d2=sc.nextLine();



		int i2[]=traducteur(Integer.parseInt(d2),f2.charAt(0));
		System.out.println(i2[0]+" "+i2[1]);

		ArrayList<int []>movdispo=controleMouvement(this.plateau[i[0]][i[1]].getPionDessus());





		System.out.println(traducteurinverse(movdispo.get(0))+" "+traducteurinverse(movdispo.get(1)));




		this.plateau[i2[0]][i2[1]].setPionDessus(this.plateau[i[0]][i[1]].getPionDessus());
		this.plateau[i2[0]][i2[1]].getPionDessus();

		this.plateau[i[0]][i[1]].setPionDessus(null);
		this.plateau[i2[0]][i2[1]].getPionDessus().setPosX(i2[0]);
		this.plateau[i2[0]][i2[1]].getPionDessus().setPosy(i2[1]);
		System.out.println(this.toString());

	}


	public  ArrayList<int []> controleMouvement(Piondef pionABouger) {
		ArrayList<int []> test=new ArrayList<int []>();

		if(pionABouger.getNomPion().equals("P")) {
			test=deplacementPiont(pionABouger);
		}else if(pionABouger.getNomPion().equals("C")) {
			test=deplacementCavalier(pionABouger);
		}else if(pionABouger.getNomPion().equals("F")) {
			test=deplacementdiagonale(pionABouger);
		}else if(pionABouger.getNomPion().equals("T")) {
			test=deplacementverticalHorizontal(pionABouger);
		}else if(pionABouger.getNomPion().equals("R")) {
			test.addAll(deplacementverticalHorizontal(pionABouger));
			test.addAll(deplacementdiagonale(pionABouger));
		}
		return test;
	}




	public  ArrayList<int []> deplacementPiont(Piondef pionABouger){
		ArrayList<int []> test=new ArrayList<int []>();
		if(pionABouger.getCompteur()==0) {
			if(pionABouger.getCouleur().equals("black")) {
				int i[] = { pionABouger.getPosX()+1	,pionABouger.getPosy()};
				test.add(i);
				int i2[]= { pionABouger.getPosX()+2	,pionABouger.getPosy()};
				test.add(i2);
				pionABouger.setCompteur(1);
			}else {
				int i[] = { pionABouger.getPosX()-1	,pionABouger.getPosy()};
				test.add(i);
				int i2[]= { pionABouger.getPosX()-2	,pionABouger.getPosy()};
				test.add(i2);
				pionABouger.setCompteur(1);
			}
		}else {
			if(pionABouger.getNomPion().equals("black")) {
				int i[] = { pionABouger.getPosX()+1	,pionABouger.getPosy()};
				test.add(i);
			}else {
				int i[] = { pionABouger.getPosX()-1	,pionABouger.getPosy()};
				test.add(i);
			}
		}
		return test;
	}


	/*
	 * refaire les condition du cavalier
	 * */
	public  ArrayList<int []> deplacementCavalier(Piondef pionABouger){
		ArrayList<int []> test=new ArrayList<int []>();

		if(pionABouger.getPosX()-2>=0) {
			if(pionABouger.getPosy()+1<8) {	
				if(this.plateau[pionABouger.getPosX()-2][pionABouger.getPosy()+1].getPionDessus()!=null && pionABouger.getCouleur().equals(this.plateau[pionABouger.getPosX()-2][pionABouger.getPosy()+1].getPionDessus().getCouleur())) {

				}else {
					int i[] = { pionABouger.getPosX()-2	,pionABouger.getPosy()+1};
					test.add(i);
				}
			}

			if(pionABouger.getPosy()-1>=0) {
				if(this.plateau[pionABouger.getPosX()-2][pionABouger.getPosy()-1].getPionDessus()!=null && pionABouger.getCouleur().equals(this.plateau[pionABouger.getPosX()-2][pionABouger.getPosy()-1].getPionDessus().getCouleur())) {

				}else {
					int i2[] = { pionABouger.getPosX()-2	,pionABouger.getPosy()-1};
					test.add(i2);
				}
			}


		}

		if(pionABouger.getPosX()+2<8) {
			if(pionABouger.getPosy()+1<8) {
				if(this.plateau[pionABouger.getPosX()+2][pionABouger.getPosy()+1].getPionDessus()!=null && pionABouger.getCouleur().equals(this.plateau[pionABouger.getPosX()+2][pionABouger.getPosy()+1].getPionDessus().getCouleur())) {

				}else {
					int i3[] = { pionABouger.getPosX()+2	,pionABouger.getPosy()+1};
					test.add(i3);
				}

			}
			if(pionABouger.getPosy()-1>=0) {
				if(this.plateau[pionABouger.getPosX()+2][pionABouger.getPosy()-1].getPionDessus()!=null && pionABouger.getCouleur().equals(this.plateau[pionABouger.getPosX()+2][pionABouger.getPosy()-1].getPionDessus().getCouleur())) {

				}else {
					int i4[] = { pionABouger.getPosX()+2	,pionABouger.getPosy()-1};
					test.add(i4);
				}
			}
		}

		if(pionABouger.getPosy()-2>=0) {

			if(pionABouger.getPosX()-1>=0) {
				if(this.plateau[pionABouger.getPosX()-1][pionABouger.getPosy()-2].getPionDessus()!=null && pionABouger.getCouleur().equals(this.plateau[pionABouger.getPosX()-1][pionABouger.getPosy()-2].getPionDessus().getCouleur())) {

				}else {
					int i5[] = { pionABouger.getPosX()-1	,pionABouger.getPosy()-2};
					test.add(i5);
				}
			}
			if(pionABouger.getPosX()+1<8) {
				if(this.plateau[pionABouger.getPosX()+1][pionABouger.getPosy()-2].getPionDessus()!=null && pionABouger.getCouleur().equals(this.plateau[pionABouger.getPosX()+1][pionABouger.getPosy()-2].getPionDessus().getCouleur())) {

				}else {
					int i6[] = { pionABouger.getPosX()+1	,pionABouger.getPosy()-2};
					test.add(i6);
				}
			}
		}



		if(pionABouger.getPosy()+2<8) {

			if(pionABouger.getPosX()-1>=0) {

				if(this.plateau[pionABouger.getPosX()-1][pionABouger.getPosy()+2].getPionDessus()!=null && pionABouger.getCouleur().equals(this.plateau[pionABouger.getPosX()-1][pionABouger.getPosy()+2].getPionDessus().getCouleur())) {

				}else {
					int i7[] = { pionABouger.getPosX()-1	,pionABouger.getPosy()+2};
					test.add(i7);
				}
			}
			if(pionABouger.getPosX()+1<8) {
				if(this.plateau[pionABouger.getPosX()+1][pionABouger.getPosy()+2].getPionDessus()!=null && pionABouger.getCouleur().equals(this.plateau[pionABouger.getPosX()+1][pionABouger.getPosy()+2].getPionDessus().getCouleur())) {

				}else {
					int i8[] = { pionABouger.getPosX()+1	,pionABouger.getPosy()+2};
					test.add(i8);
				}
			}
		}


		return test;

	}


	public  ArrayList<int []> deplacementdiagonale(Piondef pionABouger){
		ArrayList<int []> test=new ArrayList<int []>();

		int x=1;
		int y=1;
		while(pionABouger.getPosX()+x<this.plateau.length && pionABouger.getPosy()+y<this.plateau.length	) {

			if(this.plateau[pionABouger.getPosX()+ x][pionABouger.getPosy()+ y].getPionDessus()==null) {
				int i[]= {pionABouger.getPosX()+ x,pionABouger.getPosy()+y};
				test.add(i);
				x++;
				y++;	
			}else if(this.plateau[pionABouger.getPosX()+ x][pionABouger.getPosy()+ y].getPionDessus().getCouleur().equals(pionABouger.getCouleur())) {
				break;
			}else {
				int i[]= {pionABouger.getPosX()+ x,pionABouger.getPosy()+y};
				test.add(i);

				break;
			}

		}	
		
		
		 x=1;
		 y=1;
		
		while(pionABouger.getPosX()-x>=0 && pionABouger.getPosy()+y<this.plateau.length	) {

			if(this.plateau[pionABouger.getPosX()- x][pionABouger.getPosy()+ y].getPionDessus()==null) {
				int i[]= {pionABouger.getPosX()- x,pionABouger.getPosy()+y};
				test.add(i);
				x++;
				y++;	
			}else if(this.plateau[pionABouger.getPosX()- x][pionABouger.getPosy()+ y].getPionDessus().getCouleur().equals(pionABouger.getCouleur())) {
				break;
			}else {
				int i[]= {pionABouger.getPosX()- x,pionABouger.getPosy()+y};
				test.add(i);

				break;
			}

		}
		
		
		 x=1;
		 y=1;
		
		while(pionABouger.getPosX()-x>=0 && pionABouger.getPosy()-y>=0) {

			if(this.plateau[pionABouger.getPosX()- x][pionABouger.getPosy()- y].getPionDessus()==null) {
				int i[]= {pionABouger.getPosX()- x,pionABouger.getPosy()-y};
				test.add(i);
				x++;
				y++;	
			}else if(this.plateau[pionABouger.getPosX()- x][pionABouger.getPosy()- y].getPionDessus().getCouleur().equals(pionABouger.getCouleur())) {
				break;
			}else {
				int i[]= {pionABouger.getPosX()- x,pionABouger.getPosy()-y};
				test.add(i);

				break;
			}

		}
		 x=1;
		 y=1;
		
		while(pionABouger.getPosX()+x<this.plateau.length && pionABouger.getPosy()-y>=0	) {

			if(this.plateau[pionABouger.getPosX()+ x][pionABouger.getPosy()- y].getPionDessus()==null) {
				int i[]= {pionABouger.getPosX()+ x,pionABouger.getPosy()-y};
				test.add(i);
				x++;
				y++;	
			}else if(this.plateau[pionABouger.getPosX()+ x][pionABouger.getPosy()- y].getPionDessus().getCouleur().equals(pionABouger.getCouleur())) {
				break;
			}else {
				int i[]= {pionABouger.getPosX()+ x,pionABouger.getPosy()-y};
				test.add(i);

				break;
			}

		}


		return test;
	}


	public  ArrayList<int []> deplacementverticalHorizontal(Piondef pionABouger){
		ArrayList<int []> test=new ArrayList<int []>();

		int x=1;
		int y=0;
		while(pionABouger.getPosX()+x<this.plateau.length) {

			if(this.plateau[pionABouger.getPosX()+ x][pionABouger.getPosy()].getPionDessus()==null) {
				int i[]= {pionABouger.getPosX()+ x,pionABouger.getPosy()};
				test.add(i);
				x++;

			}else if(this.plateau[pionABouger.getPosX()+ x][pionABouger.getPosy()].getPionDessus().getCouleur().equals(pionABouger.getCouleur())) {
				break;
			}else {
				int i[]= {pionABouger.getPosX()+ x,pionABouger.getPosy()};
				test.add(i);

				break;
			}

		}


		x=1;
		while(pionABouger.getPosX()-x>=0) {

			if(this.plateau[pionABouger.getPosX()- x][pionABouger.getPosy()].getPionDessus()==null) {
				int i[]= {pionABouger.getPosX()- x,pionABouger.getPosy()};
				test.add(i);
				x++;

			}else if(this.plateau[pionABouger.getPosX()- x][pionABouger.getPosy()].getPionDessus().getCouleur().equals(pionABouger.getCouleur())) {
				break;
			}else {
				int i[]= {pionABouger.getPosX()- x,pionABouger.getPosy()};
				test.add(i);

				break;
			}

		}



		y=1;

		while(pionABouger.getPosy()+y<this.plateau.length	) {

			if(this.plateau[pionABouger.getPosX()][pionABouger.getPosy()+ y].getPionDessus()==null) {
				int i[]= {pionABouger.getPosX(),pionABouger.getPosy()-y};
				test.add(i);

				y++;
			}else if(this.plateau[pionABouger.getPosX()][pionABouger.getPosy()+ y].getPionDessus().getCouleur().equals(pionABouger.getCouleur())) {
				break;
			}else {
				int i[]= {pionABouger.getPosX(),pionABouger.getPosy()+y};
				test.add(i);

				break;
			}

		}

		y=1;
		while(pionABouger.getPosy()-y>=0) {

			if(this.plateau[pionABouger.getPosX()][pionABouger.getPosy()- y].getPionDessus()==null) {
				int[] i = {pionABouger.getPosX(), pionABouger.getPosy() - y};
				test.add(i);

				y++;
			}else if(this.plateau[pionABouger.getPosX()][pionABouger.getPosy()- y].getPionDessus().getCouleur().equals(pionABouger.getCouleur())) {
				break;
			}else {
				int[] i = {pionABouger.getPosX(), pionABouger.getPosy() - y};
				test.add(i);

				break;
			}

		}


		return test;
	}

	public String affichage(int tab[]) {

		return tab[0]+" "+tab[1];

	}








	public int[] traducteur(int i, char o) {
		int i1[]=new int[2];
		switch(i) {
		case 1:i1[0]=7;break;
		case 2:i1[0]=6;break;
		case 3:i1[0]=5;break;
		case 4:i1[0]=4;break;
		case 5:i1[0]=3;break;
		case 6:i1[0]=2;break;
		case 7:i1[0]=1;break;
		case 8:i1[0]=0;break;
		default:i1[0]=-1;break;
		}
		switch(o) {
		case 'a':i1[1]=0;break;
		case 'b':i1[1]=1;break;
		case 'c':i1[1]=2;break;
		case 'd':i1[1]=3;break;
		case 'e':i1[1]=4;break;
		case 'f':i1[1]=5;break;
		case 'g':i1[1]=6;break;
		case 'h':i1[1]=7;break;
		default:i1[1]=-1;break;
		}
		return i1;
	}

	public String traducteurinverse(int i[]) {
		String i1="";
		switch(i[0]) {
		case 0:i1+=8;break;
		case 1:i1+=7;break;
		case 2:i1+=6;break;
		case 3:i1+=5;break;
		case 4:i1+=4;break;
		case 5:i1+=3;break;
		case 6:i1+=2;break;
		case 7:i1+=1;break;
		default:i1+=-1;break;
		}
		i1+=" ";
		switch(i[1]) {
		case 0:i1+='a';break;
		case 1:i1+='b';break;
		case 2:i1+='c';break;
		case 3:i1+='d';break;
		case 4:i1+='e';break;
		case 5:i1+='f';break;
		case 6:i1+='g';break;
		case 7:i1+='h';break;
		default:i1+=-1;break;
		}
		return i1;
	}


}
