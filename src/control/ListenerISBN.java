package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;

import vista.LogicaGrafica;

public class ListenerISBN implements KeyListener{

	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerISBN(Logica logica, LogicaGrafica logicaGrafica) {
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		//para que sonarLint este contento
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String isbnNumber = logicaGrafica.obtenerIsbn();
		if(isbnNumber.length()==13) {
			try {
				if(logica.obtenerLibro(isbnNumber)!=null) {
					logicaGrafica.pintarLibro(logica.obtenerLibro(isbnNumber));
					logicaGrafica.activarPanelesInformacion(false);
					logicaGrafica.mostrarMensajeError("El libro ya existe", true);
				}
				else if(logicaGrafica.comprobarIsbn()){
					logicaGrafica.activarPanelesInformacion(true);
				}
				else {
					logicaGrafica.borrarTodoMenosIsbn();
					logicaGrafica.activarPanelesInformacion(false);
					logicaGrafica.activarIsbn(true);
				}
			} catch (IllegalArgumentException | IllegalAccessException | SecurityException | IOException
					| SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else {
			logicaGrafica.borrarTodoMenosIsbn();
			logicaGrafica.activarPanelesInformacion(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
