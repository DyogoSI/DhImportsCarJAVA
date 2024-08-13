package carro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carro.model.Vendedor;

public class VendedorDao {

    public void cadastrarVendedor(Vendedor vendedor) {
        String sql = "INSERT INTO vendedor (nome, email, telefone) VALUES (?, ?, ?)";
        PreparedStatement pStatement = null;
        Connection conn = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, vendedor.getNome());
            pStatement.setString(2, vendedor.getEmail());
            pStatement.setString(3, vendedor.getTelefone());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Vendedor> listarVendedores() {
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM vendedor";
        PreparedStatement pStatement = null;
        Connection conn = null;
        ResultSet resultSet = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            resultSet = pStatement.executeQuery();

            while (resultSet.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId(resultSet.getInt("id"));
                vendedor.setNome(resultSet.getString("nome"));
                vendedor.setEmail(resultSet.getString("email"));
                vendedor.setTelefone(resultSet.getString("telefone"));
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pStatement != null) {
                    pStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vendedores;
    }

    public ArrayList<Vendedor> BuscarVendedorPorTelefone(String telefone) {
        String sql = "SELECT * FROM vendedor WHERE telefone LIKE '%" + telefone + "%'";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pStatement = null;
        Vendedor vendedor = null;
        ArrayList<Vendedor> vendedores = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            if (rs != null) {
                vendedores = new ArrayList<>();
                while (rs.next()) {
                    vendedor = new Vendedor();
                    vendedor.setId(rs.getInt("id"));
                    vendedor.setNome(rs.getString("nome"));
                    vendedor.setEmail(rs.getString("email"));
                    vendedor.setTelefone(rs.getString("telefone"));

                    vendedores.add(vendedor);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null)
                    pStatement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return vendedores;
    }

    public void ExcluirVendedor(int id) {
        String sql = "DELETE FROM vendedor WHERE id = ?";
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
                if (pStatement != null)
                    pStatement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    // Método para alterar um vendedor
    public void AlterarVendedor(Vendedor vendedor) {
        String sql = "UPDATE vendedor SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        PreparedStatement pStatement = null;
        Connection conn = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, vendedor.getNome());
            pStatement.setString(2, vendedor.getEmail());
            pStatement.setString(3, vendedor.getTelefone());
            pStatement.setInt(4, vendedor.getId());
            pStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null)
                    pStatement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    // Método para buscar um vendedor por ID
    public Vendedor BuscarVendedorPorId(int id) {
        String sql = "SELECT * FROM vendedor WHERE id = ?";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pStatement = null;
        Vendedor vendedor = null;
        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();
            if (rs != null && rs.next()) {
                vendedor = new Vendedor();
                vendedor.setId(rs.getInt("id"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setEmail(rs.getString("email"));
                vendedor.setTelefone(rs.getString("telefone"));
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
        return vendedor;
    }
}
