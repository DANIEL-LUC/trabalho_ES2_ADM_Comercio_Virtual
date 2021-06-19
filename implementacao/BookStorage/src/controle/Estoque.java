package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import model.Livro;



public class Estoque {
	
	private static Map<Livro, Integer> estoque = new HashMap<>();
	
	public static String cadastrarLivro(Livro livro, int quantidade) {

		if(estoque.containsKey(livro)) { // vê se o produto já existe
		
			estoque.put(livro,  estoque.get(livro) + quantidade);
			return" livro adicionado" ;
			
		}else {
			estoque.put(livro,quantidade); // adiciona 1 produto
			return" cadastrado";
			
		}
	}
	
	public static ArrayList<Livro> getEstoque() {
		ArrayList<Livro> listaBook = new ArrayList<Livro>();
		for(Map.Entry<Livro, Integer> entry : estoque.entrySet()) {
			
			//System.out.println(entry.getKey().getNome() + " --> " + entry.getValue());
			listaBook.add(entry.getKey()); // cria uma lista e adiciona livro por livro 
			
		}
				
		return listaBook;
	}
		
	public static Livro pesquisar(String nomeLivro) {
		ArrayList<Livro> listBook = new ArrayList<Livro>();
		listBook = getEstoque();
		
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

	public static boolean removerLivro(Livro livro, int quantidade) {
		
		if(estoque.containsKey(livro)) { // vê se o produto já existe
			estoque.put(livro,  estoque.get(livro) - quantidade);
			return true;
		}else return false;
	}
	
	public static int quantidadeLivro(Livro livro) {
		return estoque.get(livro);
	}
		
	public static void clear() {
		estoque.clear();
	}
	
	public static String mostrarLivro(String nome) {
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
	
	public static boolean alterarLivro(Livro livro) {

		Livro livroAlterar = livro;
		
		if (pesquisar(livro.getNome())== null) {
			return false;
		}
		
		boolean decisao = true;
		
		while(decisao ) {
			String menu = "--------- ALTERAR DADOS DO LIVRO ----------"
					+ "\n\n\n 1--> nome: " + livroAlterar.getNome()
					+ "\n 2 --> autor: "  + livroAlterar.getAutor()
					+ "\n 3 --> Sinopse: " + livroAlterar.getSinopse()
					+ "\n 4--> Ano de Edicao: " + livroAlterar.getAnoEdicao()
					+ "\n 5 --> tematica: " + livroAlterar.getTematica()
					+ "\n 6 --> custo: " + livroAlterar.getCusto()
					+ "\n 7 --> precoVenda: " + livroAlterar.getPrecoVendo()
					+ "\n 0 --> Sair"
					+ "\n-------------------------------------------------\n";
			
			switch (JOptionPane.showInputDialog(menu)){
	        case "1":
	        	livroAlterar.setNome(JOptionPane.showInputDialog("Digite o nome para alterar:__"));
	            break;
	        case "2":
	        	livroAlterar.setAutor(JOptionPane.showInputDialog("Digite o nome do autor para alterar:__"));
	            break;
	        case "3":
	        	livroAlterar.setSinopse(JOptionPane.showInputDialog("Digite a nova sinopse para alterar:__"));
	            break;
	        case "4":
	        	livroAlterar.setAnoEdicao(JOptionPane.showInputDialog("Digite o ano de edicao para alterar:__"));
	            break;
	        case "5":
	        	livroAlterar.setTematica(JOptionPane.showInputDialog("Digite a tematica para alterar:__"));
	            break;
	        case "6":
	        	String custo = JOptionPane.showInputDialog("Digite o custo para alterar:__");
	        	livroAlterar.setCusto(Float.parseFloat(custo));
	            break;
	        case "7":
	        	String preco = JOptionPane.showInputDialog("Digite o nome do autor para alterar:__");
	        	livroAlterar.setPrecoVendo(Float.parseFloat(preco));
	            break;
	        case "0":
	        	int quantidade = quantidadeLivro(livro);
	        	removerLivro(livro,quantidade);
	        	cadastrarLivro(livroAlterar,quantidade);
	        	return true;
			}//switch
			
		}//while
		
	
		return false;
	}//metodo	

	public static String listarLivros() {
		String lista = "";
		
		for(Map.Entry<Livro, Integer> entry : estoque.entrySet()) {
			lista += "\n _-_ ID: " +entry.getKey().getId()+ " -_- " +entry.getKey().getNome() +" -_- quantidade: " +entry.getValue(); 
		}
		
		return lista;
	}

}//class
