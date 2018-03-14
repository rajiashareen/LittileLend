function callbeforeload()
{
    if(sessionStorage.getItem("userbean")==null)
    {
    	window.location("login.jsp"); 
    }
    
}





