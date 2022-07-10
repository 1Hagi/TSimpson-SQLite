package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Excursion;
import model.Oferta;
import model.OfertaTipo;
import model.PromoAbsoluta;
import model.PromoAxB;
import model.PromoPorcentual;
import model.Promocion;
import model.Turismo;

public class PromocionDAOImpl implements PromocionDAO {

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
	public List<Promocion> findAll() {
		try {
			String sql = "SELECT * FROM promociones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			List<Promocion> promociones = new LinkedList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados));
			}
			
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM promociones";
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
	
	private Promocion toPromocion(ResultSet resultados) {
		
		try {
		Promocion unaPromocion = null;
		int tipoPromocion = resultados.getInt("fk_promocion_tipo");
		
		switch (tipoPromocion) {
		case 1:
			unaPromocion = new PromoAbsoluta(resultados.getString("nombre"), resultados.getInt("id"), 
					toTipo(resultados.getInt("fk_oferta_tipo")), listarExcursiones(resultados), resultados.getDouble("costo_absoluto"));
			break;
		case 2:
			unaPromocion = new PromoPorcentual(resultados.getString("nombre"), resultados.getInt("id"), 
					toTipo(resultados.getInt("fk_oferta_tipo")), listarExcursiones(resultados), resultados.getInt("costo_porcentual"));
			break;
		case 3:
			unaPromocion = new PromoAxB(resultados.getString("nombre"), resultados.getInt("id"), 
					toTipo(resultados.getInt("fk_oferta_tipo")), listarExcursiones(resultados), resultados.getInt("costo_axb"));
			break;
		}
		
		return unaPromocion;
		
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private ArrayList<Oferta> listarExcursiones(ResultSet resultados) throws SQLException {
		ArrayList<Oferta> excursionesIncluidas = new ArrayList<Oferta>();
		for(int i = 1; i <= 5; i++) {
			if(resultados.getInt(4 + i) > 0) {
				for(Excursion e : Turismo.excursiones) {
					if(e.getId() == resultados.getInt(4 + i)) {
							excursionesIncluidas.add(e);
					}
				}
			}
		}
		return excursionesIncluidas;
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
	public int insert(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Promocion findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
