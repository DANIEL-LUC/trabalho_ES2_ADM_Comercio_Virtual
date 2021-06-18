package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import model.Livro;

public class CarrinhoCompra {
	private static Map<Livro, Integer> carrinho = new HashMap<>();
	private float soma = 0; 
	
	
	

	public void cadastrarLivro(Livro livro, int quantidade) {

		if(carrinho.containsKey(livro)) { // vê se o produto já existe
		
			carrinho.put(livro,  carrinho.get(livro) + quantidade);
			soma += livro.getPrecoVendo() * quantidade;
			
		}else {
			carrinho.put(livro,quantidade); // adiciona 1 produto
			System.out.println(" cadastrado");
			
		}
	}
	
	public ArrayList<Livro> getcarrinho() {
		ArrayList<Livro> listaBook = new ArrayList<Livro>();
		for(Map.Entry<Livro, Integer> entry : carrinho.entrySet()) {
			
			//System.out.println(entry.getKey().getNome() + " --> " + entry.getValue());
			listaBook.add(entry.getKey()); // cria uma lista e adiciona livro por livro 
			
		}
				
		return listaBook;
	}
		
	public Livro pesquisar(String nomeLivro) {
		ArrayList<Livro> listBook = new ArrayList<Livro>();
		listBook = getcarrinho();
		
		try {
			for(int aux = 0; aux < listBook.size(); aux++) {
				if(listBook.get(aux).getNome().equals(nomeLivro)) { // VERIFICA SE O NOME DO LIVRO DIGITADO É IGUAL AO DA LISTA
					return listBook.get(aux);
				}
			}
		}catch (Exception e) {
			//Livro erro = new Livro("ERRO, LIVRO NÃO ENCONTRADO");
			return null;
		}
		//return new Livro("ERRO, LIVRO NÃO ENCONTRADO");
		return null;
	}

	public boolean removerLivro(Livro livro, int quantidade) {
		
		if(carrinho.containsKey(livro)) { // vê se o produto já existe
			carrinho.put(livro,  carrinho.get(livro) - quantidade);
			return true;
		}else return false;
	}
	
	public int quantidadeLivro(Livro livro) {
		return carrinho.get(livro);
	}
		
	public void clear() {
		carrinho.clear();
	}
	
	public String mostrarLivro(String nome) {
		Livro livro = pesquisar(nome);
		if (pesquisar(nome)== null) {
			return null;
		}
		String dados = "--------- LIVRO ----- QUANTIDADES: " + quantidadeLivro(livro) + " -----"
				+ "\n\n\n --> nome: " + livro.getNome()
				+ "\n  --> autor: "  + livro.getAutor()
				+ "\n  --> Sinopse: " + livro.getSinopse()
				+ "\n  --> Ano de Edicao: " + livro.getAnoEdicao()
				+ "\n  --> tematica: " + livro.getTematica()
				+ "\n  --> custo: " + livro.getCusto()
				+ "\n  --> precoVenda: " + livro.getPrecoVendo()
				+ "\n-------------------------------------------------\n";
		
		return dados;
	}
	
	public String listarLivros() {
		String lista = "";
		
		for(Map.Entry<Livro, Integer> entry : carrinho.entrySet()) {
			lista += "\n _-_ ID: " +entry.getKey().getId()+ " -_- " +entry.getKey().getNome() +" -_- quantidade: " +entry.getValue() +""
					+ "-_- $ "+ entry.getKey().getPrecoVendo()*entry.getValue(); 
		}
		lista += "_=_=_=_ TOTAL: $"+ this.getSoma(); 
		
		return lista;
	}
	public float getSoma() {
		return soma;
	}

	public void setSoma(float soma) {
		this.soma = soma;
	}
}

