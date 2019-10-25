package com.dao;

import java.util.List;

import com.bean.CountryBean;
import com.bean.StateBean;

public interface StateDao {
	public List<StateBean> loadState(Integer countryId);
    public List<CountryBean> listCountry();


}
