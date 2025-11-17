package TPAeroport;

import java.time.LocalDateTime;
import java.util.List;

public class Vol {
    private String nimVol;
    private LocalDateTime datehDep;
    private LocalDateTime datehArr;

    private Aeroport aeroportDep;
    private Aeroport aeroportArr;

    private Avion avion;

    private List<Escale> listEscale;


    public List<Escale> getListEscale() {
        return listEscale;
    }

    public Avion getAvion() {
        return avion;
    }
    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Aeroport getAeroportArr() {
        return aeroportArr;
    }
    public void setAeroportArr(Aeroport aeroportArr) {
        this.aeroportArr = aeroportArr;
    }

    public Aeroport getAeroportDep() {
        return aeroportDep;
    }
    public void setAeroportDep(Aeroport aeroportDep) {
        this.aeroportDep = aeroportDep;
    }

    public LocalDateTime getDatehArr() {
        return datehArr;
    }
    public void setDatehArr(LocalDateTime datehArr) {
        this.datehArr = datehArr;
    }

    public LocalDateTime getDatehDep() {
        return datehDep;
    }
    public void setDatehDep(LocalDateTime datehDep) {
        this.datehDep = datehDep;
    }

    public String getNimVol() {
        return nimVol;
    }
    public void setNimVol(String nimVol) {
        this.nimVol = nimVol;
    }
}
