package com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil;

public enum ListeInfinitif {
    //Groupe 1
    AIMER("Aimer",1),
    MANGER("Manger",1),
    CEDER("Céder",1),
    CELEBRER("Célébrer",1),
    APPELER("Appeler",1),
    ACHETER("Acheter",1),
    EMPLOYER("Employer",1),
    BALAYER("Balayer",1),
    JETER("Jeter",1),

    //Groupe 2
    FINIR("Finir",2),
    GRANDIR("Grandir",2),

    //Groupe 3
    VOIR("Voir",3),
    POUVOIR("Pouvoir",3),
    OUVRIR("Ouvrir",3),
    MOUDRE("Moudre",3),
    COUDRE("Coudre",3),
    RESOUDRE("Résoudre",3);

    private String verbe;
    private int groupe;

    ListeInfinitif(String verbe, int groupe){
        this.verbe = verbe;
        this.groupe = groupe;
    }

    public String getVerbe(){
        return verbe;
    }

    public int getGroupe(){
        return groupe;
    }
}
