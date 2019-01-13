package com.example.cassa.entrainementprojettut.mythology.metier;

public enum Divinity {

    ZEUS(
            "Zeus",
            "Appelé Jupiter chez les Romains, je suis le roi des dieux et je possède une autorité suprême sur " +
                    "tous les êtres vivants. Je suis également le dieu du ciel et maîtrise la foudre." +
                    "Je suis très colérique et courreur de jupon bien que ma femme soit la déesse du mariage." +
                    "Mes autres attributs sont le sceptre, le trône, l’aigle et la chèvre."),

    POSEIDON(
            "Poséidon",
            "Appelé Neptune chez les Romains, je suis surtout connu comme le dieu de la mer mais" +
                    " je suis aussi le dieu des tremblement de terre et plus étonnant des chevaux. " +
                    "Je suis colérique et n’hésite pas à déchaîner les eaux contre mes ennemis, le héros " +
                    "Ulysse en sait quelque chose. " +
                    "Je suis souvent représenté sur mon char aquatique accompagné de mon célèbre trident."
    ),

    HADES(
            "Hadès",
            "Appelé Pluton chez les Romains, je suis le dieu du royaume des morts qu'on appelle les Enfers." +
                    "Je me montre sans pitié, insensible et j'inspire la terreur autour de moi." +
                    "Ma femme Perséphone que j'ai forcé à rester auprès de moi est la fille de Déméter la déesse de la moisson." +
                    "Je suis aussi souvent associé à mon chien à trois têtes Cerbère qui garde l'entrée de mon royaume."
    ),

    ATHENA(
            "Athéna",
            "Appelé Minerve chez les Romains, je suis la déesse de la sagesse, de la stratégie guerrière" +
                    " et de la justice. Je suis la fille du roi des dieux." +
                    "Je suis souvent représenté armée de ma lance et de mon bouclier." +
                    "J'ai notamment donné mon nom à la capitale de la Grèce."
    ),

    APHRODITE(
            "Aphrodite",
            "Appelé Vénus chez les Romains, je suis la déesse de l'amour mais aussi de la beauté, " +
                    "du plaisir charnel et de la procréation." +
                    "Je suis marié au dieu de la forge Héphaïstos mais j'ai de nombreux amants comme" +
                    " le dieu de la guerre Arès." +
                    "Mes attributs sont le coquillage, la rose, le pavot, la colombe, le cygne et le bélier."
    ),

    HERMES(
            "Hermès",
            "Appelé Mercure à Rome, je suis le dieu des voyages, du commerce et des voleurs." +
                    "Je suis le fils du roi des dieux et j'ai pour fonction principale d'être le " +
                    "messager des dieux. Je suis rapide et rusé. Mes attributs sont le caducée " +
                    "(le sceptre entouré de deux serpents), " +
                    "les sandales ailées, la bourse d’argent, le bouc, la tortue et le coq."
    )
    ;




    private String name;

    private String text;

    Divinity(String divinityName , String divinityText){
        name = divinityName;
        text = divinityText;
    }

    public String getName(){
        return name;
    }

    public String getText(){
        return text;
    }

}
