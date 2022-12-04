package fstt.org.market.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.InitialContext;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import fstt.org.market.business.EtudiantRemote;
import fstt.org.market.business.impl.ManageEtudiantBean;
import fstt.org.market.entities.persistence.Etudiant;


/**
 * Servlet implementation class EtudiantController
 */
@WebServlet
public class EtudiantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private static final String LOOKUP_STRING = "ManageEtudiantBean/remote";
	
	//EtudiantRemote etudiantRemote = doLookup();

	@EJB(mappedName="EJB_crud/java:/EtudiantDS/ManageEtudiantBean!fstt.org.market.business.EtudiantRemote")
	EtudiantRemote etudiantRemote ;
	/*public void init(ServletConfig config) throws ServletException {

		super.init(config);
		try {

			Context context = new InitialContext();
			etudiantRemote = (EtudiantRemote) context.lookup("EtudiantRemote.EtudiantDS");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}*/

	String action = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		action = request.getParameter("action");

		if (action.equals("save")) {

			request.getRequestDispatcher("addEtudiant.jsp").forward(request, response);

		} else if (action.equals("update")) {

			Integer id = Integer.parseInt(request.getParameter("id"));

			Etudiant etudiantExists = getOne(id);

			request.setAttribute("oldFirstname", etudiantExists.getPrenom());

			request.setAttribute("oldAddress", etudiantExists.getAdresse());

			request.setAttribute("oldLastname", etudiantExists.getNom());

			request.setAttribute("oldCne", etudiantExists.getCne());

			request.setAttribute("oldLevel", etudiantExists.getNiveau());
			
			request.setAttribute("id", etudiantExists.getId());

			request.getRequestDispatcher("updateEtudiant.jsp").forward(request, response);

		} else if (action.equals("delete")) {

			Integer id = Integer.parseInt(request.getParameter("id"));

			delete(id);

			request.getRequestDispatcher("/etudiant?action=list").forward(request, response);

		} else if (action.equals("list")) {

			List<Etudiant> list = new ArrayList<Etudiant>();
			list = getAll();

			request.setAttribute("list", list);

			request.getRequestDispatcher("etudiants.jsp").forward(request, response);

		} else if (action.equals("get")) {

			Integer id = Integer.parseInt(request.getParameter("id"));

			Etudiant etudiant = getOne(id);

			request.setAttribute("etudiant", etudiant);

			request.getRequestDispatcher("getEtudiant.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		action = request.getParameter("action");

		if (action.equals("saved")) {
			Etudiant etudiant;

			String firstname = request.getParameter("firstname");

			String lastname = request.getParameter("lastname");

			String address = request.getParameter("address");

			String cne = request.getParameter("cne");

			String level = request.getParameter("level");

			etudiant = new Etudiant(lastname, firstname, cne, address, level);

			create(etudiant);

			request.getRequestDispatcher("etudiant?action=list").forward(request, response);

		} else if (action.equals("updated")) {

			String firstname = request.getParameter("firstname");

			String lastname = request.getParameter("lastname");

			String address = request.getParameter("address");

			String cne = request.getParameter("cne");

			String level = request.getParameter("level");

			Integer id = Integer.parseInt(request.getParameter("id"));

			Etudiant etudiant = new Etudiant(lastname, firstname, cne, address, level);

			update(id, etudiant);

			request.getRequestDispatcher("/etudiant?action=list").forward(request, response);

		}

	}

	public Etudiant getOne(Integer id) throws IOException {
		return etudiantRemote.findEtudiantById(id);
	}

	public List<Etudiant> getAll() {
		return etudiantRemote.findAll();
	}

	public void create(Etudiant etudiant) {
		etudiantRemote.addEtudiant(etudiant);
	}

	public void update(Integer id, Etudiant etudiant) throws IOException {
		etudiantRemote.updateEtudiant(id, etudiant);
	}

	public void delete(Integer clientId) throws IOException {
		etudiantRemote.deleteClient(clientId);
	}

}
