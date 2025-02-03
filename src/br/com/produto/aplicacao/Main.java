package br.com.produto.aplicacao;

import br.com.estoque.dao.ProdutoDAO;
import br.com.estoqueLoja.model.Produto;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        String resp;

        System.out.println("Seja bem vindo ao estoque da Pichau");
        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Escolha uma opção abaixo: ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println(" 1  -  Adicionar novo produto                        ");
            System.out.println(" 2  -  Listar os produtos do Estoque:                ");
            System.out.println(" 3  -  Editar algum produto                          ");
            System.out.println(" 4  -  Deletar algum produto                         ");
            System.out.println(" 5  -  Sair                                          ");
            System.out.print(" >>  "); int opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1:
                    System.out.print("Digite o nome do produto novo: "); String produtoNovo = sc.nextLine();
                    System.out.print("Digite seu preço: "); double precoNovo = sc.nextDouble();
                    System.out.print("Digite a quantidade que terá em estoque: "); int quantidadeNova = sc.nextInt();
                    produto.setId(1);
                    produto.setNome(produtoNovo);
                    produto.setPreco(precoNovo);
                    produto.setQuantidadeE(quantidadeNova);
                    produtoDAO.save(produto);

                    break;

                case 2:
                    for (Produto p : produtoDAO.getProdutos()) {
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("Nº de identificação: "+ p.getId() +" | Nome: "+ p.getNome() +" | Preço: "+ p.getPreco() +" | Quantidade em Estoque: "+ p.getQuantidadeE());
                    }
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=");
                    break;

                case 3:
                    System.out.print("Deseja editar que atributo do produto[1-Nome, 2-Preço, 3-Quantidade no Estoque]: "); int opcDelete = sc.nextInt();
                    if (opcDelete == 1) {
                        System.out.println("Digite o ID do produto que deseja editar: "); int IDparaEditar = sc.nextInt(); sc.nextLine();
                        System.out.println("Digite o novo nome do produto: "); String NovoNome = sc.nextLine();
                        produtoDAO.update(NovoNome, IDparaEditar);
                    } else if (opcDelete == 2) {
                        System.out.println("Digite o ID do produto que deseja editar: "); int IDparaEditar = sc.nextInt(); sc.nextLine();
                        System.out.println("Digite o novo preço: "); double novoPreco = sc.nextDouble();
                        produtoDAO.update(novoPreco, IDparaEditar);
                    } else if (opcDelete == 3) {
                        System.out.println("Digite o ID do produto que deseja editar: "); int IDparaEditar = sc.nextInt(); sc.nextLine();
                        System.out.println("Digite a nova quantidade no estoque: "); int novoEstoque = sc.nextInt();
                        produtoDAO.update(novoEstoque, IDparaEditar);
                    } else {
                        System.out.println("Digitou algo errado!!");
                    }
                    break;

                case 4:

                    break;
                default:
                    System.out.println("Digitou algo errado!!");
            }
            System.out.print("Deseja continuar no estoque [S/N]: ");
            resp = sc.nextLine();
        } while (resp.equalsIgnoreCase("S") || resp.equalsIgnoreCase("sim"));
    }
}