package com.example.cassa.entrainementprojettut.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;

@Entity(tableName = "VerbeConjugue",
        foreignKeys = {
                @ForeignKey(
                        entity = Infinitif.class,
                        parentColumns = "idInfinitif",
                        childColumns = "infinitifId",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = {@Index(value = "infinitifId")},
        primaryKeys = {"temps","sujet","infinitifId"}
)
public class VerbeConjugue {

    @NonNull
    String temps;
    @NonNull
    String sujet;
    @NonNull
    String verbeConjugue;

    int infinitifId;

    public VerbeConjugue(String temps, String sujet, String verbeConjugue, int infinitifId) {
        this.temps = temps;
        this.sujet = sujet;
        this.verbeConjugue = verbeConjugue;
        this.infinitifId= infinitifId;
    }

    @NonNull
    public String getTemps() {
        return temps;
    }

    public void setTemps(@NonNull String temps) {
        this.temps = temps;
    }

    @NonNull
    public String getSujet() {
        return sujet;
    }

    public void setSujet(@NonNull String sujet) {
        this.sujet = sujet;
    }

    @NonNull
    public String getVerbeConjugue() {
        return verbeConjugue;
    }

    public void setVerbeConjugue(@NonNull String verbeConjugue) {
        this.verbeConjugue = verbeConjugue;
    }

    public int getInfinitifId() {
        return infinitifId;
    }

    public void setInfinitifId(int infinitifId) {
        this.infinitifId = infinitifId;
    }
}
