package com.ramanjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ramanjava.bean.DsCartonItemBean;
import com.ramanjava.dao.DsCartonItemdao;


@Service("dsCartonItemService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DsCartonItemServiceImpl implements DsCartonItemService {
	
	@Autowired
	private DsCartonItemdao dsCartonItemdao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDsCartonItem(DsCartonItemBean dsCartonItem) {
		dsCartonItemdao.addDsCartonItem(dsCartonItem);
	}
	
	public List<DsCartonItemBean> getDscartonItems(){
		return dsCartonItemdao.getDscartonItems();
		
	}
	
	@Override
	public DsCartonItemBean getDsCartonItem(int cartonItemId) {
		return dsCartonItemdao.getDsCartonItem(cartonItemId);
		
	}
	@Override
	public void deleteDsCartonItem(int cartonItemId) {
		dsCartonItemdao.deleteDsCartonItem(cartonItemId);
		
	}

}
