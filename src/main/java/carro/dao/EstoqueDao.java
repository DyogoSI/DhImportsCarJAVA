package carro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carro.model.Estoque;

public class EstoqueDao {

    // Método para cadastrar um novo estoque
    public void cadastrarEstoque(Estoque estoque) {
        String sql = "INSERT INTO estoque (quantidade, descricao) VALUES (?, ?)";

        try (Connection conn = new MySqlConnection().getConnection();
             PreparedStatement pStatement = conn.prepareStatement(sql)) {
            
            pStatement.setInt(1, estoque.getQuantidade());
            pStatement.setString(2, estoque.getDescricao());
            pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar estoque", e);
        }
    }

    // Método para listar todos os estoques
    public List<Estoque> listarEstoques() {
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT * FROM estoque";

        try (Connection conn = new MySqlConnection().getConnection();
             PreparedStatement pStatement = conn.prepareStatement(sql);
             ResultSet resultSet = pStatement.executeQuery()) {

            while (resultSet.next()) {
                Estoque estoque = new Estoque();
                estoque.setId(resultSet.getInt("id"));
                estoque.setQuantidade(resultSet.getInt("quantidade"));
                estoque.setDescricao(resultSet.getString("descricao"));
                estoques.add(estoque);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar estoques", e);
        }

        return estoques;
    }

    // Método para buscar um estoque por descrição
    public ArrayList<Estoque> BuscarEstoquePorDescricao(String descricao) {
        String sql = "SELECT * FROM estoque WHERE descricao LIKE '%" + descricao + "%'";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pStatement = null;
        Estoque estoque = null;
        ArrayList<Estoque> estoques = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            if (rs != null) {
                estoques = new ArrayList<>();
                while (rs.next()) {
                    estoque = new Estoque();
                    estoque.setId(rs.getInt("id"));
                    estoque.setQuantidade(rs.getInt("quantidade"));
                    estoque.setDescricao(rs.getString("descricao"));
                    estoques.add(estoque);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return estoques;
    }

    // Método para excluir um estoque
    public void ExcluirEstoque(int id) {
        String sql = "DELETE FROM estoque WHERE id = ?";
        PreparedStatement pStatement = null;
        Connection conn = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            pStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    // Método para alterar um estoque
    public void AlterarEstoque(Estoque estoque) {
        String sql = "UPDATE estoque SET quantidade = ?, descricao = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pStatement = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, estoque.getQuantidade());
            pStatement.setString(2, estoque.getDescricao());
            pStatement.setInt(3, estoque.getId());
            pStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    // Método para buscar um estoque por ID
    public Estoque BuscarEstoquePorId(int id) {
        String sql = "SELECT * FROM estoque WHERE id = ?";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pStatement = null;
        Estoque estoque = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();

            if (rs != null && rs.next()) {
                estoque = new Estoque();
                estoque.setId(rs.getInt("id"));
                estoque.setQuantidade(rs.getInt("quantidade"));
                estoque.setDescricao(rs.getString("descricao"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return estoque;
    }
}
