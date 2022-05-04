package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica.logicaBean;
import logica.logicaInterfazLocal;
import modelo.Persona;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




/**
 * Servlet implementation class AdminPersona
 */
@WebServlet("/adminPersona")
public class AdminPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	logicaBean logicaIL = new logicaBean();
	
    public AdminPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "showRegistrar":
				showRegistrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "register":
				registrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// muestra pagina inicial
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	//muestra formulario de registro
		private void showRegistrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/register.jsp");
			dispatcher.forward(request, response);
		}
	
	// persiste nueva persona
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		try {
			
			int id = (Integer.parseInt(request.getParameter("id")));
			String nombre = request.getParameter("nombre");
			int telefono = (Integer.parseInt(request.getParameter("telefono")));
			String fechaNacStg = request.getParameter("fechaNac");
			Date fechaNac = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(fechaNacStg);
			
			
			System.out.println("la fecha es ");
			System.out.println(fechaNac);
			
			Persona persona = new Persona();
			persona.setIdpersona(id);
			persona.setNombre(nombre);
			persona.setTelefono(telefono);
			persona.setFechaNac(fechaNac);
			
			System.out.println(persona.getNombre());
			System.out.println(persona.getTelefono());
			System.out.println(persona.getFechaNac());
			List<Persona> listaPersonas = logicaIL.guardarPersona(persona);
			request.setAttribute("lista", listaPersonas);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	
	// lista las personas
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		listaPersonas = logicaIL.listarPersonas();
		if(listaPersonas == null) 
			System.out.println("lista personas null");
		else {
			for (Persona p : listaPersonas) {
				System.out.println(p.getNombre().toString());
		    }
		}
		
		
		request.setAttribute("lista", listaPersonas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		dispatcher.forward(request, response);
	}	
	
	//muestra formulario de editar
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		Persona persona = logicaIL.buscarPersona(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("persona", persona);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
	}
	
	// edita persona
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		try {
			int id = (Integer.parseInt(request.getParameter("id")));
			String nombre = request.getParameter("nombre");
			int telefono = (Integer.parseInt(request.getParameter("telefono")));
			String fechaNacStg = request.getParameter("fechaNac");
			Date fechaNac = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(fechaNacStg);
			
			Persona persona = new Persona();
			persona.setIdpersona(id);
			persona.setNombre(nombre);
			persona.setTelefono(telefono);
			persona.setFechaNac(fechaNac);
			
			logicaIL.editarPersona(persona);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//Persona persona = logicaIL.buscarPersona(Integer.parseInt(request.getParameter("id")));
		try {
			logicaIL.eliminarPersona(Integer.parseInt(request.getParameter("id")));
		} finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
	}


}
