package model;

public class Livro {
	private int id;
	private String nome;
	private String autor;
	private String sinopse;
	private String anoEdicao;
	private String tematica;
	private float custo;
	private float precoVenda;
	
	public Livro ( String nome) {
		this.nome = nome;
	}
	
	public Livro(int id, String nome, String autor, float custo) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.custo = custo;
	}
	public Livro (int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		return true;
	}




	public float getCusto() {
		return custo;
	}
	public void setCusto(float custo) {
		this.custo = custo;
	}
	public float getPrecoVendo() {
		return precoVenda;
	}
	public void setPrecoVendo(float precoVendo) {
		this.precoVenda = precoVendo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getAnoEdicao() {
		return anoEdicao;
	}
	public void setAnoEdicao(String anoEdicao) {
		this.anoEdicao = anoEdicao;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	
	
	
}
