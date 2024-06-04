package model;

public class MediaFilme {
	private String titulo;
	private double media;

	public MediaFilme(String titulo, double media) {
		super();
		this.titulo = titulo;
		this.media = media;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

}
