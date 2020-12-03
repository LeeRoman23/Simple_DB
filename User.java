import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;

public class User {
    private String login;
    private String password;
    private int money;
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "96601990";
    Connection connection;
    Statement statement;

    Scanner in = new Scanner(System.in);

    public User() {
        System.out.print("Enter your new login: ");
        this.login = in.next();
        this.password = PasswordBuilder.createPassword();
        System.out.println("Your new password is: " + password);
        System.out.print("Do you want to change password? y/n  ");
        if (in.next().equalsIgnoreCase("y")) {
            changePassword();
        }
        System.out.print("How much money to you want to put: ");
        this.money = in.nextInt();
        System.out.println("=======================================");
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePassword() {
        System.out.print("Enter your new password: ");
        this.password = in.next();
    }

    public Connection getConnection() {
        return connection;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public int checkMoney() {
        try {
            System.out.println("If you want to check your bank account sing in (Check register): ");
            System.out.print("Enter your login: ");
            String username = in.next();
            System.out.print("Enter your password: ");
            String password = in.next();
            statement = getConnection().createStatement();
            String query = "SELECT money FROM users WHERE login='" + username + "' AND password='" + password +"';";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("We can't find user with such credentials.");;
            return 0;
        }
    }

    public boolean deleteProfile() {
        System.out.print("Are you sure you want to delete profile? y/n  ");
        if (in.next().equalsIgnoreCase("y")) {
            try {
                statement.getConnection().createStatement();
                System.out.print("Enter your login: ");
                String login = in.next();
                System.out.print("Enter your password: ");
                String password = in.next();
                System.out.print("Confirm deleting. y/n  ");
                if (in.next().equalsIgnoreCase("y")) {
                    String query = "DELETE FROM users WHERE login='" + login + "' AND password='" + password + "';";
                    boolean resultSet = statement.execute(query);
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("Incorrect data...");;
            }
        }
        return false;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
