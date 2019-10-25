package com.ramanjava.service;

import java.util.List;

import com.ramanjava.bean.DsCartonBean;

public interface DsCartonService {

	public void addDsCarton(DsCartonBean dsCarton);
	public List<DsCartonBean> getDscartons();	
	public DsCartonBean getDsCarton(int cartonId);	
	public void deleteDsCarton(int cartonId);

}
