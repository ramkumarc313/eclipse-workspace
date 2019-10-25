package com.service;

import java.util.List;

import com.bean.CountryBean;
import com.bean.StateBean;

public interface StateService {

    public List<StateBean> loadState(Integer countryId);
    public List<CountryBean> listCountry();

}
