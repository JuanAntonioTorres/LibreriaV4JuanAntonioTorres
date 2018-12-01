package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vista.LogicaGrafica;

public class ListenerCompruebaAlta implements ActionListener,KeyListener{
	
	private LogicaGrafica logicaGrafica;
	
	public ListenerCompruebaAlta(LogicaGrafica logicaGrafica) {
		super();
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (logicaGrafica.comprobarSIActivarAlta()) {
			logicaGrafica.getPanelParaBotones().getComponent(0).setEnabled(true);
		}
		else {
			logicaGrafica.getPanelParaBotones().getComponent(0).setEnabled(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (logicaGrafica.comprobarSIActivarAlta()) {
			logicaGrafica.getPanelParaBotones().getComponent(0).setEnabled(true);
		}
		else {
			logicaGrafica.getPanelParaBotones().getComponent(0).setEnabled(false);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0){
		//para que sonarLint este contento
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		//para que sonarLint este contento
	}
	
}
