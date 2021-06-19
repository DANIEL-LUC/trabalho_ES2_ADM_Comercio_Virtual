package controle;

import javax.swing.JOptionPane;

import model.Livro;

public class MenuEstoque {
	
	// cadastros de livros automatico, apenas para medidas de 
	// testes. O projeto em si não consta com esses atributos
	static Livro book = new Livro(1,"Piratas do caribe");
	static Livro book1 = new Livro(2,"Harry Potter"); // cadastrando o ID e o nome do book
	static Livro book2 = new Livro(3,"a");
	
	private static String menu = "----------Estoque--------------------"
			+ "\n\n 1--> Pesquisar Estoque"
			+ "\n 2 --> Cadastrar Livro"
			+ "\n 3 --> Remover livro"
			+ "\n 4 --> Adicionar livro no Estoque"
			+ "\n 5 --> Alterar livro do Estoque"
			+ "\n 6 --> Listar Estoque"
			+ "\n 0 --> SAIR";
	
	static Livro livroTemp;
	static String tempString;
	

	public static void start() {
		Estoque.cadastrarLivro(book2, 1);
		Estoque.cadastrarLivro(book, 1);
		Estoque.cadastrarLivro(book1, 1);
		Estoque.cadastrarLivro(book1, 5);
		
		
		boolean decisao = true;
		while(decisao ) {
				switch (JOptionPane.showInputDialog(menu)){
				//MOSTRAR
		        case "1":
		        	pesquisar();
		            break;
		        // CADASTRAR
		        case "2":
		        	cadastrar();
		            break;
		         //REMOVER  LIVRO   
		        case "3":
		        	remover();
		        	break;
		        	// ADICIONAR LIVRO 
		        case "4":
		        	adicionar();
		        	break;
		        //ALTERAR LIVRO
		        case "5":
		        	alterar();
		        	break;
		        	
		        case "6":
		        	listar();
		        	break;
		        case "0":
		        	return;
		            
				}
		}

	}
	
	private static void pesquisar() {
		tempString = JOptionPane.showInputDialog("Digite o nome do livro para pesquisar: ");
    	livroTemp = Estoque.pesquisar(tempString);
    	if(livroTemp != null ){
    	JOptionPane.showMessageDialog(null, Estoque.mostrarLivro(tempString));
    	}else JOptionPane.showMessageDialog(null, "Livro não encontrado, verifique a digitação");
	}
	
	private static void cadastrar() {
		String textInt = JOptionPane.showInputDialog("Digite o Id (codigo) do livro: ");
    	String nomeCadastro = JOptionPane.showInputDialog("Digite o nome do livro: ");
    	String quantidade = JOptionPane.showInputDialog("Digite quantidade de livro: ");
    	Livro cadastro = new Livro(Integer.parseInt(textInt),nomeCadastro);
    	tempString = Estoque.cadastrarLivro(cadastro, Integer.parseInt(quantidade));
    	JOptionPane.showMessageDialog(null, tempString);
	}
	
	private static void remover() {
		String removerLivro = JOptionPane.showInputDialog("Digite o nome do livro para remover: ");
    	livroTemp = Estoque.pesquisar(removerLivro);
    	if(livroTemp != null ){
    	
        	String quantidadeRemover = JOptionPane.showInputDialog("Digite a quantiade de livro que deseja remover: ");
        	
        	int bool = JOptionPane.showConfirmDialog(null,Estoque.mostrarLivro(removerLivro) + "\n"
        	 + " deseja remover " +quantidadeRemover+" livros","Deseja remover esse Livro",JOptionPane.YES_NO_OPTION);
        	System.out.println(bool);
        	
        	if(bool == 0) {
        		Estoque.removerLivro(livroTemp, Integer.parseInt(quantidadeRemover));
        	}else JOptionPane.showMessageDialog(null, "O livro não foi removido !!");
    	}else JOptionPane.showMessageDialog(null, "Livro não encontrado, verifique a digitação");
	}
	
	private static void adicionar() {
		tempString = JOptionPane.showInputDialog("Digite o nome do livro para adicionar: ");
    	livroTemp = Estoque.pesquisar(tempString);
    	if(livroTemp != null ){
    	
        	String quantidadeAdicionar = JOptionPane.showInputDialog("Digite a quantiade de livro que deseja adicionar: ");
        	
        	int bool = JOptionPane.showConfirmDialog(null,Estoque.mostrarLivro(tempString) + "\n"
        	 + " deseja adicionar " +quantidadeAdicionar+" livros","Deseja adicionar esse Livro",JOptionPane.YES_NO_OPTION);
        	System.out.println(bool);
        	
        	if(bool == 0) {
        		Estoque.cadastrarLivro(livroTemp, Integer.parseInt(quantidadeAdicionar));
        	}else JOptionPane.showMessageDialog(null, "O livro não foi adicionado !!");
    	}else JOptionPane.showMessageDialog(null, "Livro não encontrado, verifique a digitação");
    	
	}
	
	private static void alterar() {
		String alterarLivro = JOptionPane.showInputDialog("Digite o nome do livro para alterar: ");
    	livroTemp = Estoque.pesquisar(alterarLivro);
    	if(livroTemp != null ){
    		Estoque.alterarLivro(livroTemp);
    	}else JOptionPane.showMessageDialog(null, "Livro não encontrado, verifique a digitação");
	}
	
	private static void listar() {
		JOptionPane.showMessageDialog(null,Estoque.listarLivros());
	}
	
	
}