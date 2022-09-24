/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author susan
 */
public class LibroVec {
   Libro[] tabLibro;
    int ind;
    private LinkStart linkBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null; 
    
    public LibroVec(){
        this.tabLibro = new Libro[100];
        this.ind=0;
    }
    
     public void saveCli(Libro libro){
        this.tabLibro[this.ind]=libro;  
        this.ind=this.ind+1;
    }
    
    public Libro[] gimmeCli(){
        return this.tabLibro;
    }
   
    public void starConex(){
        linkBD= new LinkStart();
        conexion=linkBD.conectar();
    }
    
    public boolean saveCliBD(Libro libro){        
        String sql = "INSERT INTO biblioteca.libro(codigoBD, nombre_libro, tipo_de_pasta, editorial, anio_publicacion)";
             sql += " VALUES( ?,?,?,?,?)"; 
        try{
            starConex();
            statement = conexion.prepareStatement(sql); 
            
            statement.setInt(1, libro.getCodigo());
            statement.setString(2, libro.getNombre());
            statement.setString(3, libro.getTipo());
            statement.setString(4, libro.getEditorial());
            statement.setString(5, libro.getPublicacion());
             int resultado = statement.executeUpdate(); 
                if(resultado > 0){
                    return true;
                }else{
                    return false;
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            return false;
        }    
    }
    
    public void bdView(StringBuffer out){   
        String sql="select * from biblioteca.libro";
        try{
        starConex();
        out.setLength(0);
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if (result!=null){
                while (result.next()){
                out.append("<tr>");
                out.append("<td >").append(result.getString("codigoBD")).append("</td>");
                out.append("<td >").append(result.getString("nombre_libro")).append("</td>");
                out.append("<td >").append(result.getString("tipo_de_pasta")).append("</td>");
                out.append("<td >").append(result.getString("editorial")).append("</td>");
                out.append("<td >").append(result.getString("anio_publicacion")).append("</td>");
                out.append("<td id=\"").append(result.getString("codigoBD"))
                        .append("\"  onclick=\"eliminarlibro(this.id);\">") 
                        .append(" <a class=\"btn btn-danger\"'> <i class=\"bi bi-trash\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                out.append("error al consultar");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
     public String eliminarlibroBd(int codi){        
        String sql = "DELETE FROM libro WHERE codigoBD="+codi;              
       try{     
            starConex();
            statement = conexion.prepareStatement(sql); 
            int resultado = statement.executeUpdate();
            if(resultado > 0){
                return String.valueOf(resultado);
            }else{
                return String.valueOf(resultado);
            }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    
}
