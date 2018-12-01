package acceso;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream{

	public MyObjectOutputStream(OutputStream arg0) throws IOException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void writeStreamHeader() throws IOException {
	}
	
	

}
