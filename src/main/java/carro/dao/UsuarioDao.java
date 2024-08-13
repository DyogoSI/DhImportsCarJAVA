package carro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carro.model.Usuario;

public class UsuarioDao {

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (username, senha, papel) VALUES (?, ?, ?)";
        PreparedStatement pStatement = null;
        Connection conn = null;

        try {
            conn = new MySqlConnection().getConnection(); // Verifique se esse método está correto
            if (conn == null) {
                throw new SQLException("A conexão com o banco de dados não foi estabelecida.");
            }
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, usuario.getUsername());
            pStatement.setString(2, usuario.getSenha());
            pStatement.setString(3, usuario.getPapel());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechando recursos em ordem inversa de abertura
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        PreparedStatement pStatement = null;
        Connection conn = null;
        ResultSet resultSet = null;

        try {
            conn = new MySqlConnection().getConnection(); // Verifique se esse método está correto
            if (conn == null) {
                throw new SQLException("A conexão com o banco de dados não foi estabelecida.");
            }
            pStatement = conn.prepareStatement(sql);
            resultSet = pStatement.executeQuery();

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setUsername(resultSet.getString("username"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setPapel(resultSet.getString("papel"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechando recursos em ordem inversa de abertura
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    public ArrayList<Usuario> BuscarUsuarioPorSenha(String senha) {
        String sql = "SELECT * FROM usuario WHERE senha LIKE '%" + senha + "%'";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pStatement = null;
        Usuario usuario = null;
        ArrayList<Usuario> usuarios = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            if (rs != null) {
                usuarios = new ArrayList<>();
                while (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setPapel(rs.getString("papel"));

                    usuarios.add(usuario);
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

        return usuarios;
    }

    public void ExcluirUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
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

    // Método para alterar um usuário
    public void AlterarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET username = ?, senha = ?, papel = ? WHERE id = ?";
        PreparedStatement pStatement = null;
        Connection conn = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, usuario.getUsername());
            pStatement.setString(2, usuario.getSenha());
            pStatement.setString(3, usuario.getPapel());
            pStatement.setInt(4, usuario.getId());
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

    // Método para buscar um usuário por ID
    public Usuario BuscarUsuarioPorId(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pStatement = null;
        Usuario usuario = null;
        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();
            if (rs != null && rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPapel(rs.getString("papel"));
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
        return usuario;
    }
}
