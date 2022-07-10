package app;

import java.io.IOException;

import dao.DAOFactory;
import dao.UsuarioDAO;
import dao.ExcursionDAO;
import dao.PromocionDAO;
import model.Turismo;

public class App {
	
	public static void main(String[] args) throws IOException {
		
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Turismo.usuarios = usuarioDAO.findAll();

		ExcursionDAO excursionDAO = DAOFactory.getExcursionDAO();
		Turismo.excursiones = excursionDAO.findAll();		

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Turismo.promociones = promocionDAO.findAll();

		Turismo.ofertas.addAll(Turismo.excursiones);
		Turismo.ofertas.addAll(Turismo.promociones);
		
		Turismo.iniciarApp();
	}
}
