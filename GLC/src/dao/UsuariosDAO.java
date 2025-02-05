/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Usuarios;
import java.sql.*;

/**
 *
 * @author fmacz
 */
public interface UsuariosDAO {
    public int inserir(Usuarios usuario);
    public int editar(Usuarios usuario);
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException;
    public List<Usuarios> listar();
    public Usuarios listar(int codigo);
}
