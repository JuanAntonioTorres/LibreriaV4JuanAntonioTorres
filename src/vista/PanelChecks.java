package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Dimension;

public class PanelChecks extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel panelFormato;
	private JPanel panelEstado;
	private ButtonGroup botonGrupoDos;
	private ButtonGroup botonGrupo;
	public PanelChecks() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(150, 450));
		setMinimumSize(new Dimension(150, 300));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{170, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panelFormato = new JPanel();
		panelFormato.setPreferredSize(new Dimension(122, 333));
		panelFormato.setBackground(new Color(255, 255, 255));
		panelFormato.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "FORMATO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelFormato = new GridBagConstraints();
		gbc_panelFormato.insets = new Insets(0, 0, 5, 0);
		gbc_panelFormato.fill = GridBagConstraints.BOTH;
		gbc_panelFormato.gridx = 0;
		gbc_panelFormato.gridy = 0;
		add(panelFormato, gbc_panelFormato);
		panelFormato.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
		panelEstado = new JPanel();
		panelEstado.setPreferredSize(new Dimension(122, 222));
		panelEstado.setBackground(new Color(255, 255, 255));
		panelEstado.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "ESTADO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelEstado = new GridBagConstraints();
		gbc_panelEstado.fill = GridBagConstraints.BOTH;
		gbc_panelEstado.gridx = 0;
		gbc_panelEstado.gridy = 1;
		add(panelEstado, gbc_panelEstado);
		panelEstado.setLayout(new GridLayout(0, 1, 0, 0));
		
		botonGrupo = new ButtonGroup();
		
		botonGrupoDos = new ButtonGroup();
	}
	
	
	
	public ButtonGroup getBotonGrupoDos() {
		return botonGrupoDos;
	}



	public ButtonGroup getBotonGrupo() {
		return botonGrupo;
	}



	public JPanel getPanelFormato() {
		return panelFormato;
	}

	public JPanel getPanelEstado() {
		return panelEstado;
	}
	
}
