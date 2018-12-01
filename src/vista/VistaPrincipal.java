package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;

import modelo.Libro;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final  String TITULOAPLICACION = "LIBRERÍA";
	protected PanelParaBotones panelParaBotones;
	protected PanelChecks panelChecks;
	protected PanelDatos panelDatos;
	protected JList<String> librosDisponibles;
	protected JLabel lblMensajeError;
	
	public VistaPrincipal(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setForeground(new Color(102, 102, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 579);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 94, 75, 114, 22, 56, 91, 28};
		gridBagLayout.rowHeights = new int[]{53, 28, 41, 55, 55, 55, 35, 55, 22, 28, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
			JLabel lblTitulo = new JLabel(TITULOAPLICACION);
			lblTitulo.setForeground(new Color(0, 0, 102));
			lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			GridBagConstraints gbclblTitulo = new GridBagConstraints();
			gbclblTitulo.fill = GridBagConstraints.VERTICAL;
			gbclblTitulo.gridwidth = 8;
			gbclblTitulo.insets = new Insets(0, 0, 5, 5);
			gbclblTitulo.gridx = 0;
			gbclblTitulo.gridy = 0;
			getContentPane().add(lblTitulo, gbclblTitulo);
		
		
		panelDatos = new PanelDatos();
		panelDatos.getTxtTitulo().setMaximumSize(new Dimension(122, 35));
		panelDatos.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbcpanelDatos = new GridBagConstraints();
		gbcpanelDatos.gridheight = 6;
		gbcpanelDatos.gridwidth = 2;
		gbcpanelDatos.fill = GridBagConstraints.BOTH;
		gbcpanelDatos.insets = new Insets(0, 0, 5, 5);
		gbcpanelDatos.gridx = 1;
		gbcpanelDatos.gridy = 2;
		getContentPane().add(panelDatos, gbcpanelDatos);
		
		panelChecks = new PanelChecks();
		panelChecks.setBackground(new Color(255, 255, 255));
		panelChecks.getPanelEstado().setBackground(new Color(255, 255, 255));
		panelChecks.getPanelFormato().setBackground(new Color(255, 255, 255));
		GridBagConstraints gbcPanelChecks = new GridBagConstraints();
		gbcPanelChecks.fill = GridBagConstraints.BOTH;
		gbcPanelChecks.insets = new Insets(0, 0, 5, 5);
		gbcPanelChecks.gridx = 3;
		gbcPanelChecks.gridheight = 6;
		gbcPanelChecks.gridy = 2;
		getContentPane().add(panelChecks, gbcPanelChecks);
		
		JLabel lblEstanteria = new JLabel("Estanter\u00EDa");
		lblEstanteria.setForeground(new Color(102, 51, 0));
		lblEstanteria.setFont(new Font("Segoe Print", Font.BOLD, 30));
		GridBagConstraints gbclblEstanteria = new GridBagConstraints();
		gbclblEstanteria.gridheight = 2;
		gbclblEstanteria.fill = GridBagConstraints.VERTICAL;
		gbclblEstanteria.gridwidth = 2;
		gbclblEstanteria.insets = new Insets(0, 0, 5, 5);
		gbclblEstanteria.gridx = 5;
		gbclblEstanteria.gridy = 1;
		getContentPane().add(lblEstanteria, gbclblEstanteria);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbcscrollPane = new GridBagConstraints();
		gbcscrollPane.insets = new Insets(0, 0, 5, 5);
		gbcscrollPane.gridheight = 5;
		gbcscrollPane.gridwidth = 2;
		gbcscrollPane.fill = GridBagConstraints.BOTH;
		gbcscrollPane.gridx = 5;
		gbcscrollPane.gridy = 3;
		getContentPane().add(scrollPane, gbcscrollPane);
		
		librosDisponibles = new JList<>();
		librosDisponibles.setVisibleRowCount(5);
		librosDisponibles.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		scrollPane.setViewportView(librosDisponibles);
		
		panelParaBotones = new PanelParaBotones();
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.gridwidth = 2;
		gbcPanel.insets = new Insets(0, 0, 5, 5);
		gbcPanel.fill = GridBagConstraints.BOTH;
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 8;
		getContentPane().add(panelParaBotones, gbcPanel);
		panelParaBotones.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblMensajeError = new JLabel("");
		lblMensajeError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajeError.setForeground(Color.RED);
		lblMensajeError.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbcLblError = new GridBagConstraints();
		gbcLblError.gridwidth = 6;
		gbcLblError.fill = GridBagConstraints.BOTH;
		gbcLblError.insets = new Insets(0, 0, 5, 0);
		gbcLblError.gridx = 3;
		gbcLblError.gridy = 9;
		getContentPane().add(lblMensajeError, gbcLblError);	
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpcionesLibro = new JMenu("Opciones");
		menuBar.add(mnOpcionesLibro);
		
		JMenuItem btnAltaMenu = new JMenuItem("Alta libro");
		btnAltaMenu.setName("Alta");
		btnAltaMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				configurarVistaParaAlta();
			}
		});
		mnOpcionesLibro.add(btnAltaMenu);
		
		JMenuItem btnAddUnidadesMenu = new JMenuItem("A\u00F1adir unidades");
		btnAddUnidadesMenu.setName("Unidades");
		btnAddUnidadesMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				configurarVistaParaAddUnidades();
			}
		});
		mnOpcionesLibro.add(btnAddUnidadesMenu);
		
		JMenuItem btnVentaMenu = new JMenuItem("Venta");
		btnVentaMenu.setName("Venta");
		btnVentaMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				configurarVistaParaVenta();
			}
		});
		mnOpcionesLibro.add(btnVentaMenu);
		
		
		JMenuItem btnBajaMenu = new JMenuItem("Baja");
		btnBajaMenu.setName("Baja");
		btnBajaMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				configurarVistaParaBaja();
			}
		});
		mnOpcionesLibro.add(btnBajaMenu);
		
		JMenuItem btnModificarMenu = new JMenuItem("modificar");
		btnModificarMenu.setName("Modificar");
		btnModificarMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				configurarVistaParaModificar();
			}
		});
		mnOpcionesLibro.add(btnModificarMenu);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setName("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		mnOpcionesLibro.add(mntmSalir);
	}

	protected void configurarVistaParaModificar() {
		modoBajaAltaModificar();
		panelParaBotones.ponerBotonModificar();
		panelParaBotones.getBtnModificar().setEnabled(false);
		SwingUtilities.updateComponentTreeUI(this);
	}

	protected void configurarVistaParaBaja() {
		modoBajaAltaModificar();
		panelParaBotones.ponerBotonBaja();
		panelParaBotones.getBtnBaja().setEnabled(false);
		SwingUtilities.updateComponentTreeUI(this);
	}

	private void modoBajaAltaModificar() {
		desactivarPanelDatos();
		desactivarChecks();
		resetearInformacion();
		panelDatos.getTxtISBN().setEnabled(true);
		panelDatos.getTxtUnidadesAdd().setVisible(false);
		panelDatos.getLblUnidadesAdd().setVisible(false);
		SwingUtilities.updateComponentTreeUI(this);
	}

	protected void configurarVistaParaVenta() {
		modoVentaAgregar();
		panelParaBotones.ponerBotonVenta();
		panelParaBotones.getBtnVenta().setEnabled(true);
		SwingUtilities.updateComponentTreeUI(this);
	}

	private void modoVentaAgregar() {
		desactivarPanelDatos();
		desactivarChecks();
		resetearInformacion();
		panelDatos.getTxtUnidadesAdd().setVisible(true);
		panelDatos.getLblUnidadesAdd().setVisible(true);
		panelDatos.getTxtISBN().setEnabled(true);
		panelDatos.getTxtUnidadesAdd().setEnabled(true);
		panelDatos.getLblUnidadesAdd().setEnabled(true);
	}

	protected void configurarVistaParaAddUnidades() {
		modoVentaAgregar();
		panelParaBotones.ponerBotonAgregar();
		panelParaBotones.getBtnAgregar().setEnabled(true);
	}

	protected void configurarVistaParaAlta() {
		modoBajaAltaModificar();
		panelParaBotones.ponerBotonAlta();
		panelParaBotones.getBtnVenta().setEnabled(false);
	}

	public String obtenerEstados() {
		String estado = null;
		for (int i = 0; i < panelChecks.getPanelEstado().getComponentCount(); i++) {
			if(((JCheckBox)panelChecks.getPanelEstado().getComponent(i)).isSelected()){
				estado = ((JCheckBox)panelChecks.getPanelEstado().getComponent(i)).getText();
			}
		}
		return estado;
	}
	
	public void activarPanelesInformacion(boolean activar) {
		activarPanelTodos(activar,panelChecks.getPanelEstado());
		activarPanelTodos(activar,panelChecks.getPanelFormato());
		activarPanelExceptoUltimo(activar,panelDatos);
	}
	
	private void activarPanelTodos(boolean activar,JPanel panel) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			if(panel.getComponent(i).getName() == null ||
					!panel.getComponent(i).getName().equals("ignorar")) {
				panel.getComponent(i).setEnabled(activar); 
			}
		}
	}
	
	private void activarPanelExceptoUltimo(boolean activar,JPanel panel) {
		for (int i = 0; i < panel.getComponentCount()-2; i++) {
			if(panel.getComponent(i).getName() == null ||
					!panel.getComponent(i).getName().equals("ignorar")) {
				panel.getComponent(i).setEnabled(activar);
			}
		}
	}
	
	private void resetearPanelDatos() {
		for (int i = 0; i < panelDatos.getComponentCount(); i++) {
			if(panelDatos.getComponent(i).getClass().equals(JComboBox.class)) {
				((JComboBox<?>)panelDatos.getComponent(i)).setSelectedIndex(0);
			}
			else if (panelDatos.getComponent(i).getClass().equals(JSpinner.class)) {
				((JSpinner)panelDatos.getComponent(i)).getModel().setValue(0);
			}
			else if (!panelDatos.getComponent(i).getClass().equals(JLabel.class)) 
				((JTextComponent)panelDatos.getComponent(i)).setText("");
		}

	}

	private void desactivarChecks() {
		for(int i = 0;i<panelChecks.getComponentCount();i++) {
			for(int j = 0;j<((JPanel)panelChecks.getComponent(i)).getComponentCount();j++) {
				((JCheckBox)((JPanel)panelChecks.getComponent(i)).getComponent(j)).setEnabled(false);
			}
		}
	}

	private void desactivarPanelDatos() {
		for (Component componente: panelDatos.getComponents()) {
			if(!componente.getClass().equals(JLabel.class)) {
				componente.setEnabled(false);
			}
		}
	}		
	
	public void pintarLibro(Libro libro) {
		pintarDatos(libro);
		rellenarPanelEstado(libro);
		rellenarPanelFormato(libro);
	}
	
	public void pintarLista(ArrayList<Libro> arrayList ) {
		librosDisponibles.removeAll();
		DefaultListModel<String>modeloLista=new DefaultListModel<>();
		if(arrayList!=null) {
			for (int i = 0; i < arrayList.size(); i++) {
				modeloLista.addElement(arrayList.get(i).getTitulo());
			}
			librosDisponibles.setModel(modeloLista);
		}
	}
	
	
	
	public void resetearInformacion() {
		resetearPanelDatos();
		ponerTodoPanelEstadoAFalse();
		ponerTodoPanelFormatoAFalse();
	}
	
	private void pintarDatos(Libro libro) {
		panelDatos.getTxtTitulo().setText(libro.getTitulo());
		panelDatos.getTxtAutor().setText(libro.getAutor());
		panelDatos.getTxtEditorial().setText(libro.getAutor());
		pintarComboBox(libro);
		panelDatos.getTxtNumPaginas().setText(String.valueOf(libro.getNumPaginas()));
		panelDatos.getTxtISBN().setText(String.valueOf(libro.getIsbn()));
		panelDatos.getTxtUnidades().setText(String.valueOf(libro.getUnidades()));
	}

	private void pintarComboBox(Libro libro) {
		for (int i = 0; i < panelDatos.getCmbTemas().getModel().getSize(); i++) {
			if(libro.getTema().equals(String.valueOf(panelDatos.getCmbTemas().getModel().getElementAt(i)))) {
				panelDatos.getCmbTemas().setSelectedItem(panelDatos.getCmbTemas().getItemAt(i));
			}
		}
	}
	
	private void rellenarPanelEstado(Libro libro) {
		ponerTodoPanelEstadoAFalse();
		for (int i = 0; i < panelChecks.getPanelEstado().getComponentCount(); i++) {
			if(libro.getEstado().equals(((JCheckBox)panelChecks.getPanelEstado().getComponent(i)).getText())) {
				((JCheckBox)panelChecks.getPanelEstado().getComponent(i)).setSelected(true);
			}
		}
	}
	
	private void ponerTodoPanelEstadoAFalse() {
		panelChecks.getBotonGrupo().clearSelection();
	}

	
	private void ponerTodoPanelFormatoAFalse() {
		panelChecks.getBotonGrupoDos().clearSelection();
	}
	
	private void rellenarPanelFormato(Libro libro) {
		ponerTodoPanelFormatoAFalse();
		for (int j = 0; j < panelChecks.getPanelFormato().getComponentCount(); j++) {
			if(libro.getFormato().equals(((JCheckBox)panelChecks.getPanelFormato().getComponent(j)).getText())) {
				((JCheckBox)panelChecks.getPanelFormato().getComponent(j)).setSelected(true);
			}
		}
	}

	public String obtenerFormatos() {
		String formato = null;
		for (int i = 0; i < panelChecks.getPanelFormato().getComponentCount(); i++) {
			if(((JCheckBox)panelChecks.getPanelFormato().getComponent(i)).isSelected()){
				formato = ((JCheckBox)panelChecks.getPanelFormato().getComponent(i)).getText();
			}
		}
		return formato;
	}
	
	public void resetearMensajeError() {
		this.lblMensajeError.setText("");
	}
	

	public void activarIsbn(boolean activar) {
		panelDatos.getTxtISBN().setEnabled(activar);
	}

	public void borrarTodoMenosIsbn() {
		String isbn = panelDatos.getTxtISBN().getText();
		resetearInformacion();
		this.panelDatos.getTxtISBN().setText(isbn);
	}
	
	public void removerListener(JButton boton) {
		for (int i = 0; i < boton.getActionListeners().length; i++) {
			boton.removeActionListener(boton.getActionListeners()[i]);
		}
	}

	public PanelParaBotones getPanelParaBotones() {
		return panelParaBotones;
	}
	
}