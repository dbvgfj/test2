package Guitar.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Guitar.dao.ID;
import Guitar.dao.impl.GuitarSpec;
import Guitar.entity.Builder;
import Guitar.entity.Guitar;
import Guitar.entity.Type;
import Guitar.entity.Wood;

public class findguitar extends HttpServlet{
	
	 private static final long serialVersionUID = 1L ; 
	 public void doGet(HttpServletRequest request,HttpServletResponse response)throws 
		ServletException,IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws
		ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		
		double price =Double.parseDouble(request.getParameter("price"));
		String builder =request.getParameter("builder");
		String model =request.getParameter("model");
		String type =request.getParameter("type");
		String backwood =request.getParameter("backwood");
		String topwood =request.getParameter("topwood");
		
		Inventory inventory = new Inventory();
		GuitarSpec whatErinLikes = new GuitarSpec(null, null, null, 0, null, null);
		
		List matchingGuitars = inventory.search(whatErinLikes);
		
		if (!matchingGuitars.isEmpty()) {
			request.setAttribute("price",price);
			request.setAttribute("builder",builder);
			request.setAttribute("model",model);
			request.setAttribute("type",type);
			request.setAttribute("backwood",backwood);
			request.setAttribute("topwood",topwood);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("null.jsp").forward(request, response);
		}
}
}