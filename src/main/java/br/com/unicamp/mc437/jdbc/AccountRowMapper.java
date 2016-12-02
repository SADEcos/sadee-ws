package br.com.unicamp.mc437.jdbc;

import br.com.unicamp.mc437.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_USERNAME = "email";

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();

        account.setName(resultSet.getString(COLUMN_NAME));
        account.setEmail(resultSet.getString(COLUMN_USERNAME));

        return account;
    }
}
