package Medecin;

import java.time.LocalTime;
import java.util.ArrayList;

public class Creneau {
    LocalTime heureD;
    int duree;

    public Creneau(LocalTime heureD, int duree) {
        this.heureD = heureD;
        this.duree = duree;
    }


    void getMedecin() {
        ArrayList<MedecinGénéral> Medecin = new ArrayList<>();
        ArrayList<Creneau> Créneau = new ArrayList<>();
    }
}
