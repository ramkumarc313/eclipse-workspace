package com.ramanjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ramanjava.bean.DsCartonBean;
import com.ramanjava.dao.DsCartondao;

@Service("dsCartonService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DsCartonServiceImpl implements DsCartonService {

	@Autowired
	private DsCartondao dsCartondao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDsCarton(DsCartonBean dsCarton) {
		dsCartondao.addDsCarton(dsCarton);
	}


	public List<DsCartonBean> getDscartons(){
		return dsCartondao.getDscartons();
	}
	
	@Override
	public DsCartonBean getDsCarton(int cartonId) {
		return dsCartondao.getDsCarton(cartonId);

	}
	
	@Override
	public void deleteDsCarton(int cartonId) {
		dsCartondao.deleteDsCarton(cartonId);

	}

}
