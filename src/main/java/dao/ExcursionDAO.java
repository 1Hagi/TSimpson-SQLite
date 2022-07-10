package dao;

import model.Excursion;

public interface ExcursionDAO extends GenericDAO<Excursion> {

	public abstract Excursion findByUsername(String username);

}
