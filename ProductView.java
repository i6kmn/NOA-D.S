package View;

import Model.Product;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public ProductView() {
        setTitle("Lista de Produtos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criando colunas da tabela
        String[] colunas = {"ID", "Nome", "Preço"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modeloTabela);

        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void mostrarProdutos(List<Product> produtos) {
        modeloTabela.setRowCount(0); // Limpa a tabela
        for (Product p : produtos) {
            modeloTabela.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getPreco()
            });
        }
        setVisible(true);
    }
}
