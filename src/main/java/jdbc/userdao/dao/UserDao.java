package jdbc.userdao.dao;

import jdbc.userdao.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserDao {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate){
        this.dataSource=dataSource;
        this.jdbcTemplate=jdbcTemplate;
    }
    public void add(User user){
        this.jdbcTemplate.update("insert into users(id, name, password) values (?,?,?)",
                user.getId(),user.getName(),user.getPassword());
    }
}
