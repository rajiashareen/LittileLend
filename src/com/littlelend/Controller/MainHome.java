package com.littlelend.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.User;
import org.apache.catalina.ha.session.SessionMessage;

import com.littlelend.Service.ILendService;
import com.littlelend.Service.ILendServiceImp;
import com.littlelend.dto.ItemUserbean;
import com.littlelend.dto.Itembean;
import com.littlelend.dto.MessageItemUserBean;
import com.littlelend.dto.Messagebean;
import com.littlelend.dto.Userbean;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;


@WebServlet("/MainHome")
public class MainHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MainHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher view = null;
	    //getting action
	    String contactaction=request.getParameter("contactaction");
	    String  homeaction=request.getParameter("mainaction");
	    String  action=request.getParameter("postingaction");
	    String  actionlen=request.getParameter("deletepost");
	    String  mesagepostaction=request.getParameter("messagepost");
	    String  mesagesend=request.getParameter("messagesend");
	    String  messageaction=request.getParameter("messageaction");
	    String  flagpostaction=request.getParameter("flagpost");
	    String  flaggedpostaction=request.getParameter("flaggedpost");
	    String adminaction=request.getParameter("deleteflag");
	   
	
	    //post insert
	    
		if(homeaction!=null && homeaction.equalsIgnoreCase("mainhome"))
		{
			HttpSession session=request.getSession();
			      Userbean userbean=new Userbean();
			      userbean=(Userbean) session.getAttribute("userbean");
			      String category=request.getParameter("search");
			      String item=request.getParameter("dropdownlistvalue");
			      String strdate=request.getParameter("startdate");
			      String endate=request.getParameter("endate");
			      String description=request.getParameter("desriptionte");
				  String email=request.getParameter("lastname");
			      
			      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			       Date startdate=null;
			       Date enddate=null;
			       Date todayDate = new Date();
			  
				try {
					startdate=formatter.parse(strdate);
					enddate = formatter.parse(endate);
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
			   
			     System.out.println("cat"+category+"ite,"+item+"str"+startdate+"end"+enddate+"desc"+description+"emai"+todayDate);
			     
			     if(category==null || item ==null || startdate== null || enddate ==null   || startdate.before(todayDate) || enddate.before(todayDate) || enddate.before(startdate))
			     {
			    	request.setAttribute("detailsMessage", "Enter  correct post details");
	             	RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
			        rd.forward(request,response);
			    	 
			     }
			     else
			     {
			  
			    Itembean itembean=new Itembean();
			    ILendService service=new ILendServiceImp();
			     int userid= userbean.getId();
			     
			     
			     itembean.setCategory(category);
			     itembean.setProductname(item);
			     itembean.setStartdate(startdate);
			     itembean.setEnddate(enddate);
			     itembean.setDescription(description);
			     itembean.setBorrowerid(userid);
			     itembean.setFlag("Flag");
			     boolean iteminsert= service.itemdataenter(itembean);                       //item db store
			     System.out.println("itgdvcg"+ itembean);
			         if(iteminsert)
			         {
				   Itembean itembeans=new Itembean();   
			        List<ItemUserbean> itemgetList =service.getitemList(); 
			        List<Itembean>itemabeanlist=service.getitemListByid(userbean.getId());
			        System.out.println(userbean.getId()+"nnnnn");
			        System.out.println("iteam"+itemabeanlist);
	               if(itemgetList!=null)
	               {
	               	session.setAttribute("itemlist", itemgetList);
	               	session.setAttribute("itemabeanlist", itemabeanlist);
	               	 response.sendRedirect("postingsitem.jsp");
	               	 
	               }
                 			     
			         }	 
			     }
		}
		
		//post display
		
		if(action!=null && action.equalsIgnoreCase("Postings"))
		{
			ILendService service=new ILendServiceImp();
			HttpSession session=request.getSession();
			   Userbean userbean=new Userbean();
	           userbean=(Userbean) session.getAttribute("userbean");
			Itembean itembeans=new Itembean();   
		    List<ItemUserbean> itemgetList =service.getitemList();                                  //get all item list                           
		      List<Itembean>itemabeanlist=service.getitemListByid(userbean.getId());                //get all item listitem
		      System.out.println("snss"+itemabeanlist);
             if(itemgetList!=null)
             {
            	 	session.setAttribute("itemlist", itemgetList);
	               	session.setAttribute("itemabeanlist", itemabeanlist);
             	
	                response.sendRedirect("postingsitem.jsp");
             	 
             	 
             }
			
		}
		
		//delete post
		
		if(actionlen!=null && actionlen.equalsIgnoreCase("deletepost"))
		{
			 String itemid=request.getParameter("key");
			 System.out.println("ket"+itemid);
			 HttpSession session=request.getSession();
			 ILendService service=new ILendServiceImp();
			 boolean deleteboolean=service.deleteitempost(itemid);
			 Userbean userbean=new Userbean();
	         userbean=(Userbean) session.getAttribute("userbean");
			 if(deleteboolean)
			 {
				 List<ItemUserbean> itemgetList =service.getitemList();
			      List<Itembean>itemabeanlist=service.getitemListByid(userbean.getId());
	             if(itemgetList!=null)
	             {
	            	    session.setAttribute("itemlist", itemgetList);
		               	session.setAttribute("itemabeanlist", itemabeanlist);
		               	session.setAttribute("userbean", userbean);
		                response.sendRedirect("postingsitem.jsp");
	             	 
	             	 
	             }
			 }else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("postingsitem.jsp");  
			     rd.forward(request,response);
				 
			 }
			
		
		}
		
		//message insert
		
		if(mesagepostaction!=null && mesagepostaction.equalsIgnoreCase("messagepost"))
		{
			 HttpSession session=request.getSession();
			  String itemid=request.getParameter("itemval");
			  int itemids=Integer.parseInt(itemid);
			  String category=request.getParameter("category");
			  String item=request.getParameter("item");
			  String description=request.getParameter("description");
			  String startdate=request.getParameter("startdate");
			  String endate=request.getParameter("endate");
			  String borrowerid=request.getParameter("biid");
			  int bid=Integer.parseInt(borrowerid);
			  String borrowerfirstname=request.getParameter("bfname");
			  String borroweremail=request.getParameter("bemail");
			  String borrowercity=request.getParameter("bcity");
			  Userbean userbean=new Userbean();
	           userbean=(Userbean) session.getAttribute("userbean");
			  System.out.println(""+category +  item + startdate);
			  
		      SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		       Date startdat=null;
		       Date enddat=null;
			try {
				startdat=formatter.parse(startdate);
				enddat= formatter.parse(endate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			  
		ItemUserbean itemuserbean= new ItemUserbean(itemids,bid,category,item,description,startdat,enddat,borrowerfirstname," ",borroweremail," ",borrowercity," ",""); 
		session.setAttribute("itemuserbean", itemuserbean);	
		session.setAttribute("userbean", userbean);	
		 response.sendRedirect("meesagesend.jsp");
				
		}
		
		//messages all display
		if(mesagesend!=null && mesagesend.equalsIgnoreCase("messagesend"))
		{
			ILendService service=new ILendServiceImp();
			 HttpSession session=request.getSession();
			 Userbean userbean=new Userbean();
	           userbean=(Userbean) session.getAttribute("userbean");
			String messagecontent=request.getParameter("messageconte");
			if(messagecontent==null)
			{
				request.setAttribute("Messageblank", "Enter  Message");
				 response.sendRedirect("messagesend.jsp");
             	
				
			}
			else
			{
			ItemUserbean itemUserbean=(ItemUserbean) session.getAttribute("itemuserbean");
			int itemid=itemUserbean.getItemid();
			int sentid=userbean.getId();
			int receiverid=itemUserbean.getBorrowerid();
			Userbean userbeanreceived=service.getborrowerdetails(receiverid);
			String receivername=userbeanreceived.getFirstname();
		      Date todayDate = new Date();
		  
		
	      
			Messagebean messagebean=new Messagebean(123,itemid,userbean.getId(),sentid,receiverid,messagecontent,"sent",todayDate);
			session.setAttribute("messagebean", messagebean);
			 boolean messageinsert= service.messagedataenter(messagebean);
			 if(messageinsert)
			 {
				 
				List<MessageItemUserBean>messagelist= service.getallmessages(messagebean);
				List<MessageItemUserBean>messagereceivedlist=service.getreceivedmessages(messagebean);
				System.out.println(messagelist);
				System.out.println(messagereceivedlist+"user");
				if(messagelist!=null)
				{
					session.setAttribute("messagelist", messagelist);
					session.setAttribute("messagereceivedlist", messagereceivedlist);
					session.setAttribute("userbeanreceived", userbeanreceived);
					userbean=(Userbean) session.getAttribute("userbean");
					session.setAttribute("userbean", userbean);
					response.sendRedirect("messages.jsp");
					
						  
				}
			 }
			
			
			}
			
			
			 
		}
		//get sent messages
		if(messageaction!=null && messageaction.equalsIgnoreCase("messages"))
		{
			ILendService service=new ILendServiceImp();
			 HttpSession session=request.getSession();
				Userbean userbean=(Userbean) session.getAttribute("userbean");
				Date todayDate = new Date();
			 Messagebean messagebean=new Messagebean(123,122,userbean.getId(),userbean.getId(),userbean.getId(),"","sent",todayDate);
			List<MessageItemUserBean>messagelist= service.getallmessages(messagebean);
			List<MessageItemUserBean>messagereceivedlist=service.getreceivedmessages(messagebean);
			
			if(messagelist!=null)
			{
				session.setAttribute("messagelist", messagelist);
				session.setAttribute("messagereceivedlist", messagereceivedlist);
				response.sendRedirect("messages.jsp");
				
				
					  
			}
		
		}
		
		//flagpost
		if(flagpostaction!=null && flagpostaction.equalsIgnoreCase("flagpost"))
			
		{
			 HttpSession session=request.getSession();
			 ILendService service=new ILendServiceImp();
			 String  flagpostbutton=request.getParameter("flagpost");
			  String itemid=request.getParameter("itemval");
			  int itemids=Integer.parseInt(itemid);
			  String category=request.getParameter("category");
			  String item=request.getParameter("item");
			  String description=request.getParameter("description");
			  String startdate=request.getParameter("startdate");
			  String endate=request.getParameter("endate");
			  String borrowerid=request.getParameter("biid");
			  int bid=Integer.parseInt(borrowerid);
			  String borrowerfirstname=request.getParameter("bfname");
			  String borroweremail=request.getParameter("bemail");
			  String borrowercity=request.getParameter("bcity");
			  Userbean userbean=new Userbean();
	           userbean=(Userbean) session.getAttribute("userbean");
			  System.out.println(""+category +  item + startdate);
			  
		
		      SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		       Date startdat=null;
		       Date enddat=null;
			try {
				startdat=formatter.parse(startdate);
				enddat= formatter.parse(endate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  Itembean ib=new Itembean(itemids,bid,category,item,description,flagpostbutton,startdat,enddat);
	           boolean updatestatus=service.updateItemtable(ib);
	           if(true)
	           {
	        	    List<ItemUserbean> itemgetList =service.getitemList(); 
			        List<Itembean>itemabeanlist=service.getitemListByid(userbean.getId());
			        System.out.println(itemgetList);
	        	   
	        	   if(itemgetList!=null)
	               {
	               	session.setAttribute("itemlist", itemgetList);
	               	session.setAttribute("itemabeanlist", itemabeanlist);
	               	 response.sendRedirect("postingsitem.jsp");
	               	 
	               }
	           }
			
			
		}
		
		//change flaggedpost status
	if(flaggedpostaction!=null && flaggedpostaction.equalsIgnoreCase("flaggedpost"))
			
		{
			 HttpSession session=request.getSession();
			 ILendService service=new ILendServiceImp();
			 String  flagpostbutton=request.getParameter("flaggedpost");
			  String itemid=request.getParameter("itemval");
			  int itemids=Integer.parseInt(itemid);
			  String category=request.getParameter("category");
			  String item=request.getParameter("item");
			  String description=request.getParameter("description");
			  String startdate=request.getParameter("startdate");
			  String endate=request.getParameter("endate");
			  String borrowerid=request.getParameter("biid");
			  int bid=Integer.parseInt(borrowerid);
			  String borrowerfirstname=request.getParameter("bfname");
			  String borroweremail=request.getParameter("bemail");
			  String borrowercity=request.getParameter("bcity");
			  Userbean userbean=new Userbean();
	           userbean=(Userbean) session.getAttribute("userbean");
			  System.out.println(""+category +  item + startdate);
			  
		
		      SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		       Date startdat=null;
		       Date enddat=null;
			try {
				startdat=formatter.parse(startdate);
				enddat= formatter.parse(endate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  Itembean ib=new Itembean(itemids,bid,category,item,description,flagpostbutton,startdat,enddat);
	           boolean updatestatus=service.updateflaggedItemtable(ib);
	           if(true)
	           {
	        	    List<ItemUserbean> itemgetList =service.getitemList(); 
			        List<Itembean>itemabeanlist=service.getitemListByid(userbean.getId());
			        System.out.println(itemgetList);
	        	   
	        	   if(itemgetList!=null)
	               {
	               	session.setAttribute("itemlist", itemgetList);
	               	session.setAttribute("itemabeanlist", itemabeanlist);
	               	 response.sendRedirect("postingsitem.jsp");
	               	 
	               }
	           }
			
			
		}
	 //admin funtionality delete flagged posts
	if(adminaction!=null && adminaction.equalsIgnoreCase("deleteflag"))
	{
		 String itemflagid=request.getParameter("deletekey");
		 System.out.println("ajnx"+ itemflagid);
		 HttpSession session=request.getSession();
		 ILendService service=new ILendServiceImp();
		 boolean deleteboolean=service.deleteflagpost(itemflagid);
		 Userbean userbean=new Userbean();
         userbean=(Userbean) session.getAttribute("userbean");
		 if(deleteboolean)
		 {
			 
			 List<ItemUserbean> itemgetadminList =service.getitemFlaggedList();
			 
			 System.out.println(itemgetadminList);
			 if(itemgetadminList!=null)
	         {
	         	session.setAttribute("itemlistadmin", itemgetadminList );
	         	response.sendRedirect("adminhome.jsp");
				
	         
	         	 
	         } 
		 }else
		 {
			 	response.sendRedirect("adminhome.jsp"); 
		 }
		
	}
	
	//contact and email funtionality
	if(contactaction!=null && contactaction.equalsIgnoreCase("contactaction"))
	{
		 String from=request.getParameter("contactEmailid");
		 String messagesent=request.getParameter("contactbox");
		String user="lendlittle@gmail.com";
		String password="lend123@";
		String to="lendlittle@gmail.com";
		
		
		
		Properties props = System.getProperties();
		   props.put("mail.smtp.host","smtp.gmail.com");  
		   props.put("mail.smtp.auth", "true");  
		  
		   props.put("mail.smtp.port", "587");
		   props.put("mail.smtp.starttls.enable", "true");
		 
		   javax.mail.Session session=javax.mail.Session.getInstance(props,new Authenticator() {
			   protected PasswordAuthentication getPasswordAuthentication() {  
				    return new PasswordAuthentication(user,password);  
				      }  
		});
		   
		   try{  
		         MimeMessage message = new MimeMessage(session);  
		         message.setFrom(new InternetAddress(from));
		         message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to)); 
		         message.setSubject("Contact admin");  
		         message.setText(messagesent);  
		  
		       
		         Transport.send(message);  
		         request.setAttribute("sendEmail", "Mail Sent!!");
		      	response.sendRedirect("contact.jsp");
			    	
		         
		         System.out.println("message sent successfully....");  
		  
		      }catch (MessagingException mex)
		   {
		    	  
		    	  
		    	  
		    	  
		    	  mex.printStackTrace();
		  }  
		     
		   
		 
		
	}
	
	}

}
