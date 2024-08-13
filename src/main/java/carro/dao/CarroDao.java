package carro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import carro.model.Carro;

public class CarroDao {

    public void cadastrarCarro(Carro carro) {
        String sql = "INSERT INTO carro (modelo, marca, ano, preco) VALUES (?, ?, ?, ?)";
        PreparedStatement pStatement = null;
        Connection conn = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, carro.getModelo());
            pStatement.setString(2, carro.getMarca());
            pStatement.setInt(3, carro.getAno());
            pStatement.setDouble(4, carro.getPreco());
            pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public List<Carro> listarCarros() {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carro";
        PreparedStatement pStatement = null;
        Connection conn = null;
        ResultSet resultSet = null;

        try {
            conn = new MySqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            resultSet = pStatement.executeQuery();

            while (resultSet.next()) {
                Carro carro = new Carro();
                carro.setId(resultSet.getInt("id"));
                carro.setModelo(resultSet.getString("modelo"));
                carro.setMarca(resultSet.getString("marca"));
                carro.setAno(resultSet.getInt("ano"));
                carro.setPreco(resultSet.getDouble("preco"));
                carros.add(carro);
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
        return carros;
        
    }
    
    public Carro BuscarCarroPorId(int id) {
    	String sql = "SELECT * FROM carro WHERE id =? ";
    	ResultSet rs = null;
    	Connection conn = null;
    	PreparedStatement pStatement = null;
    	Carro carro = null;
    	try {
    		conn = new MySqlConnection().getConnection();
    		pStatement = conn.prepareStatement(sql);
    		pStatement.setInt(1, id);
    		rs = pStatement.executeQuery();
    		if(rs!=null && rs.next()) {
    			carro = new Carro();
    			carro.setId(rs.getInt("id"));
				carro.setModelo(rs.getString("modelo"));
				carro.setMarca(rs.getString("marca"));
				carro.setAno(rs.getInt("ano"));
				carro.setPreco(rs.getDouble("preco"));	
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pStatement !=null) {
					pStatement.close();	
				}	
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();	
				}	
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
    	return carro;
    	
    }
    
    public ArrayList<Carro>BuscarCarroPorModelo(String modelo){
    	String sql ="SELECT*FROM carro WHERE modelo LIKE'%"+ modelo + "%'";
    	ResultSet rs= null;
    	Connection conn = null;
    	PreparedStatement pStatement =  null;
    	Carro carro = null;
    	ArrayList<Carro> carros = null;
    	
    	try {
    		conn = new MySqlConnection().getConnection();
    		pStatement = conn.prepareStatement(sql);
    		rs = pStatement.executeQuery();
    		if(rs!=null) {
    			carros = new ArrayList<Carro>();
    			while(rs.next()) {
    				carro = new Carro();
    				carro.setId(rs.getInt("id"));
    				carro.setModelo(rs.getString("modelo"));
    				carro.setMarca(rs.getString("marca"));
    				carro.setAno(rs.getInt("ano"));
    				carro.setPreco(rs.getDouble("preco"));
    				carros.add(carro);
    			}
    		}
    			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pStatement !=null)
				   pStatement.close();
			} catch (Exception e2) {
			    e2.printStackTrace();
			}
			
			try {
				if (conn !=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    	 	
    	return carros;
    }
    
    public void ExcluirCarro(int id) {
    	String sql = "DELETE FROM carro WHERE id = ?";
    	PreparedStatement pStatement = null;
    	Connection conn = null;
    	
    	try {
    		conn = new MySqlConnection().getConnection();
    		pStatement = conn.prepareStatement(sql);
    		pStatement.setInt(1, id);
    		pStatement.execute();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pStatement !=null)
				   pStatement.close();
			} catch (Exception e2) {
			    e2.printStackTrace();
			}
			
			try {
				if (conn !=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		  }
		}
    
      public void AlterarCarro(Carro carro) {
    	  String sql = "UPDATE carro SET modelo = ?, marca = ?, ano = ?, preco = ? WHERE id = ?";
    	  PreparedStatement pStatement = null;
    	  Connection conn = null;
    	  
    	  try {
    		
    		  conn = new MySqlConnection().getConnection();
    		  pStatement = conn.prepareStatement(sql);
    		  pStatement.setString(1,carro.getModelo());
    		  pStatement.setString(2,carro.getMarca());
    		  pStatement.setInt(3,carro.getAno());
    		  pStatement.setDouble(4, carro.getPreco());
    		  pStatement.setInt(5,carro.getId());
    		  pStatement.execute(); 	
		} catch (Exception e) {  
			e.printStackTrace();
		}finally{
			try {
				if(pStatement !=null)
				   pStatement.close();
			} catch (Exception e2) {
			    e2.printStackTrace();
			}
			
			try {
				if (conn !=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		  }
		}
    
		
    	  
    	  
    	  
    	  
    	  
    	  
    	  
      }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
