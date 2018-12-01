package vista;

import java.awt.Color;
import javax.swing.JLabel;

public class GestorErrores {
	private static final Color COLOR_ERROR_TEXT = Color.red;
	private static final Color COLOR_INFO = Color.green;
	private JLabel lblMensajeError;
	
	public GestorErrores(JLabel lblMensajeError) {
		super();
		this.lblMensajeError = lblMensajeError;
	}
	
	public void mostrarMensaje(String string, boolean error) {
		if(error) lblMensajeError.setForeground(COLOR_ERROR_TEXT);
		else lblMensajeError.setForeground(COLOR_INFO);
		lblMensajeError.setText(string);
	}

	public boolean gestionarErrorNumeroPagina(PanelDatos panelDatos) {
		mostrarMensaje("numero de paginas incorrecto",true);
		return false;
	}
}
