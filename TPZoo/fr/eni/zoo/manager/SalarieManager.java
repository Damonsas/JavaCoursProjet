package TPZoo.fr.eni.zoo.manager;

import TPZoo.fr.eni.zoo.dao.SalarieDaoMock;
import TPZoo.fr.eni.zoo.bo.Salarie;
import TPZoo.fr.eni.zoo.bo.Soignant;

import java.util.List;

public class SalarieManager {

    SalarieDaoMock dao = new SalarieDaoMock();

    public List<Salarie> getSalaries() {
        return getSalaries();
    }

    public void ajoutSalarie(Salarie salarie) {
        dao.ajoutSalarie(salarie);

    }

    public Salarie getSalarie(int id) {
        return  getSalarie(id);
    }

    public void majSalarie(Soignant soignantUpdate) {
        dao.majSalarie(soignantUpdate);
    }

    public void supprimerSalarie(int id) {
        dao.supprimerSalarie(id);
    }

    public double getMasseSalariale() {
        return getMasseSalariale();
    }

    public double getMoyenneSalariale() {
        return getMoyenneSalariale();
    }
}
