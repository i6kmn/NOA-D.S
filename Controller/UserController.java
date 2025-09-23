package Controller;

import Db.Database;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    public List<User> listarUsuarios() {
        List<User> usuarios = new ArrayList<>();
//try cach para lidar com possíveis exceções
        // tenta e depois fecha a conexão
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM Usuario";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                usuarios.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}