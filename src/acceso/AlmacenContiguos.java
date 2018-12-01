package acceso;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AlmacenContiguos<T>{

	private File archivo;
	private FileInputStream flujoR;
	private ObjectInputStream adaptadorR;

	public AlmacenContiguos(String ruta) {
		crearArchivo(ruta);
	}

	public boolean guardar(T object) {

		try (ObjectOutputStream bufferW = abrirFlujoW()) {
			bufferW.writeObject(object);
		} catch (IOException e) {
			return false;
		}
		return true;

	}
	public Object recuperar(int posicion) {
		if(posicion>=leer().size())return null;
		Object obj = null;
		try {
			flujoR = new FileInputStream(archivo);
			adaptadorR = new ObjectInputStream(flujoR);
			//como es secuencial y no se el tamano de cada objeto no me queda mas remedio que leer los anteriores
			for (int i = 0; i < posicion; i++) {
				obj = adaptadorR.readObject();
			}
			obj = adaptadorR.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			adaptadorR.close();
			flujoR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public ArrayList<T> leer() {
		ArrayList<T> lista = new ArrayList<>();
		boolean finArchivo = false;
		/** Pongo el abrir flujo en el try catch y así me ahorro el cerrar flujo, 
		 * el propio try se encarga de cerrar el flujo al terminar el bloque
		**/
		try (ObjectInputStream bufferR = abrirFlujoR()) {
			while (!finArchivo) {
				try {
					lista.add((T) bufferR.readObject());
				} catch (EOFException e) {
					finArchivo = true;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			return new ArrayList<T>();
		}
		return lista;
	}

	public T buscar(T buscado) {
		T obj = null;
		T auxiliar = null;
		boolean encontrado = false, finArchivo = false;
		try (ObjectInputStream bufferR = abrirFlujoR()) {
			while (!encontrado && !finArchivo) {
				try {
					auxiliar = (T) bufferR.readObject();
					if (auxiliar.equals(buscado)) {
						obj = auxiliar;
						encontrado=true;
					}
				} catch (EOFException e) {
					finArchivo = true;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
		return obj;
	}

	private void crearArchivo(String ruta) {
		archivo = new File(ruta);
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO: controlar error

			}
		}
	}

	private ObjectOutputStream abrirFlujoW() throws IOException {
		if (archivo.length() > 0) {
			// el true del segundo parametro es para que no sobreescriba
			return new MyObjectOutputStream(new FileOutputStream(archivo, true)); 
		}
		return new ObjectOutputStream(new FileOutputStream(archivo));
	}

	private ObjectInputStream abrirFlujoR() throws IOException {
		return new ObjectInputStream(new FileInputStream(archivo));
	}

}
