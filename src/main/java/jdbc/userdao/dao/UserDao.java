package jdbc.userdao.dao;

import jdbc.userdao.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserDao {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user) {
        this.jdbcTemplate.update("insert into users(id, name, password) values (?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public int deleteAll() {
        return this.jdbcTemplate.update("delete from users");
    }

    public User findByID(String id) throws SQLException {
        Map<String, String> env = System.getenv();
        Connection c;
        c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("select *from users where id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User(rs.getString("id"), rs.getString("name"),
                    rs.getString("password"));
        }
        rs.close();
        ps.close();
        c.close();
        if (user == null) throw new RuntimeException();
        return user;
    }
}
