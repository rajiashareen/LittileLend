package com.littlelend.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.littlelend.dto.ItemUserbean;
import com.littlelend.dto.Itembean;
import com.littlelend.dto.MessageItemUserBean;
import com.littlelend.dto.Messagebean;
import com.littlelend.dto.Userbean;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class LoginDao implements ILoginDao {
//validate user at login
	@Override
	public Userbean validate(String name,String password) {
		System.out.println("encry   "+password);
		boolean status=false;  
		Userbean bean=new Userbean();
		bean.setId(-1);
		try{  
		 
		Connection con=DatabaseConnection.getConnection();
		    System.out.println(con);  
		PreparedStatement ps=con.prepareStatement( 
			
		"select * from userborrower where Bemail=? and Bpassword=?");  
		ps.setString(1,name);  
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();  
		while(rs.next())
		{
			bean.setId(rs.getInt("Bid"));
			bean.setFirstname(rs.getString("Bfirstname"));
			bean.setLastname(rs.getString("Blastname"));
			bean.setEmail(rs.getString("Bemail"));
			bean.setAddress(rs.getString("Baddress"));
			bean.setCity(rs.getString("Bcity"));
			bean.setZip(rs.getString("Bzip"));
			bean.setPhone(rs.getString("Bphone"));
			System.out.println("bzhb    "+rs.getString("Bpassword"));
		
		}
		        
		}catch(Exception e){System.out.println(e);}  
		return bean;
	}
//user registration
	@Override
	public boolean registeruser(Userbean userbean) {
		int rows = 0;
		boolean flag = false;
		try{ 
		Connection con=DatabaseConnection.getConnection();
	    System.out.println(con);  
	    String sql= "INSERT INTO userborrower (Bfirstname,Blastname,Bemail,Bpassword,Baddress,Bcity,Bzip,Bphone) VALUES (?,?,?,?,?,?,?,?)";
	    PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = con.prepareStatement(sql);
		ps.setString(1, userbean.getFirstname());
		ps.setString(2, userbean.getLastname());
		ps.setString(3, userbean.getEmail());
		ps.setString(4, userbean.getPassword());
		ps.setString(5, userbean.getAddress());
		ps.setString(6, userbean.getCity());
		ps.setString(7, userbean.getZip());
		ps.setString(8, userbean.getPhone());
		rows = ps.executeUpdate();
	
		}catch(Exception e){System.out.println(e);}  
		
		if(rows!= 0)
		{
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean checkuser(String email) {
		boolean status=false;
		try {
			Connection con=DatabaseConnection.getConnection();
            Statement st=con.createStatement();
           String sql=  "select * from userborrower where Bemail='"+email+"'";  
		   ResultSet rs=st.executeQuery(sql); 
		   if(rs.next())
		   {
			  status=true;
		   }
		   else
		   {
			  status=false; 
		   }
			
		} catch(Exception e){System.out.println(e);} 
		return status;
	}
//item insert
	@Override
	public boolean itemdataenter(Itembean itembean) {
		System.out.println("hiahbxhxbxhab"+ itembean);
		int rows = 0;
		boolean flag = false;
		try{ 
		Connection con=DatabaseConnection.getConnection();
	    System.out.println(con);
	    Date startdate=new Date(itembean.getStartdate().getTime());
	    Date enddate=new Date(itembean.getEnddate().getTime());
	    
	    String sql= "INSERT INTO items (itemCategory,itemName,startDate,endDate,description,BorrowerId,Flag) VALUES (?,?,?,?,?,?,?)";
	    PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = con.prepareStatement(sql);
		ps.setString(1, itembean.getCategory());
		ps.setString(2, itembean.getProductname());
		ps.setDate(3, startdate);
		ps.setDate(4, enddate);
		ps.setString(5, itembean.getDescription());
		ps.setInt(6, itembean.getBorrowerid());
		ps.setString(7, itembean.getFlag());
		rows = ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}  
		
		if(rows!= 0)
		{
			flag = true;
		}
		return flag;
	}
//get item list

	@Override
	public List<ItemUserbean> getitemList() {
		Connection con=null;
          PreparedStatement ps = null;
          
 
          String query = "select * from items inner join userborrower on items.BorrowerId=userborrower.Bid;";
          try {
			 con=DatabaseConnection.getConnection();
			 ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery();
             List<ItemUserbean> itemlist = new ArrayList<>();
             while(rs.next()){
                 int id = rs.getInt("itemsID"); 
                 String itemcategory = rs.getString("itemCategory");
                 String itemname = rs.getString("itemName");
                 Date startdate = rs.getDate("startDate");
                 Date endate = rs.getDate("endDate");
                 String description = rs.getString("description");
                int borrowerid = rs.getInt("BorrowerId");
                String borroweemail=rs.getString("Bemail");
                String borrowname=rs.getString("Bfirstname");
                String borrowlname=rs.getString("Blastname");
                String borrowaddress=rs.getString("Baddress");
                String borrowcity=rs.getString("Bcity");
                String borrowzip=rs.getString("Bzip");
                String borrowphone=rs.getString("Bphone");
                String flag=rs.getString("Flag");
               ItemUserbean itemUserbean=new ItemUserbean(id,borrowerid,itemcategory,itemname,description,flag,startdate,endate,borrowname,borrowlname,borroweemail,borrowaddress,borrowcity,borrowzip,borrowphone);
               itemlist.add(itemUserbean);  
             }
             System.out.println("abc"+itemlist);
             return itemlist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
          
          finally {         
              DBUtil.closePreparedStatement(ps);
              if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          }
	}

//delete item
	@Override
	public boolean deleteitempost(String itemid) {
		Connection con=null;
        PreparedStatement ps = null;
         int itemidget= Integer.parseInt(itemid);
         int rows=0;
         boolean flag=false;
        String sql = "DELETE FROM items where itemsID='"+itemidget+"'";
        try {
			con=DatabaseConnection.getConnection();
			 ps = con.prepareStatement(sql);
			 rows = ps.executeUpdate();
			 System.out.println("sxsjnjnc"+rows);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(rows!= 0)
		{
			
			flag = true;
		}
		System.out.println("wdewjfrekf"+flag);
		return flag;
        
	}

//get userdetails

	@Override
	public Userbean getborrowerdetails(int itemids) {
		Userbean bean=new Userbean();
		
		try{  
		 
		Connection con=DatabaseConnection.getConnection();
		    System.out.println(con);  
		PreparedStatement ps=con.prepareStatement(  
		"select * from userborrower where Bid=?");  
		ps.setInt(1,itemids);  
		
		ResultSet rs=ps.executeQuery();  
		while(rs.next())
		{
			bean.setId(rs.getInt("Bid"));
			bean.setFirstname(rs.getString("Bfirstname"));
			bean.setLastname(rs.getString("Blastname"));
			bean.setEmail(rs.getString("Bemail"));
			bean.setAddress(rs.getString("Baddress"));
			bean.setCity(rs.getString("Bcity"));
			bean.setZip(rs.getString("Bzip"));
			bean.setPhone(rs.getString("Bphone"));
		
		}
		        
		}catch(Exception e){System.out.println(e);}  
		System.out.println("wswgs"+bean);
		return bean;
        }
//get particular user itempostings
	@Override
	public List<Itembean> getitemListByid(int id) {
		
		Connection con=null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM items where BorrowerId=?";
        try {
			 con=DatabaseConnection.getConnection();
			 ps = con.prepareStatement(query);
			 ps.setInt(1,id); 
           ResultSet rs = ps.executeQuery();
           List<Itembean> itemlist = new ArrayList<>();
           while(rs.next()){
               int itemid = rs.getInt("itemsID"); 
               String itemcategory = rs.getString("itemCategory");
               String itemname = rs.getString("itemName");
               Date startdate = rs.getDate("startDate");
               Date endate = rs.getDate("endDate");
               String description = rs.getString("description");
              int borrowerid = rs.getInt("BorrowerId");
              Itembean itembean = new Itembean(itemid,borrowerid, itemcategory,itemname,description,startdate,endate);
               itemlist.add(itembean);
           }
           return itemlist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
        finally {         
            DBUtil.closePreparedStatement(ps);
            if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
	}
//insert messages
	@Override
	public boolean messagedataenter(Messagebean messagebean) {
		System.out.println("messagesbean"+messagebean);
		int rows = 0;
		boolean flag = false;
		 Date today=new Date(messagebean.getMessagdata().getTime());
		
		try{ 
		Connection con=DatabaseConnection.getConnection();
	    System.out.println(con);  
	    String sql= "INSERT INTO messages (MContent,Mdate,ItemMID,BorrowerIDMessages,sentID,receiverID,messageStatus) values (?,?,?,?,?,?,?);";
	    PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = con.prepareStatement(sql);
		ps.setString(1,messagebean.getMessageContent());
		ps.setDate(2,today);
		ps.setInt(3, messagebean.getItemMessageID());
		ps.setInt(4, messagebean.getUserMessageID());
		ps.setInt(5, messagebean.getSentID());
		ps.setInt(6, messagebean.getReceviverID());
		ps.setString(7, messagebean.getMessagestatus());
		rows = ps.executeUpdate();
	
		}catch(Exception e){System.out.println(e);}  
		
		if(rows!= 0)
		{
			flag = true;
		}
		return flag;
	}


//message get
	@Override
	public List<MessageItemUserBean> getallmessages(Messagebean messagebean) {
		Connection con=null;
        PreparedStatement ps = null;
        int sentid=messagebean.getSentID();
        int receiverid=messagebean.getReceviverID();
        System.out.println(receiverid+"id");
        

        String query = "SELECT * FROM messages m JOIN items i ON m.ItemMID = i.itemsID JOIN userborrower u ON m.receiverID =u.Bid and m.sentID='"+messagebean.getSentID()+"';";
      
        try {
			 con=DatabaseConnection.getConnection();
			 ps = con.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           List<MessageItemUserBean> itemlist = new ArrayList<>();
           while(rs.next()){
               int id = rs.getInt("MID"); 
               String messagecontent = rs.getString("MContent");
               int itemid = rs.getInt("ItemMID"); 
               int borrowerid = rs.getInt("BorrowerIDMessages"); 
               String itemname = rs.getString("itemName");
               String borrowername = rs.getString("Bfirstname");
               String borroweremail = rs.getString("Bemail");
               int receiid=rs.getInt("receiverID");
               int senid=rs.getInt("sentID");
               Date messagedate=rs.getDate("Mdate");
               
           
            MessageItemUserBean messageitembean=new MessageItemUserBean(id,borrowerid,itemid,receiid,senid,messagecontent,borrowername,borroweremail,itemname,messagedate);
            
            itemlist.add(messageitembean);
            
           }
           System.out.println("abc"+itemlist);
           return itemlist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
        finally {         
            DBUtil.closePreparedStatement(ps);
            if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
	}
//particular user message get
	@Override
	public List<MessageItemUserBean> getreceivedmessages(Messagebean messagebean) {
		Connection con=null;
        PreparedStatement ps = null;
        int receiverid=messagebean.getReceviverID();
        

        String query = "SELECT * FROM messages m JOIN items i ON m.ItemMID = i.itemsID JOIN userborrower u ON m.BorrowerIDMessages =u.Bid and m.receiverID='"+messagebean.getUserMessageID()+"';";
       
        try {
			 con=DatabaseConnection.getConnection();
			 ps = con.prepareStatement(query);
			
           ResultSet rs = ps.executeQuery();
           List<MessageItemUserBean> itemlist = new ArrayList<>();
           while(rs.next()){
               int id = rs.getInt("MID"); 
               String messagecontent = rs.getString("MContent");
               int itemid = rs.getInt("ItemMID"); 
               int borrowerid = rs.getInt("BorrowerIDMessages"); 
               String itemname = rs.getString("itemName");
               String borrowername = rs.getString("Bfirstname");
               String borroweremail = rs.getString("Bemail");
               int receiid=rs.getInt("receiverID");
               int senid=rs.getInt("sentID");
               Date todaymessage=rs.getDate("Mdate");
               
               
            MessageItemUserBean messageitembean=new MessageItemUserBean(id,borrowerid,itemid,receiid,senid,messagecontent,borrowername,borroweremail,itemname,todaymessage);
            itemlist.add(messageitembean);
           }
           return itemlist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
        finally {         
            DBUtil.closePreparedStatement(ps);
            if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
	}

//Flag update in items
	@Override
	public boolean updateItemtable(Itembean ib) {
	
		int rows = 0;
		boolean flag = false;
		try{ 
		Connection con=DatabaseConnection.getConnection();
	    System.out.println(con);  
	    String sql= "UPDATE items SET Flag = 'Flagged' WHERE itemsID ='"+ib.getItemid()+"';";
	    PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = con.prepareStatement(sql);
		rows = ps.executeUpdate();
	
		}catch(Exception e){System.out.println(e);}  
		
		if(rows!= 0)
		{
			flag = true;
		}
		return flag;
	}
//flagged status update
	@Override
	public boolean updateflaggedItemtable(Itembean ib) {
		int rows = 0;
		boolean flag = false;
		try{ 
		Connection con=DatabaseConnection.getConnection();
	    System.out.println(con);  
	    String sql= "UPDATE items SET Flag = 'Flag' WHERE itemsID ='"+ib.getItemid()+"';";
	    PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = con.prepareStatement(sql);
		rows = ps.executeUpdate();
	
		}catch(Exception e){System.out.println(e);}  
		
		if(rows!= 0)
		{
			flag = true;
		}
		return flag;
	}
//get flagged list
	@Override
	public List<ItemUserbean> getitemFlaggedList() {
		Connection con=null;
        PreparedStatement ps = null;
        String Flagged ="Flagged";
        

        String query = " select * from items inner join userborrower on items.BorrowerId=userborrower.Bid where Flag='"+Flagged+"'";
       
        try {
			 con=DatabaseConnection.getConnection();
			 ps = con.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           List<ItemUserbean> itemlist = new ArrayList<>();
           while(rs.next()){
               int id = rs.getInt("itemsID"); 
               String itemcategory = rs.getString("itemCategory");
               String itemname = rs.getString("itemName");
               Date startdate = rs.getDate("startDate");
               Date endate = rs.getDate("endDate");
               String description = rs.getString("description");
              int borrowerid = rs.getInt("BorrowerId");
              String borroweemail=rs.getString("Bemail");
              String borrowname=rs.getString("Bfirstname");
              String borrowlname=rs.getString("Blastname");
              String borrowaddress=rs.getString("Baddress");
              String borrowcity=rs.getString("Bcity");
              String borrowzip=rs.getString("Bzip");
              String borrowphone=rs.getString("Bphone");
              String flag=rs.getString("Flag");
             ItemUserbean itemUserbean=new ItemUserbean(id,borrowerid,itemcategory,itemname,description,flag,startdate,endate,borrowname,borrowlname,borroweemail,borrowaddress,borrowcity,borrowzip,borrowphone);
             itemlist.add(itemUserbean);  
           }
           System.out.println("abc"+itemlist);
           return itemlist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
        finally {         
            DBUtil.closePreparedStatement(ps);
            if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
	}
//admin funtionality delete flag posts
	@Override
	public boolean deleteflagpost(String itemflagid) {
		Connection con=null;
        PreparedStatement ps = null;
        System.out.println("item"+itemflagid);
         int itemidget= Integer.parseInt(itemflagid);
         int rows=0;
         boolean flag=false;
        String sql = "DELETE FROM items where itemsID='"+itemidget+"'";
        try {
			con=DatabaseConnection.getConnection();
			 ps = con.prepareStatement(sql);
			 rows = ps.executeUpdate();
			 System.out.println("sxsjnjnc"+rows);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(rows!= 0)
		{
			
			flag = true;
		}
		System.out.println("wdewjfrekf"+flag);
		return flag;
	}

	

		
	
	
}
