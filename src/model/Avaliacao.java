package model;

public class Avaliacao {
	private int id;
	private int filmeId;
	private int usuarioId;
	private int nota;
	private String comentario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getusuarioId() {
		return usuarioId;
	}

	public void setusuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getfilmeId() {
		return filmeId;
	}

	public void setfilmeId(int filmeId) {
		this.filmeId = filmeId;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
