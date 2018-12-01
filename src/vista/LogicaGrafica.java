package vista;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import control.ListenerBotonAgregar;
import control.ListenerBotonAlta;
import control.ListenerBotonBaja;
import control.ListenerBotonModificar;
import control.ListenerCompruebaAlta;
import control.ListenerISBN;
import control.ListenerVenta;
import control.Logica;
import control.MouseListenerLista;
import modelo.Libro;

public class LogicaGrafica extends VistaPrincipal{
	private static final long serialVersionUID = 1L;
	private Validador validador;
	private int libroSeleccionado;

	public LogicaGrafica() throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		super();
		this.validador = new Validador(new GestorErrores(lblMensajeError));
		iniciarPanelFormatos(new Logica().obtenerFormatos());
		iniciarPanelEstado(new Logica().obtenerEstados());
		asignarListenersYpintarLista();
	}
	
	
	public Libro crearLibro(ArrayList<Libro> arrayList,boolean paraGuardar) throws IllegalArgumentException, IllegalAccessException, SecurityException {
		ArrayList<Object> datosLibro  =new ArrayList<>();
		datosLibro.add(panelDatos.getTxtISBN().getText());
		datosLibro.add(panelDatos.getTxtTitulo().getText());
		datosLibro.add(panelDatos.getTxtAutor().getText());
		datosLibro.add((String) panelDatos.getCmbTemas().getSelectedItem());
		datosLibro.add(Integer.valueOf(panelDatos.getTxtNumPaginas().getText()));
		datosLibro.add(obtenerFormatos());
		datosLibro.add(obtenerEstados());
		datosLibro.add(panelDatos.getTxtEditorial().getText());
		datosLibro.add(Integer.valueOf(panelDatos.getTxtUnidades().getText()));
		if(paraGuardar) {
			if(validador.comprobarIsbnRepetido(panelDatos.getTxtISBN().getText(),arrayList)) {
				return new Libro(datosLibro);
			}
			else return null;
		}
		else return new Libro(datosLibro);
	}
	
	public void mostrarMensajeError(String mensaje, boolean error) {
		this.validador.mostrarMensajeError(mensaje,error);
	}

	public void iniciarPanelFormatos(ArrayList<String> formatos) {
		for (String formato : formatos) {
			JCheckBox checkBox = new JCheckBox(formato);
			checkBox.setBackground(new Color(255, 255, 255));
			checkBox.setFont(new Font("Dialog", Font.BOLD, 14));
			panelChecks.getPanelFormato().add(checkBox);
			panelChecks.getBotonGrupoDos().add(checkBox);
		}
	}
	
	public void iniciarPanelEstado(ArrayList<String> estados) {
		for (String estado : estados) {
			JCheckBox checkBox = new JCheckBox(estado);
			checkBox.setBackground(new Color(255, 255, 255));
			checkBox.setFont(new Font("Dialog", Font.BOLD, 14));
			panelChecks.getPanelEstado().add(checkBox);
			panelChecks.getBotonGrupo().add(checkBox);
		}
	}
	
	public void actualizarLibroActual() {
		this.libroSeleccionado = librosDisponibles.getSelectedIndex();
	}

	public int getPosicionLibroActual() {
		return this.libroSeleccionado;
	}
	
	private boolean comprobarTodos() {
		return validador.comprobarTodos(this);
	}
	
	
	
	public boolean comprobarIsbn() {
		return validador.comprobarIsbn(panelDatos);
	}
	
	public boolean comprobarSIActivarAlta() {
		resetearMensajeError();
		return comprobarTodos();
	}
	
	private void asignarListenersYpintarLista() throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		Logica logica = new Logica();
		ponerListenerEnBotones(logica);
		ponerMouseListenerEnListaLibro(logica);
		ponerListenerEnPanelDatos(logica);
		ponerListenerEnChecks();
		pintarLista(logica.getLibros());
	}

	private void ponerMouseListenerEnListaLibro(Logica logica) {
		this.librosDisponibles.addMouseListener(new MouseListenerLista(logica , this));
	}

	private void ponerListenerEnChecks() {
		ponerListenerEnFormato();
		ponerListenerEnEstado();
	}

	private void ponerListenerEnBotones(Logica logica) {
		this.panelParaBotones.getBtnAlta().addActionListener(new ListenerBotonAlta(logica, this));
		this.panelParaBotones.getBtnBaja().addActionListener(new ListenerBotonBaja(logica, this));
		this.panelParaBotones.getBtnModificar().addActionListener(new ListenerBotonModificar(logica, this));
		this.panelParaBotones.getBtnVenta().addActionListener(new ListenerVenta(logica,this));
		this.panelParaBotones.getBtnAgregar().addActionListener(new ListenerBotonAgregar(logica, this));
	}

	private void ponerListenerEnPanelDatos(Logica logica) {
		for (int i = 0; i < panelDatos.getComponentCount(); i++) {
			if(isIsbnTxtField(i)) {
				ponerListenerIsbn(logica, i);
			}
			else if(isJTxtField(i)) {
				ponerListenerEnJtxFields(i);
			}
		}
	}

	private void ponerListenerEnJtxFields(int i) {
		((JTextField)panelDatos.getComponent(i)).addKeyListener(new ListenerCompruebaAlta(this));
	}

	private boolean isJTxtField(int i) {
		return panelDatos.getComponent(i).getClass().equals(JTextField.class);
	}

	private void ponerListenerIsbn(Logica logica, int i) {
		((JTextFieldIsbn)panelDatos.getComponent(i)).addKeyListener(new ListenerISBN(logica,this));
	}

	private boolean isIsbnTxtField(int i) {
		return panelDatos.getComponent(i).getClass().equals(JTextFieldIsbn.class);
	}
	
	private void ponerListenerEnEstado() {
		for (int i = 0; i < panelChecks.getPanelEstado().getComponentCount(); i++) {
			((JCheckBox)panelChecks.getPanelEstado().getComponent(i)).addActionListener(new ListenerCompruebaAlta(this));
		}
	}

	private void ponerListenerEnFormato() {
		for (int i = 0; i < panelChecks.getPanelFormato().getComponentCount(); i++) {
			((JCheckBox)panelChecks.getPanelFormato().getComponent(i)).addActionListener(new ListenerCompruebaAlta(this));
		}
	}

	public String obtenerIsbn() {
		return panelDatos.getTxtISBN().getText();
	}

	public int obtenerUnidades() {
		return Integer.parseInt(panelDatos.getTxtUnidadesAdd().getText());
	}
	
	
}
