/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuarios;


/**
 *
 * @author fmacz
 */
public class UsuariosDAOJDBC implements UsuariosDAO {
    
    @Override
    public int inserir(Usuarios usuario) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO usuario(id, nome, email, senha) ")
                .append("VALUES (?, ?, ?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {  
            linha = DAOGenerico.executarComando(insert, usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return linha;
    }

    @Override
    public int editar(Usuarios usuario) {
      StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE usuario SET ")
                .append("nome = ?, ")
                .append("email = ?, ")
                .append("senha = ? ")
                .append("WHERE codigo = ?");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = DAOGenerico.executarComando(update, usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return linha; 
    }

    @Override
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM usuarios ")
                .append("WHERE id = ?");
        String delete = sqlBuilder.toString();
        int linha = 0;        
        linha = DAOGenerico.executarComando(delete, codigo);
        return linha;
    }

    @Override
    public List<Usuarios> listar() {
        ResultSet rset;
        String select = "SELECT * FROM usuarios";
        List<Usuarios> usuarios = new ArrayList<>();
        try {        
            rset = DAOGenerico.executarConsulta(select);
            while (rset.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setId(rset.getInt("id"));
                usuario.setNome(rset.getString("nome"));
                usuario.setEmail(rset.getString("email"));
                usuario.setSenha(rset.getString("senha"));
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return usuarios;
    }

    @Override
    public Usuarios listar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
