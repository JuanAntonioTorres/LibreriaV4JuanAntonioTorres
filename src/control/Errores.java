package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

public class Errores {


	public Errores(Exception e){
		if (e.getClass().equals(ClassNotFoundException.class) || e.getClass().equals(NullPointerException.class)) {
			JOptionPane.showMessageDialog(null, "Error interno");
		}else if (e.getClass().equals(SQLException.class) || e.getClass().equals(MySQLSyntaxErrorException.class)) {
			JOptionPane.showMessageDialog(null, "Error al hacer la consulta");
		}
	}

}
