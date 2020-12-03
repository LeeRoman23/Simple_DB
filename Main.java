import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        User user1 = new User();
        String sql = ("INSERT INTO users (login, password, money) VALUES (" +
                "'"+user1.getLogin()+"',"+"'"+user1.getPassword()+"'," + user1.getMoney() + ");");
        try {
            Statement statement = user1.getConnection().createStatement();
            boolean resultSet = statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
