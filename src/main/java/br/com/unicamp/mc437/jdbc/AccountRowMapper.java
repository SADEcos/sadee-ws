package br.com.unicamp.mc437.jdbc;

import br.com.unicamp.mc437.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_USERNAME = "username";

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();

        account.setFirstName(resultSet.getString(COLUMN_FIRST_NAME));
        account.setLastName(resultSet.getString(COLUMN_LAST_NAME));
        account.setUsername(resultSet.getString(COLUMN_USERNAME));

        return account;
    }
}
