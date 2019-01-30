package com.example.cassa.entrainementprojettut.histoire.theme;

public enum revolution {
    DATE1(" date de la prise de la Bastille ","14 juillet 1789"),
    DATE2("date de la proclamation la 1re république ?","22 septembre 1792"),
    DATE3("Date de la déclaration des droits de l'homme et du citoyen","26 août 1789"),
    DATE4("Date d'exécution de Louis XVI.","21 janvier 1793"),
    DATE5("Date des États généraux,","5 mai 1789"),
    DATE6("Date du serment du jeux de Paume","20 juin 1789"),
    DATE7("Date d'abolition des privilèges","4 août 1789"),
    DATE8("Date de la fin de la moarchie absolue","13 sptembre 1791"),
    DATE9("Date de début de la monarchie constitutionel","13 sptembre 1791"),
    DATE10("Date de fin et de début du premier empire","18 mai 1804"),
    DATE11("Date du coup d'état de Napoléon Bonaparte","8 novembre 1799"),
    DATE12("Date de début du Début du directoire","26 octobre 1795"),


    ;




    String question;



    String traduction;


    revolution(String question, String bainerep) {
        this.question = question;

        this.traduction = bainerep;
    }
    public String getquestion() {
        return question;
    }

    public String getreponce() {
        return traduction;
    }
}
