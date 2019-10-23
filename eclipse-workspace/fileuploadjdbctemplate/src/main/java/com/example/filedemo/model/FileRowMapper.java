package com.example.filedemo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class FileRowMapper implements RowMapper<DBFile> {

	@Override
	public DBFile mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DBFile dbFile = new DBFile();
		
		return dbFile;
	}

}
