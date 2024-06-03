package model;



public class Filme {
	private int id;
	private String titulo;
	private int ano;
	private String genero;
	private int diretorId;

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDiretorId() {
		return diretorId;
	}

	public void setDiretorId(int diretorId) {
		this.diretorId = diretorId;
	}
	
	 @Override
	    public String toString() {
	        return this.titulo;
	    }
}
