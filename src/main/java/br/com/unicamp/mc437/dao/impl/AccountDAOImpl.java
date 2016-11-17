package br.com.unicamp.mc437.dao.impl;

import br.com.unicamp.mc437.dao.AbstractDAO;
import br.com.unicamp.mc437.dao.AccountDAO;
import br.com.unicamp.mc437.jdbc.AccountRowMapper;
import br.com.unicamp.mc437.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl extends AbstractDAO implements AccountDAO {

    private static final String SELECT_ACCOUNT_BY_ID_QUERY = "SELECT * FROM account WHERE account_id = :id";

    @Override
    public Account getAccountById(Long id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        List<Account> accountList = new NamedParameterJdbcTemplate(this.getJdbcTemplate()).query(SELECT_ACCOUNT_BY_ID_QUERY,
                params, new AccountRowMapper());

        if (accountList == null || accountList.isEmpty()) {
            return null;
        }
        return accountList.get(0);
    }
}
