package com.littlelend.dao;

import java.util.List;

import com.littlelend.dto.ItemUserbean;
import com.littlelend.dto.Itembean;
import com.littlelend.dto.MessageItemUserBean;
import com.littlelend.dto.Messagebean;
import com.littlelend.dto.Userbean;

public interface ILoginDao {
	public   Userbean validate(String name,String password);
	public boolean registeruser(Userbean userbean);
	public boolean checkuser(String email);
	public boolean itemdataenter(Itembean itembean);
	public boolean deleteitempost(String itemid);
	public Userbean getborrowerdetails(int itemids);
	public List<Itembean> getitemListByid(int id);
	public List<ItemUserbean> getitemList();
	public boolean messagedataenter(Messagebean messagebean);
	public List<MessageItemUserBean> getallmessages(Messagebean messagebean);
	public List<MessageItemUserBean> getreceivedmessages(Messagebean messagebean);
	public boolean updateItemtable(Itembean ib);
	public boolean updateflaggedItemtable(Itembean ib);
	public List<ItemUserbean> getitemFlaggedList();
	public boolean deleteflagpost(String itemflagid);

	
	

}
