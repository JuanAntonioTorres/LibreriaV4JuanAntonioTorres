package vista;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Libro;

public class Validador {
	private static final int LONGITUD_ISBN = 13;
	private GestorErrores gestorErrores;
	
	public Validador(GestorErrores gestorErrores) {
		super();
		this.gestorErrores = gestorErrores;
	}
	
	public boolean comprobarTodos(LogicaGrafica logicaGrafica) {
		return validaDatos(logicaGrafica.panelDatos)&&
				comprobarCajasVacias(logicaGrafica)&&
				!comprobarTextosVacios(logicaGrafica);
	}
	
	public void mostrarMensajeError(String mensaje, boolean error) {
		gestorErrores.mostrarMensaje(mensaje,error);
	}
	 
	
	
	private boolean comprobarTextosVacios(LogicaGrafica logicaGrafica) {
		boolean vacio = false;
		for (int i = 0; i < logicaGrafica.panelDatos.getComponentCount()-1; i++) {
			if((isJTxtfield(logicaGrafica, i)||
					isJTxtfieldIsbn(logicaGrafica, i))&&
					(isEmpty(logicaGrafica, i))){
				vacio = true;
			}
		}
		if(logicaGrafica.panelDatos.getCmbTemas().getSelectedIndex()<1)vacio = true;
		return vacio;
	}

	private boolean isJTxtfieldIsbn(LogicaGrafica logicaGrafica, int i) {
		return logicaGrafica.panelDatos.getComponent(i).getClass().equals(JTextFieldIsbn.class);
	}

	private boolean isEmpty(LogicaGrafica logicaGrafica, int i) {
		return ((JTextField)logicaGrafica.panelDatos.getComponent(i)).getText().isEmpty();
	}

	private boolean isJTxtfield(LogicaGrafica logicaGrafica, int i) {
		return logicaGrafica.panelDatos.getComponent(i).getClass().equals(JTextField.class);
	}
	
	private boolean comprobarCajasVacias(LogicaGrafica logicaGrafica) {
		return !comprobarChecksVacio(logicaGrafica.panelChecks.getPanelEstado()) &&
				!comprobarChecksVacio(logicaGrafica.panelChecks.getPanelFormato());
	}
	
	private boolean comprobarChecksVacio(JPanel panelChecks) {
		boolean vacio = true;
		for (int i = 0; i < panelChecks.getComponentCount(); i++) {
			if(((JCheckBox)panelChecks.getComponent(i)).isSelected()){
				vacio = false;
			}
		}
		return vacio;
	}
	
	public boolean validaDatos(PanelDatos panelDatos) {
		boolean datosCorrectos = true;
		datosCorrectos = comprobarNumPaginas(panelDatos);
		if(datosCorrectos)datosCorrectos = comprobarIsbn(panelDatos);
		return datosCorrectos;
	}

	private boolean comprobarNumPaginas(PanelDatos panelDatos) {
		return validarSoloNumeros(panelDatos.getTxtNumPaginas().getText());
	}

	public boolean comprobarIsbn(PanelDatos panelDatos) {
		String textoIsbn = panelDatos.getTxtISBN().getText();
		return validarLongitud(textoIsbn,LONGITUD_ISBN) && validarSoloNumeros(textoIsbn);
	}

	public boolean comprobarIsbnRepetido(String ISBN , ArrayList<Libro> arrayList) {
		boolean retorno = true;
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i) != null && arrayList.get(i).getIsbn().equals(ISBN)) {
				retorno=false;
				gestorErrores.mostrarMensaje("ISBN REPETIDO",true);
			}
		}
		return retorno;
	}
	
	public boolean validarSoloNumeros(String texto) {
		boolean retorno = true;
		for (int i = 0; i < texto.length(); i++) {
			if(!Character.isDigit(texto.charAt(i))) {
				retorno = false;
			}
		}
	return retorno;
	}

	public boolean validarLongitud(String string, int longitudNib) {
		return string.length()==longitudNib;
	}
}
