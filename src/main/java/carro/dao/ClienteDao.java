package carro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carro.model.Carro;
import carro.model.Cliente;

public class ClienteDao {

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";
        PreparedStatement pStatement = null;
        Connection conn = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cliente.getNome());
            pStatement.setString(2, cliente.getEmail());
            pStatement.setString(3, cliente.getTelefone());
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

    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM cliente";
        PreparedStatement pStatement = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

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
        return clientes;
    }
    
    public Cliente BuscarClientePorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pStatement = null;
        Cliente cliente = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();

            if (rs !=null && rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
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
        return cliente;
    }


    public ArrayList<Cliente> BuscarClientePorNome(String nome) {
        String sql = "SELECT * FROM cliente WHERE nome LIKE '%" + nome + "%'";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pStatement = null;
        Cliente cliente = null;
        ArrayList<Cliente> clientes = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            if (rs != null) {
                clientes = new ArrayList<Cliente>();
                while (rs.next()) {
                    cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));

                    clientes.add(cliente);
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

        return clientes;
    }

    public void ExcluirCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
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

    public void AlterarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        PreparedStatement pStatement = null;
        Connection conn = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cliente.getNome());
            pStatement.setString(2, cliente.getEmail());
            pStatement.setString(3, cliente.getTelefone());
            pStatement.setInt(4, cliente.getId());
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
}
