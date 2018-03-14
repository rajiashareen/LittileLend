package com.littlelend.Service;

import java.util.List;

import com.littlelend.dao.LoginDao;
import com.littlelend.dto.ItemUserbean;
import com.littlelend.dto.Itembean;
import com.littlelend.dto.MessageItemUserBean;
import com.littlelend.dto.Messagebean;
import com.littlelend.dto.Userbean;

public class ILendServiceImp implements ILendService{

	LoginDao ldao=new LoginDao();



	@Override
	public boolean registeruser(Userbean userbean) {
		// TODO Auto-generated method stub
		return ldao.registeruser(userbean);
	}

	@Override
	public boolean checkuser(String email) {
		// TODO Auto-generated method stub
		return ldao.checkuser(email);
	}

	@Override
	public Userbean validate(String name, String password) {
		// TODO Auto-generated method stub
		return ldao.validate(name,password);
	}

	@Override
	public boolean itemdataenter(Itembean itembean) {
		// TODO Auto-generated method stub
		return ldao.itemdataenter(itembean);
	}

	@Override
	public boolean deleteitempost(String itemid) {
		// TODO Auto-generated method stub
		return ldao.deleteitempost(itemid);
	}

	@Override
	public Userbean getborrowerdetails(int itemids) {
		// TODO Auto-generated method stub
		return ldao.getborrowerdetails(itemids);
	}

	@Override
	public List<Itembean> getitemListByid(int id) {
		// TODO Auto-generated method stub
		return ldao.getitemListByid(id);
	}

	@Override
	public List<ItemUserbean> getitemList() {
		// TODO Auto-generated method stub
		return ldao.getitemList();
	}

	@Override
	public boolean messagedataenter(Messagebean messagebean) {
		// TODO Auto-generated method stub
		return ldao.messagedataenter(messagebean);
	}

	@Override
	public List<MessageItemUserBean> getallmessages(Messagebean messagebean) {
		// TODO Auto-generated method stub
		return ldao.getallmessages(messagebean);
	}

	@Override
	public List<MessageItemUserBean> getreceivedmessages(Messagebean messagebean) {
		// TODO Auto-generated method stub
		return ldao.getreceivedmessages(messagebean);
	}


	@Override
	public boolean updateItemtable(Itembean ib) {
		// TODO Auto-generated method stub
		return ldao.updateItemtable(ib);
	}

	@Override
	public boolean updateflaggedItemtable(Itembean ib) {
		// TODO Auto-generated method stub
		return ldao.updateflaggedItemtable(ib);
	}

	@Override
	public List<ItemUserbean> getitemFlaggedList() {
		// TODO Auto-generated method stub
		return ldao.getitemFlaggedList();
	}

	@Override
	public boolean deleteflagpost(String itemflagid) {
		// TODO Auto-generated method stub
		return ldao.deleteflagpost(itemflagid);
	}






	

	
	
	

}
