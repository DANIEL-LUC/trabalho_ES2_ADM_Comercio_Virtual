package model;

import javax.swing.JOptionPane;

public class Principal {
	static Estoque estoque = new Estoque();
	
	static Livro book = new Livro(1,"Piratas do caribe");
	static Livro book1 = new Livro(2,"Harry Potter"); // cadastrando o ID e o nome do book
	static Livro book2 = new Livro(3,"Liga da Justiça");
	
	
	
	
	static String menu = "------------------------------"
			+ "\n\n 1--> Pesquisar estoque"
			+ "\n 2 --> Cadastrar Livro"
			+ "\n 0 --> SAIR";
	public static void main(String[] args) {
		estoque.cadastrarLivro(book2, 1);
		estoque.cadastrarLivro(book, 1);
		estoque.cadastrarLivro(book1, 1);
		estoque.cadastrarLivro(book1, 5);
		
		boolean decisao = true;
		while(decisao ) {
				switch (JOptionPane.showInputDialog(menu)){
		        case "1":
		        	String nome = JOptionPane.showInputDialog("Digite o nome do livro para pesquisar: ");
		        	
		        	JOptionPane.showMessageDialog(null, estoque.mostrarLivro(nome));
		            break;
		        case "2":
		        	String textInt = JOptionPane.showInputDialog("Digite o Id (codigo) do livro: ");
		        	String nomeCadastro = JOptionPane.showInputDialog("Digite o nome do livro: ");
		        	String quantidade = JOptionPane.showInputDialog("Digite quantidade de livro: ");
		        	
		        	Livro cadastro = new Livro(Integer.parseInt(textInt),nomeCadastro);
		        	estoque.cadastrarLivro(cadastro, Integer.parseInt(quantidade));
		            break;
		        case "0":
		        	return;
		            
				}
		}

	}
	
}