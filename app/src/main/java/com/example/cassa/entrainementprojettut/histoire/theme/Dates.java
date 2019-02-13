package com.example.cassa.entrainementprojettut.histoire.theme;

public enum Dates {
    DATE1("Date de la prise de la Bastille ","14 juillet 1789","La Révolution française"),
    DATE2("Date de la proclamation la Première République ","22 septembre 1792","La Révolution française"),
    DATE3("Date de la déclaration des droits de l'homme et du citoyen","26 août 1789","La Révolution française"),
    DATE4("Date d'exécution de Louis XVI ","21 janvier 1793","La Révolution française"),
    DATE5("Date des États généraux ","5 mai 1789","La Révolution française"),
    DATE6("Date du Serment du Jeu de Paume","20 juin 1789","La Révolution française"),
    DATE7("Date d'abolition des privilèges","4 août 1789","La Révolution française"),
    DATE8("Date de la fin de la moarchie absolue","13 sptembre 1791","La Révolution française"),
    DATE9("Date de début de la monarchie constitutionelle","13 sptembre 1791","La Révolution française"),
    DATE10("Date de début du Premier Empire","18 mai 1804","La Révolution française"),
    DATE11("Date du coup d'état de Napoléon Bonaparte","8 novembre 1799","La Révolution française"),
    DATE12("Date du début du Directoire","26 octobre 1795","La Révolution française"),
    DATE13("Date de la domestication du feu","-600000","La Préhistoire"),
    DATE14("Date de la création de l'agriculture et de l'élevage","-8000 environ","La Préhistoire"),
    DATE15("Date de la création de l'écriture","-3000 environ","La Préhistoire"),
    DATE16("Date de la création de Rome","-753","L'Antiquité"),
    DATE17("Date de la création de la démocratie athénienne","vers -510","L'Antiquité"),
    DATE18("Date de la fin de l'Empire Romain","476","L'Antiquité"),
    DATE19("Date de la conquète de la Gaule par Jules César","-52","L'Antiquité"),
    DATE20("Date du baptême de Clovis","496","Le Moyen Âge"),
    DATE21("Date du couronnement de Charlemagne","800","Le Moyen Âge"),
    DATE22("Date de la découverte de l'Amérique par Christophe Colomb","1492","Le Moyen Âge"),
    DATE23("Date du début du règne de Louix XIV","1661","Les Temps Modernes"),
    DATE24("Date de la déclaration d'indépendance des Etats-Unis","1776","Les Temps Modernes"),
    DATE25("Date de début de la Première Guerre Mondiale","1914","Époque Contemporaine"),
    DATE26("Date de fin de la Première Guerre Mondiale","1918","Époque Contemporaine"),
    DATE27("Date de début de la Seconde Guerre Mondiale","1939","Époque Contemporaine"),
    DATE28("Date de fin de la Seconde Guerre Mondiale","1945","Époque Contemporaine"),
    DATE29("Date d'abolition de l'esclavage en France","1848","Époque Contemporaine"),
    DATE30("Date où l'école de devient obligatoire, gratuite et laïque","1882","Époque Contemporaine"),






    ;




    String question;

    String traduction;

    String theme;

    Dates(String question, String bainerep,String theme) {
        this.question = question;

        this.traduction = bainerep;

        this.theme=theme;
    }
    public String getquestion() {
        return question;
    }

    public String getreponce() {
        return traduction;
    }

    public String gettheme() {
        return theme;
    }
}
