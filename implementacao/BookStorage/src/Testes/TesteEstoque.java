package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import controle.Estoque;
import model.Livro;

public class TesteEstoque {

	
	Estoque estoque = new Estoque();

	@Before
	public void iniciar() {
		
		estoque.clear();
	}
	
	@Test
	public void adicionaEstoque() {
		Livro book = new Livro(10,"rola");
		ArrayList<Livro> lista;
		estoque.cadastrarLivro(book, 1);
		
		lista = estoque.getEstoque(); 
		
		System.out.println(lista.get(0).getNome());
	}

	@Test
	public void pesquisar() {
		Livro book = new Livro(1,"Piratas do caribe");
		Livro book1 = new Livro(2,"Harry Potter"); // cadastrando o ID e o nome do book
		Livro book2 = new Livro(3,"Liga da Justiça");
		
		
		estoque.cadastrarLivro(book2, 1);
		estoque.cadastrarLivro(book, 1);
		estoque.cadastrarLivro(book1, 1);
		estoque.cadastrarLivro(book1, 5);
		
		
		//System.out.println(estoque.pesquisar("Pirado nas rolinhas").getNome());
		System.out.println("\n\n +++ \n " + estoque.quantidadeLivro(book1));
		
		
		
		estoque.alterarLivro(book2);
		//JOptionPane.showMessageDialog(null, estoque.mostrarLivro(book2));
	}
	
	@Test
	public void remover() {
		Livro book1 = new Livro(2,"Harry Potter");
		estoque.cadastrarLivro(book1, 5);
		estoque.removerLivro(book1, 2 );
		
		System.out.println("\n\n +++ \n " + estoque.quantidadeLivro(book1));
	}
}
