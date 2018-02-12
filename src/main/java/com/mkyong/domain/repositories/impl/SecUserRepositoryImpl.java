package com.mkyong.domain.repositories.impl;

import com.mkyong.domain.models.SecUser;
import com.mkyong.domain.repositories.SecUserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
Create By: Ron Rith
Create Date: 2/12/2018
*/
@Repository
@Qualifier("secUserRepository")
public class SecUserRepositoryImpl implements SecUserRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SecUser> getAllUsers() {
        String sql = "select *from Employee";

        List<SecUser> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<SecUser>>() {
            public List<SecUser> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<SecUser> list = new ArrayList<SecUser>();
                while (rs.next()) {
                    SecUser secUser = new SecUser();
                    secUser.setUsername(rs.getString("username"));
                    secUser.setPassword(rs.getString("password"));
                    secUser.setEnabled(rs.getBoolean("enabled"));

                    list.add(secUser);
                }
                return list;
            }

        });
        return employeeList;
    }

    public SecUser getUserById(String username) {
        return null;
    }

    public void saveUser(SecUser secUser) {

    }

    public void updateUser(SecUser secUser, String username) {

    }
}
