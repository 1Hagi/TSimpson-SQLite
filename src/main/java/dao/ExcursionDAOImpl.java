package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Excursion;
import model.OfertaTipo;

public class ExcursionDAOImpl implements ExcursionDAO {

	public int insert(Excursion excursion) {
		try {
			String sql = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, excursion.getNombre());
			int rows = statement.executeUpdate();
			
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Excursion> findAll() {
		try {
			String sql = "SELECT * FROM excursiones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			List<Excursion> excursiones = new ArrayList<Excursion>();
			while (resultados.next()) {
				excursiones.add(toExcursion(resultados));
			}
			
			return excursiones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM excursiones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			resultados.next();
			int total = resultados.getInt("TOTAL");
			
			return total;
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private Excursion toExcursion(ResultSet resultados) {
		try {
			return new Excursion(resultados.getString("nombre"), resultados.getInt("id"), toTipo(resultados.getInt("id_tipo")), resultados.getInt("tiempo"), resultados.getDouble("costo"), resultados.getInt("cupo"));

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private OfertaTipo toTipo(int id) {
		switch(id) {
		case 1:
			return OfertaTipo.VISITAGUIADA;
		case 2:
			return OfertaTipo.ENTRETENIMIENTO;
		case 3:
			return OfertaTipo.TERROR;
		case 4:
			return OfertaTipo.RESTORAN;
		case 5:
			return OfertaTipo.FIESTA;
		case 6:
			return OfertaTipo.TIENDA;
		}
		return OfertaTipo.VISITAGUIADA;
	}
	
	@Override
	public Excursion findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Excursion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Excursion t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
