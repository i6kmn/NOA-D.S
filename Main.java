import Controller.UserController;
import Controller.ProductController;
import Model.User;
import Model.Product;
import View.UserView;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Código para listar Usuários (que já existia)
        UserController userController = new UserController();
        UserView userView = new UserView();

        List<User> usuarios = userController.listarUsuarios();
        userView.mostrarUsuarios(usuarios);

        // --- Adicione este novo bloco de código ---
        System.out.println("\n--- Listando Produtos ---");

        // Crie uma instância do controlador de produtos
        ProductController productController = new ProductController();

        // Chame o método para listar os produtos
        List<Product> produtos = productController.listarProdutos();

        // Verifique se a lista não está vazia e imprima os produtos
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado. A tabela 'produtos' pode estar vazia ou há um problema na conexão.");
        } else {
            System.out.println("Produtos listados com sucesso!");
            for (Product p : produtos) {
                System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Preço: " + p.getPreco() + ", Estoque: " + p.getEstoque());
            }
        }
    }
}