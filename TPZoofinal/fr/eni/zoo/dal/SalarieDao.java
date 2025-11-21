package TPZoofinal.fr.eni.zoo.dal;

import java.util.List;

import TPZoofinal.fr.eni.zoo.bo.Salarie;
import TPZoofinal.fr.eni.zoo.dal.exception.SalarieDaoException;

public interface SalarieDao {

	public void insert(Salarie salarie) throws SalarieDaoException; 

	public List<Salarie> selectAll() throws SalarieDaoException;

	public Salarie selectById(int id) throws SalarieDaoException;

	public void delete(int id) throws SalarieDaoException;

	public void update(Salarie salarie) throws SalarieDaoException;
}

