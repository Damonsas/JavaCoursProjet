package Medecin;

import java.time.LocalDate;
import java.time.LocalTime;

public class RendezVous extends Creneau{
    LocalDate date;

    public RendezVous(LocalDate date, LocalTime heureD, int duree){

        super(heureD, duree);
        this.date = date;

    }
}
