package modelo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Libro implements Serializable{
	private String isbn;
	private String titulo;
	private String autor;
	private String tema;
	private int numPaginas;
	private String formato;
	private String estado;
	private String editorial;
	private int unidades;
	
	public Libro(ArrayList<?> params) throws IllegalArgumentException, IllegalAccessException, SecurityException {
	    Field[] declaredFields = this.getClass().getDeclaredFields();
	    for (int i = 0; i < params.size(); i++) {
	      declaredFields[i].set(this, params.get(i));
	    }
	  }

	public boolean esIgualQue(Libro libro) {
		if(this.autor.equals(libro.getAutor()))return false;
		if(this.editorial.equals(libro.getEditorial()))return false;
		if(this.estado.equals(libro.getEstado()))return false;
		if(this.formato.equals(libro.getFormato()))return false;
		if(this.numPaginas==libro.getNumPaginas())return false;
		if(this.tema.equals(libro.getTema()))return false;
		if(this.titulo.equals(libro.getTitulo()))return false;
		return (this.unidades==libro.getUnidades());
	}

	public String getIsbn() {
		return isbn;
	}
	
	public int getUnidades() {
		return unidades;
	}

	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getTema() {
		return tema;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public String getFormato() {
		return formato;
	}
	public String getEstado() {
		return estado;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getEditorial() {
		return editorial;
	}

}
