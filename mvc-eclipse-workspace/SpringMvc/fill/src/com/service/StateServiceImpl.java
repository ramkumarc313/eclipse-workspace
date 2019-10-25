package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.CountryBean;
import com.bean.StateBean;
import com.dao.StateDao;

@Service
public class StateServiceImpl implements StateService{

    @Autowired
    private StateDao stateDao;
    
    @Override
    @Transactional
    public List<StateBean> loadState(Integer countryId) {
        return stateDao.loadState(countryId);
    }

    @Override
    @Transactional
    public List<CountryBean> listCountry() {
        return stateDao.listCountry();
                
    }
 }
