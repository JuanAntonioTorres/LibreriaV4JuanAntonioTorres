package vista;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelParaBotones extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnModificar;
	private JButton btnVenta;
	private JButton btnAgregar;
	
	public PanelParaBotones() {
		btnAlta = new JButton("Alta");
		btnAlta.setName("Alta");
		btnBaja = new JButton("Baja");
		btnBaja.setName("Baja");
		btnModificar = new JButton("Modificar");
		btnModificar.setName("Modificar");
		btnVenta = new JButton("Venta");
		btnVenta.setName("Venta");
		btnAgregar = new JButton("Agregar");
		btnAgregar.setName("Agregar");
	}
	
	public void ponerBotonAlta() {
		ponerBoton(btnAlta);
	}
	
	public void ponerBotonBaja() {
		ponerBoton(btnBaja);
	}
	
	public void ponerBotonModificar() {
		ponerBoton(btnModificar);
	}
	
	public void ponerBotonVenta() {
		ponerBoton(btnVenta);
	}

	public void ponerBotonAgregar() {
		ponerBoton(btnAgregar);
	}
	
	private void ponerBoton(JButton boton) {
		removerBotonActual();
		add(boton);
		boton.setEnabled(false);
	}
	
	private void removerBotonActual() {
		removeAll();
	}

	public JButton getBtnAlta() {
		return btnAlta;
	}

	public JButton getBtnBaja() {
		return btnBaja;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnVenta() {
		return btnVenta;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	
	
}
