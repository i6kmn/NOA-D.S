package Controller;

import Db.Database;
import Model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public List<Product> listarProdutos() {
        List<Product> produtos = new ArrayList<>();

        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT id, nome, preco, estoque, categoria_id FROM produtos"; // Use o nome da sua tabela
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getBigDecimal("preco"), // Use getBigDecimal para o tipo DECIMAL
                        rs.getInt("estoque"),
                        rs.getInt("categoria_id")
                );
                produtos.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao acessar a base de dados: " + e.getMessage());
            e.printStackTrace();
            // Retorna lista vazia em caso de erro
        }

        return produtos;
    }
}