package com.example.cassa.entrainementprojettut.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Infinitif")
public class Infinitif {

    @PrimaryKey(autoGenerate = true)
    int idInfinitif;

    @NonNull
    String infinitifVerbe;
    @NonNull
    String complement;
    int groupe;

    public Infinitif(String infinitifVerbe, int groupe, String complement) {
        this.infinitifVerbe = infinitifVerbe;
        this.groupe = groupe;
        this.complement = complement;
    }

    @NonNull
    public String getInfinitifVerbe() {
        return infinitifVerbe;
    }

    public void setInfinitifVerbe(@NonNull String infinitifVerbe) {
        this.infinitifVerbe = infinitifVerbe;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    @NonNull
    public String getComplement() {
        return complement;
    }

    public void setComplement(@NonNull String complement) {
        this.complement = complement;
    }

    public int getIdInfinitif() {
        return idInfinitif;
    }

    public void setIdInfinitif(int idInfinitif) {
        this.idInfinitif = idInfinitif;
    }
}
