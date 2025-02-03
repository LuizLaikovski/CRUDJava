package br.com.estoque.dao;

import br.com.estoque.factory.ConnectionFactory;
import br.com.estoqueLoja.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    // CREATE
    public void save(Produto produto) {
        String sql = "INSERT INTO produtos(nome, preco, quantidadeEstoque) VALUES (?, ?, ?)";

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            // CRIA UMA CONEXÃO COM O BANCO DE DADOS
            connection = ConnectionFactory.createConnectionToMySQL();

            // CRIAMOS UMA prepareStatement PARA UMA QUERY
            pstm = (PreparedStatement) connection.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setDouble(2, produto.getPreco());
            pstm.setInt(3, produto.getQuantidadeE());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // READ
    public List<Produto> getProdutos() throws SQLException {
        String sql = "SELECT * FROM produtos";

        List<Produto> produtos = new ArrayList<Produto>();

        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;


        try {
            connection = ConnectionFactory.createConnectionToMySQL();

            pstm = connection.prepareStatement(sql);

            resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                //RECUPERAR PO ID
                produto.setId(resultSet.getInt("id" + ""));
                // RECUPERAR O NOME DO PRODUTO
                produto.setNome(resultSet.getString("nome"));
                // RECUPERAR O PRECO
                produto.setPreco(resultSet.getDouble("preco"));
                // RECUPERAR QUANTIDADE NO ESTOQUE
                produto.setQuantidadeE(resultSet.getInt("quantidadeEstoque"));

                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return produtos;
    }

    // UPDATE
    public void update(Produto produtoNovo) throws SQLException {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidadeEstoque = ? WHERE id = ?;";

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(sql);

            pstm.setString(1, produtoNovo.getNome());
            pstm.setDouble(2, produtoNovo.getPreco());
            pstm.setInt(3, produtoNovo.getQuantidadeE());

            // QUAL ID DESEJA ALTERAR
            pstm.setInt(4, produtoNovo.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(String novoNome, int ID) {
        String sql = "UPDATE produtos SET nome = ? WHERE id = ?;";

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(sql);

            pstm.setString(1, novoNome);
            pstm.setInt(2, ID);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(double novoPreco, int ID) {
        String sql = "UPDATE produtos SET preco = ? WHERE id = ?;";

        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(sql);

            pstm.setDouble(1, novoPreco);
            pstm.setInt(2, ID);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(int quantidadeEstoque, int ID) {
        String sql = "UPDATE produtos SET quantidadeEstoque = ? WHERE id = ?;";

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(sql);

            pstm.setInt(1, quantidadeEstoque);
            pstm.setInt(2, ID);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByID(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?;";

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
