package com.ramanjava.service;

import java.util.List;

import com.ramanjava.bean.DsCartonItemBean;

public interface DsCartonItemService {
	
	public void addDsCartonItem(DsCartonItemBean dsCartonItem);
	public List<DsCartonItemBean> getDscartonItems();	
	public DsCartonItemBean getDsCartonItem(int cartonItemId);	
	public void deleteDsCartonItem(int cartonItemId);

}
