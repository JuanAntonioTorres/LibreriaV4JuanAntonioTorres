package vista;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class JTextFieldIsbn extends JTextField {
	
	private static final long serialVersionUID = 1L;

	public JTextFieldIsbn() {
		super();
	}

	public JTextFieldIsbn(Document arg0, String arg1, int arg2) {
		super(arg0, arg1, arg2);
	}

	public JTextFieldIsbn(int arg0) {
		super(arg0);
	}

	public JTextFieldIsbn(String arg0, int arg1) {
		super(arg0, arg1);
	}

	public JTextFieldIsbn(String arg0) {
		super(arg0);
	}

	public int obtenerLongitud() {
		return this.getText().length();
	}
	
	public String obtenerTexto() {
		return this.getText();
	}
}
