package com.littlelend.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.littlelend.Service.ILendService;
import com.littlelend.Service.ILendServiceImp;
import com.littlelend.dto.ItemUserbean;

@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILendService service=new ILendServiceImp();
		 HttpSession session=request.getSession();
		 List<ItemUserbean> itemgetadminList =service.getitemFlaggedList();                 //funtion to get all flagged posts
		 if(itemgetadminList!=null)
         {
         	session.setAttribute("itemlistadmin", itemgetadminList );                      //sending flagged post to adminhome.jsp
         	 response.sendRedirect("adminhome.jsp");
         	 
         }
	}

}
