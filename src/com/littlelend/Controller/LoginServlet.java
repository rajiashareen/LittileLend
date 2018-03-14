package com.littlelend.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.littlelend.Service.ILendService;
import com.littlelend.Service.ILendServiceImp;
import com.littlelend.dao.LoginDao;
import com.littlelend.dto.ItemUserbean;
import com.littlelend.dto.PasswordService;
import com.littlelend.dto.Userbean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		//Logout
		HttpSession session=req.getSession();
		session.removeAttribute("userbean");
		session.removeAttribute("itemlist");
		session.removeAttribute("itemabeanlist");
		session.removeAttribute("messagelist");
		session.removeAttribute("messagereceivedlist");
	    session.setAttribute("loggedIn", "logout");
	    req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ILendService service=new ILendServiceImp(); 
	    String action = request.getParameter("action");
	    String loginaction = request.getParameter("loginaction");
	    
		RequestDispatcher view = null; 
		
		//Registration
		if(action!=null && action.equalsIgnoreCase("register"))
		{
			String fname=request.getParameter("firstname");  
		    String lname=request.getParameter("lastname");  
		    String email=request.getParameter("email"); 
		    String password=request.getParameter("password"); 
		    String address=request.getParameter("address"); 
		    String city=request.getParameter("city"); 
		    String zip=request.getParameter("zipcode"); 
		    String phone=request.getParameter("phone"); 
		    PasswordService pws=new PasswordService();
			String encryptedPass = pws.encrypt(password);
	
		    boolean check=service.checkuser(email);	                  //check email exist 
		
		    if(check)
		    {
		    	 request.setAttribute("errordisplayMessage", "Email Exists!!");
		    	view=request.getRequestDispatcher("register.jsp");
				view.forward(request, response);
		    }
		    
		    else
		    {
		    Userbean user=new Userbean();
		    user.setId(1);
		    user.setFirstname(fname);
		    user.setLastname(lname);
		    user.setEmail(email);
		    user.setPassword(encryptedPass);
		    user.setAddress(address);
		    user.setCity(city);
		    user.setZip(zip);
		    user.setPhone(phone);
		    boolean result=service.registeruser(user);
		    if(result)
		    {
		    	 view=request.getRequestDispatcher("login.jsp");
					view.forward(request, response);
		    }
		    else
		    {
		    	  request.setAttribute("errordisplayMessage", "Email Exists!!");
		    	   view=request.getRequestDispatcher("register.jsp");
		    	  view.forward(request, response);
		    }
		    }
			
			
		   
		}
	    //Login
		if(loginaction!=null && loginaction.equalsIgnoreCase("login"))
		{
			   String username=request.getParameter("username");  
			   HttpSession session=request.getSession();
			    String password=request.getParameter("password"); 
			    Userbean userbean=new Userbean();
			    PasswordService pws=new PasswordService();                                        //password hash class
				String encryptedPass = pws.encrypt(password);
			    userbean= service.validate(username,encryptedPass);
			  
			    
			    if(userbean.getId()== -1){                                                          //for invalid email or password
					 session.setAttribute("loggedIn", "failed");
					 request.setAttribute("errorMessage", "Invalid email or password");
				       request.getRequestDispatcher("login.jsp").forward(request, response);
				 }
			    else
			    {
			    	 if(userbean!=null)
				    	{
			    		 if(userbean.getEmail().equalsIgnoreCase("admin@gmail.com"))                           //admin mailid
					    	{
			    			 session.setAttribute("loggedIn", "success");
					    	 session.setAttribute("userbean", userbean);
					    	 
							 List<ItemUserbean> itemgetadminList =service.getitemFlaggedList();
							 
							 System.out.println(itemgetadminList);
							 if(itemgetadminList!=null)
					         {
					         	session.setAttribute("itemlistadmin", itemgetadminList );
					         	RequestDispatcher rd=request.getRequestDispatcher("adminhome.jsp");  
						        rd.forward(request,response);
					         	
					         	 
					         } 
					    	}
			    		 else
			    		 {
			    			
				    		System.out.println("hbhbxh"+userbean);
				    		session.setAttribute("loggedIn", "success");
					    	 session.setAttribute("userbean", userbean);
				    		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
					        rd.forward(request,response);
			    		 }
				    	}
			    		
			    }
			      
			  
		}
		
		
	    } 

}
