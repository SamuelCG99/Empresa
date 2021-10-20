package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Empleados.Empleado;
import Empleados.EmpleadoDAO;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		if (opcion.equals("crear")) {
			System.out.println("Usted a presionado la opcion crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/crear.jsp");
			requestDispatcher.forward(request, response);
		} else if (opcion.equals("listar")) {

			EmpleadoDAO empDAO = new EmpleadoDAO();
			List<Empleado> lista = new ArrayList<>();
			try {
				lista = empDAO.obtenerEmpleados();
				for (Empleado empleado : lista) {
					System.out.println(empleado);
				}

				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Usted a presionado la opcion listar");
		} else if (opcion.equals("editar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("Editar id: " + id);
			EmpleadoDAO empDAO = new EmpleadoDAO();
			Empleado emp = new Empleado();
			try {
				emp = empDAO.obtenerEmpleado(id);
				System.out.println(emp);
				request.setAttribute("empleado", emp);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (opcion.equals("eliminar")) {
			EmpleadoDAO empDAO = new EmpleadoDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				empDAO.eliminar(id);
				System.out.println("Registro eliminado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion.equals("guardar")) {
			EmpleadoDAO empDAO = new EmpleadoDAO();
			Empleado emp = new Empleado();
			emp.setId(Integer.parseInt(request.getParameter("id")));
			emp.setNombre(request.getParameter("nombre"));
			emp.setDni(request.getParameter("dni"));
			emp.setSexo(request.getParameter("sexo"));
			emp.setCategoria(Integer.parseInt(request.getParameter("categoria")));
			emp.setAnnyo(Integer.parseInt(request.getParameter("annyo")));
			try {
				empDAO.guardar(emp);
				System.out.println("Registro guardado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (opcion.equals("editar")) {
			Empleado emp = new Empleado();
			EmpleadoDAO empDAO = new EmpleadoDAO();
			emp.setNombre(request.getParameter("nombre"));
			emp.setDni(request.getParameter("dni"));
			emp.setSexo(request.getParameter("sexo"));
			emp.setCategoria(Integer.parseInt(request.getParameter("categoria")));
			emp.setAnnyo(Integer.parseInt(request.getParameter("annyo")));
			try {
				empDAO.editar(emp);
				System.out.println("Registro editado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// doGet(request, response);
	}

}
