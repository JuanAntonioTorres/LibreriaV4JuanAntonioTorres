package vista;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class PanelDatos extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField txtAutor;
	private JTextField txtNumPaginas;
	private JTextField txtTitulo;
	private JComboBox<String> cmbTemas;
	private JTextFieldIsbn txtISBN;
	private JTextField txtUnidades;
	private JTextField txtUnidadesAdd;
	private JLabel lblUnidadesAdd;
	private JTextField txtEditorial;
	
	
	public PanelDatos() {
		setMaximumSize(new Dimension(400, 550));
		setMinimumSize(new Dimension(120, 320));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{134, 151, 70, 0};
		gridBagLayout.rowHeights = new int[] {0, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22,22, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		JLabel lblLib = new JLabel("ISBN");
		lblLib.setName("ignorar");
		lblLib.setMaximumSize(new Dimension(125, 35));
		lblLib.setHorizontalAlignment(SwingConstants.CENTER);
		lblLib.setMinimumSize(new Dimension(45, 25));
		lblLib.setFont(new Font("AR JULIAN", Font.BOLD, 13));
		GridBagConstraints gbc_lblLib = new GridBagConstraints();
		gbc_lblLib.fill = GridBagConstraints.BOTH;
		gbc_lblLib.insets = new Insets(0, 0, 5, 5);
		gbc_lblLib.gridx = 0;
		gbc_lblLib.gridy = 1;
		add(lblLib, gbc_lblLib);
		
		txtISBN = new JTextFieldIsbn();
		txtISBN.setName("ignorar");
		txtISBN.setToolTipText("numero identificacion 13 digitos Ej 1234567890123");
		txtISBN.setMinimumSize(new Dimension(45, 25));
		txtISBN.setMaximumSize(new Dimension(125, 35));
		txtISBN.setFont(new Font("Dialog", Font.BOLD, 11));
		txtISBN.setColumns(10);
		GridBagConstraints gbc_txtLib = new GridBagConstraints();
		gbc_txtLib.insets = new Insets(0, 0, 5, 5);
		gbc_txtLib.fill = GridBagConstraints.BOTH;
		gbc_txtLib.gridx = 1;
		gbc_txtLib.gridy = 1;
		add(txtISBN, gbc_txtLib);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setMaximumSize(new Dimension(122, 33));
		lblTtulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTtulo.setMinimumSize(new Dimension(55, 25));
		lblTtulo.setToolTipText("");
		lblTtulo.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbclblTtulo = new GridBagConstraints();
		gbclblTtulo.insets = new Insets(0, 0, 5, 5);
		gbclblTtulo.fill = GridBagConstraints.BOTH;
		gbclblTtulo.gridx = 0;
		gbclblTtulo.gridy = 3;
		add(lblTtulo, gbclblTtulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setMaximumSize(new Dimension(122, 33));
		txtTitulo.setMinimumSize(new Dimension(45, 25));
		txtTitulo.setToolTipText("Introduce el titulo\r\n");
		txtTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		txtTitulo.setFont(new Font("Dialog", Font.BOLD, 11));
		txtTitulo.setColumns(10);
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitulo.fill = GridBagConstraints.BOTH;
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 3;
		add(txtTitulo, gbc_txtTitulo);
		
		JLabel lblAutorLibro = new JLabel("Autor");
		lblAutorLibro.setMaximumSize(new Dimension(125, 33));
		lblAutorLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutorLibro.setMinimumSize(new Dimension(45, 24));
		lblAutorLibro.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbclblAutorLibro = new GridBagConstraints();
		gbclblAutorLibro.fill = GridBagConstraints.BOTH;
		gbclblAutorLibro.insets = new Insets(0, 0, 5, 5);
		gbclblAutorLibro.gridx = 0;
		gbclblAutorLibro.gridy = 5;
		add(lblAutorLibro, gbclblAutorLibro);
		
		txtAutor = new JTextField();
		txtAutor.setMaximumSize(new Dimension(125, 35));
		txtAutor.setMinimumSize(new Dimension(45, 25));
		txtAutor.setToolTipText("Introduce el Autor del Libro");
		txtAutor.setFont(new Font("Dialog", Font.BOLD, 11));
		txtAutor.setColumns(10);
		GridBagConstraints gbctxtAutor = new GridBagConstraints();
		gbctxtAutor.insets = new Insets(0, 0, 5, 5);
		gbctxtAutor.fill = GridBagConstraints.BOTH;
		gbctxtAutor.gridx = 1;
		gbctxtAutor.gridy = 5;
		add(txtAutor, gbctxtAutor);
		
		lblUnidadesAdd = new JLabel("Cantidad ud");
		lblUnidadesAdd.setVisible(false);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setToolTipText("editorial");
		lblEditorial.setMinimumSize(new Dimension(45, 24));
		lblEditorial.setMaximumSize(new Dimension(125, 33));
		lblEditorial.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditorial.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblEditorial = new GridBagConstraints();
		gbc_lblEditorial.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEditorial.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditorial.gridx = 0;
		gbc_lblEditorial.gridy = 7;
		add(lblEditorial, gbc_lblEditorial);
		
		txtEditorial = new JTextField();
		txtEditorial.setName("Editorial");
		txtEditorial.setToolTipText("Introduce el Autor del Libro");
		txtEditorial.setMinimumSize(new Dimension(45, 25));
		txtEditorial.setMaximumSize(new Dimension(125, 35));
		txtEditorial.setFont(new Font("Dialog", Font.BOLD, 11));
		txtEditorial.setColumns(10);
		GridBagConstraints gbc_txtEditorial = new GridBagConstraints();
		gbc_txtEditorial.insets = new Insets(0, 0, 5, 5);
		gbc_txtEditorial.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEditorial.gridx = 1;
		gbc_txtEditorial.gridy = 7;
		add(txtEditorial, gbc_txtEditorial);
		
		JLabel lblTemaLibro = new JLabel("Tema");
		lblTemaLibro.setMaximumSize(new Dimension(125, 35));
		lblTemaLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemaLibro.setMinimumSize(new Dimension(45, 25));
		lblTemaLibro.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbclblTemaLibro = new GridBagConstraints();
		gbclblTemaLibro.fill = GridBagConstraints.BOTH;
		gbclblTemaLibro.insets = new Insets(0, 0, 5, 5);
		gbclblTemaLibro.gridx = 0;
		gbclblTemaLibro.gridy = 9;
		add(lblTemaLibro, gbclblTemaLibro);
		
		cmbTemas = new JComboBox<>();
		cmbTemas.setMinimumSize(new Dimension(45, 25));
		cmbTemas.setMaximumSize(new Dimension(125, 35));
		cmbTemas.setPreferredSize(new Dimension(45, 25));
		cmbTemas.setToolTipText("Elige un Tema para tu Libro");
		cmbTemas.setFont(new Font("Dialog", Font.PLAIN, 11));
		cmbTemas.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbTemas.setModel(new DefaultComboBoxModel<String>(new String[] {"","Acción", "Aventuras", "Biograf\u00EDa", "Ciencia", "Ciencia Ficci\u00F3n", "Cine", "Econom\u00EDa", "Gastronom\u00EDa", "Historia", "Inform\u00E1tica", "Medicina", "Misterio", "Naturaleza", "Polic\u00EDaco", "Pol\u00EDtica", "Rom\u00E1ntica", "Teatro", "Terror"}));
		GridBagConstraints gbccmbTemas = new GridBagConstraints();
		gbccmbTemas.insets = new Insets(0, 0, 5, 5);
		gbccmbTemas.fill = GridBagConstraints.BOTH;
		gbccmbTemas.gridx = 1;
		gbccmbTemas.gridy = 9;
		add(cmbTemas, gbccmbTemas);
		
		JLabel lblNumPaginas = new JLabel("Num.Pag");
		lblNumPaginas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPaginas.setMinimumSize(new Dimension(45, 25));
		lblNumPaginas.setMaximumSize(new Dimension(125, 35));
		lblNumPaginas.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbclblNumPaginas = new GridBagConstraints();
		gbclblNumPaginas.fill = GridBagConstraints.BOTH;
		gbclblNumPaginas.insets = new Insets(0, 0, 5, 5);
		gbclblNumPaginas.gridx = 0;
		gbclblNumPaginas.gridy = 11;
		add(lblNumPaginas, gbclblNumPaginas);
		
		txtNumPaginas = new JTextField();
		txtNumPaginas.setName("txtNumPaginas");
		txtNumPaginas.setMaximumSize(new Dimension(125, 35));
		txtNumPaginas.setMinimumSize(new Dimension(45, 25));
		txtNumPaginas.setToolTipText("Introduce las P\u00E1ginas Solo numeros Ej 123");
		txtNumPaginas.setFont(new Font("Dialog", Font.BOLD, 11));
		txtNumPaginas.setColumns(10);
		GridBagConstraints gbc_txtNumPaginas = new GridBagConstraints();
		gbc_txtNumPaginas.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumPaginas.fill = GridBagConstraints.BOTH;
		gbc_txtNumPaginas.gridx = 1;
		gbc_txtNumPaginas.gridy = 11;
		add(txtNumPaginas, gbc_txtNumPaginas);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setMaximumSize(new Dimension(125, 35));
		lblUnidades.setMinimumSize(new Dimension(45, 25));
		lblUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnidades.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblUnidades = new GridBagConstraints();
		gbc_lblUnidades.fill = GridBagConstraints.BOTH;
		gbc_lblUnidades.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidades.gridx = 0;
		gbc_lblUnidades.gridy = 13;
		add(lblUnidades, gbc_lblUnidades);
		
		txtUnidades = new JTextField();
		txtUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnidades.setText("0");
		txtUnidades.setToolTipText("Introduce las P\u00E1ginas Solo numeros Ej 123");
		txtUnidades.setName("Unidades");
		txtUnidades.setMinimumSize(new Dimension(45, 25));
		txtUnidades.setMaximumSize(new Dimension(125, 35));
		txtUnidades.setFont(new Font("Dialog", Font.BOLD, 11));
		txtUnidades.setColumns(10);
		GridBagConstraints gbc_txtUnidades = new GridBagConstraints();
		gbc_txtUnidades.fill = GridBagConstraints.BOTH;
		gbc_txtUnidades.insets = new Insets(0, 0, 5, 5);
		gbc_txtUnidades.gridx = 1;
		gbc_txtUnidades.gridy = 13;
		add(txtUnidades, gbc_txtUnidades);
		lblUnidadesAdd.setName("UnidadesAdd");
		lblUnidadesAdd.setMinimumSize(new Dimension(45, 25));
		lblUnidadesAdd.setMaximumSize(new Dimension(125, 35));
		lblUnidadesAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnidadesAdd.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblUnidadesAdd = new GridBagConstraints();
		gbc_lblUnidadesAdd.fill = GridBagConstraints.BOTH;
		gbc_lblUnidadesAdd.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidadesAdd.gridx = 0;
		gbc_lblUnidadesAdd.gridy = 15;
		add(lblUnidadesAdd, gbc_lblUnidadesAdd);
		
		txtUnidadesAdd = new JTextField();
		txtUnidadesAdd.setVisible(false);
		txtUnidadesAdd.setToolTipText("Introduce las P\u00E1ginas Solo numeros Ej 123");
		txtUnidadesAdd.setText("0");
		txtUnidadesAdd.setName("Unidades");
		txtUnidadesAdd.setMinimumSize(new Dimension(45, 25));
		txtUnidadesAdd.setMaximumSize(new Dimension(125, 35));
		txtUnidadesAdd.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnidadesAdd.setFont(new Font("Dialog", Font.BOLD, 11));
		txtUnidadesAdd.setColumns(10);
		GridBagConstraints gbc_txtEditorial1 = new GridBagConstraints();
		gbc_txtEditorial1.insets = new Insets(0, 0, 5, 5);
		gbc_txtEditorial1.fill = GridBagConstraints.BOTH;
		gbc_txtEditorial1.gridx = 1;
		gbc_txtEditorial1.gridy = 15;
		add(txtUnidadesAdd, gbc_txtEditorial1);
	}

	
	//GETTERS AND SETTERS
	
	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public JTextFieldIsbn getTxtISBN() {
		return txtISBN;
	}

	public JTextField getTxtNumPaginas() {
		return txtNumPaginas;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public JComboBox<String> getCmbTemas() {
		return cmbTemas;
	}

	public JTextField getTxtUnidades() {
		return txtUnidades;
	}

	public JTextField getTxtUnidadesAdd() {
		return txtUnidadesAdd;
	}

	public JLabel getLblUnidadesAdd() {
		return lblUnidadesAdd;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JTextField getTxtEditorial() {
		return txtEditorial;
	}
	
	
}
