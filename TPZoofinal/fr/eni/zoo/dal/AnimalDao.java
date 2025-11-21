package TPZoofinal.fr.eni.zoo.dal;

import java.util.List;

import TPZoofinal.fr.eni.zoo.bo.Animal;
import TPZoofinal.fr.eni.zoo.dal.exception.AnimalDaoException;

public interface AnimalDao {

	public void insert(Animal element) throws AnimalDaoException; 

	public List<Animal> selectAll() throws AnimalDaoException;

	public Animal selectById(int id) throws AnimalDaoException;

	public void delete(int id) throws AnimalDaoException;

	public void update(Animal element) throws AnimalDaoException;
}
